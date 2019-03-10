package com.example.jeanfernandes.meutreino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jeanfernandes.meutreino.models.IMC;
import com.example.jeanfernandes.meutreino.persistence.IMCPersistence;
import com.example.jeanfernandes.meutreino.utils.Ferramentas;

public class IMCActivity extends AppCompatActivity {

    private IMCPersistence db;
    private EditText mPeso;
    private EditText mAltura;
    private EditText mPesoideal;
    private EditText mIMC;
    private EditText mText;
    private Button btn_calcular;
    private Button btn_limpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        this.db = new IMCPersistence(this);

        this.btn_limpar = (Button)findViewById(R.id.imc_btn_limpar);
        this.btn_calcular = (Button)findViewById(R.id.imc_btn_calcular);
        this.mPeso = (EditText)findViewById(R.id.txt_peso);
        this.mAltura = (EditText)findViewById(R.id.txt_altura);
        this.mPesoideal = (EditText)findViewById(R.id.imc_peso_ideal);
        this.mIMC = (EditText)findViewById(R.id.imc_imc);
        this.mText = (EditText)findViewById(R.id.imc_text);

        //ACTIONS
        this.btn_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();
            }
        });

        this.btn_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpar();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(this.db.doesDatabaseExist(this, "mydb.db")){
            IMC i = this.db.getOne();
            this.mIMC.setText(i.getImc().toString());
        }
    }

    private void limpar(){
        this.mPeso.setText("");
        this.mAltura.setText("");
        this.mPesoideal.setText("");
        this.mIMC.setText("");
        this.mText.setText("");
    }

    private void calcular(){
        IMC i = new IMC(
                Double.parseDouble(this.mAltura.getText().toString()),
                Double.parseDouble(this.mPeso.getText().toString())
        );
        this.mText.setText(i.resolver());
        this.mPesoideal.setText(i.getPesoIdeal().toString());
        this.mIMC.setText(i.getImc().toString());
        this.cadastrar(i);
    }

    private void cadastrar(IMC obj){
        this.db.insert(obj.getImc());
    }
}
