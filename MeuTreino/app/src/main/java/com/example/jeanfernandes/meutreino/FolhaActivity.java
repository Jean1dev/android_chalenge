package com.example.jeanfernandes.meutreino;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.jeanfernandes.meutreino.models.FolhaModel;

public class FolhaActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtSalario;
    private EditText txtAumento;
    private EditText txtNovoSalario;
    private Button btnCalcular;
    private FolhaModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_folha);

        this.txtNome = (EditText) findViewById(R.id.folha_nome);
        this.txtSalario = (EditText) findViewById(R.id.folha_salario);
        this.txtAumento = (EditText) findViewById(R.id.folha_aumento);
        this.txtNovoSalario = (EditText) findViewById(R.id.folha_novoSaldo);
        this.btnCalcular = (Button) findViewById(R.id.btn_calc_folha);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                action_btnCalcular();
            }
        });
    }

    private void gravar(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("nome", model.getNome());
        edit.putFloat("salario", model.getSalario().floatValue());
        edit.apply();
    }

    private void getInfo(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        model.setNome(pref.getString("nome", "vazio"));
        model.setSalario(Double.valueOf(pref.getFloat("salario", 0)));
    }

    private void preencheProps(){
        this.model.setNome(this.txtNome.getText().toString());
        this.model.setSalario(Double.valueOf(this.txtSalario.getText().toString()));
    }

    private void action_btnCalcular(){
        this.preencheProps();
        this.model.calcularNovoSaldo();
        this.exibeAlerta("Salario alterado");
        this.txtAumento.setText(this.model.getAumento().toString());
        this.txtNovoSalario.setText(this.model.getNovoSaldo().toString());
    }

    private void exibeAlerta(String msg){
        AlertDialog alert = new AlertDialog.Builder(this).create();
        alert.setTitle("Atencao");
        alert.setMessage(msg);
        alert.setButton(AlertDialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.model = new FolhaModel();
        this.getInfo();
        this.preencheProps();
    }
}
