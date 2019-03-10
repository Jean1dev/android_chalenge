package com.example.jeanfernandes.meutreino.persistence;

import android.content.ContextWrapper;
import android.database.sqlite.SQLiteDatabase;

import java.io.File;

public abstract class DBO {

    protected SQLiteDatabase db;
    protected DBOpenHelper __db;

    protected final void open(){
        this.db = this.__db.getWritableDatabase();
    }

    protected final void close(){
        this.__db.close();
    }

    public boolean doesDatabaseExist(ContextWrapper context, String dbName) {
        File dbFile = context.getDatabasePath(dbName);
        return dbFile.exists();
    }
}
