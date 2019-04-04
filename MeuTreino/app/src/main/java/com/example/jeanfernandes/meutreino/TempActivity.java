package com.example.jeanfernandes.meutreino;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class TempActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnLimpar, btnSalavar;
    CardView card1, card2, card3, card4, card5, card6, card7, card8, card9;
    List<Integer> chanfis = new ArrayList<>();
    List<Button> botoes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.temp_layout);


        card1 = (CardView) findViewById(R.id.card_view1);
        card2 = (CardView) findViewById(R.id.card_view2);
        card3 = (CardView) findViewById(R.id.card_view3);
        card4 = (CardView) findViewById(R.id.card_view4);
        card5 = (CardView) findViewById(R.id.card_view5);
        card6 = (CardView) findViewById(R.id.card_view6);
        card7 = (CardView) findViewById(R.id.card_view7);
        card8 = (CardView) findViewById(R.id.card_view8);
        card9 = (CardView) findViewById(R.id.card_view9);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnSalavar = (Button) findViewById(R.id.Salvar);

        botoes.add(btn1);
        botoes.add(btn2);
        botoes.add(btn3);
        botoes.add(btn4);
        botoes.add(btn5);
        botoes.add(btn6);
        botoes.add(btn7);
        botoes.add(btn8);
        botoes.add(btn9);

        btnSalavar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t = (EditText) findViewById(R.id.edtMesa);
                limpar(Integer.parseInt(t.getText().toString()));
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CardView c = (findViewById(R.id.card_view1));
                c.setBackgroundColor(getCor(R.color.colorAccent));
                chanfis.add(2);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getCor(R.color.colorAccent));
                chanfis.add(2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getCor(R.color.colorAccent));
                chanfis.add(2);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getCor(R.color.colorAccent));
                chanfis.add(2);
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getCor(R.color.colorAccent));
                chanfis.add(2);
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getCor(R.color.colorAccent));
                chanfis.add(2);
            }
        });

        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getCor(R.color.colorAccent));
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getCor(R.color.colorAccent));
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn1.setBackgroundColor(getCor(R.color.colorAccent));
            }
        });
    }

    private void limpar(int nMesa){


        btn_temp.setBackgroundColor(getCor(R.color.colorPrimaryDark));
    }


    public int hex2Rgb(String colorStr) {
        int color = Color.parseColor(colorStr);
        return color;
    }

    public int getCor(int color){
        return ContextCompat.getColor( this, color);
    }

    public void salvar() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor edit = pref.edit();
        for(Integer i: chanfis){
            edit.putInt(String.valueOf(i), i);
        }
        edit.apply();
    }

    public void carregar(){
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        for(Integer i: chanfis){
           this.pintaVermelho(pref.getInt(String.valueOf(i), i));
        }
    }

    private void pintaVermelho(int nMesa){
        if(nMesa == 0){
            return;
        }
        Button btn_temp = botoes.get(nMesa + 1);
        btn_temp.setBackgroundColor(getCor(R.color.colorAccent));
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.carregar();
    }
}
