package com.example.jeanfernandes.meutreino.persistence;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.jeanfernandes.meutreino.models.IMC;

import java.util.ArrayList;

public class IMCPersistence extends DBO {

    private Context __context;
    private String[] colunas = new String[]{
            IMC.COLUNA_ID,
            IMC.COLUNA_IMC
    };

    public IMCPersistence(Context __context) {
        this.__context = __context;
    }

    public long insert(final Double imc){
        this.open();
        ContentValues values = new ContentValues();
        values.put(IMC.COLUNA_IMC, imc);
        long ret = this.db.insert(IMC.TABELA_NOME, null, values);
        this.close();
        return ret;
    }

    public IMC getOne(){
        this.open();
        ArrayList<IMC> list = new ArrayList<>();

        Cursor cur = this.db.query(
                IMC.TABELA_NOME,
                this.colunas,
                null,
                null,
                IMC.COLUNA_IMC,
                null,
                null);

        cur.moveToFirst();
        this.close();
        return  this.relacionalToObject(cur);
    }

    private IMC relacionalToObject(final Cursor __cur){
        IMC i = new IMC();
        i.set__id((int) __cur.getLong(0));
        i.setImc(__cur.getDouble(1));
        return i;
    }
}
