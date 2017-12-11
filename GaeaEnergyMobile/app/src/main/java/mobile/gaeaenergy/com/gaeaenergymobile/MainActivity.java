package mobile.gaeaenergy.com.gaeaenergymobile;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;

import mobile.gaeaenergy.com.gaeaenergymobile.DataAcessObject.CurrencyDAO;
import mobile.gaeaenergy.com.gaeaenergymobile.Helper.Helper;
import mobile.gaeaenergy.com.gaeaenergymobile.Models.CurrencyModel;

public class MainActivity extends AppCompatActivity {

    private Button sair;
    private Button sum;
    private Button sub;
    private Button insert;
    private Button delete;
    private Button send;
    private EditText number;
    private TextView texto;
    private CurrencyDAO mydb;
    private double CURRENCY_VALUE;
    private long CURRENCY_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mydb = new CurrencyDAO(this);

        sair    =(Button) findViewById(R.id.finish);
        sum     = (Button) findViewById(R.id.sum);
        sub     = (Button) findViewById(R.id.sub);
        insert  = (Button) findViewById(R.id.inserir);
        delete  = (Button) findViewById(R.id.delete);
        send    = (Button) findViewById(R.id.send);
        number  = (EditText) findViewById(R.id.txtnumber);
        texto   = (TextView) findViewById(R.id.Valor);

        try {
            if(mydb.Select() > 0){
                CurrencyModel model = mydb.getDados();
                CURRENCY_VALUE = model.getMvalor();
                CURRENCY_ID = model.getId();

                texto.setText((String.valueOf(CURRENCY_VALUE)));
            }else{
                texto.setText("SEM VALOR");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("DEU PAU");
        }

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable aux = number.getText();
                double calculo = CURRENCY_VALUE + Double.parseDouble(String.valueOf(aux));
                CURRENCY_VALUE = calculo;
                refreshValue();
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Editable aux = number.getText();
                double calculo = CURRENCY_VALUE + Double.parseDouble(String.valueOf(aux));
                CURRENCY_VALUE = calculo;
                refreshValue();
            }
        });

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CURRENCY_VALUE = new Helper().tratar(number.getText());
                if(mydb.Insert(CURRENCY_VALUE, 0) > 1){
                    Toast.makeText(MainActivity.this, "INSERIDO", Toast.LENGTH_SHORT).show();
                    number.setText("");
                }else {
                    Toast.makeText(MainActivity.this, "PROBLEMA AO INSERIR", Toast.LENGTH_SHORT).show();
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mydb.Delete(CURRENCY_ID) > 1){
                    Toast.makeText(MainActivity.this, "SUCESSO", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "PROBLEMAS", Toast.LENGTH_SHORT).show();
                }
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Helper p = new Helper();
                p.send(CURRENCY_VALUE, getBaseContext());
            }
        });

        sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        texto.setText((String.valueOf(CURRENCY_VALUE)));
    }

    public void refreshValue(){
        texto.setText((String.valueOf(CURRENCY_VALUE)));
    }
}
