package com.example.jeanfernandes.meutreino.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jeanfernandes.meutreino.models.IMC;

public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String BANCO_NOME = "mydb.db";
    private static final int BANCO_VERSAO = 1;


    public DBOpenHelper(Context context) {
        super(context, BANCO_NOME, null, BANCO_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(IMC.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
