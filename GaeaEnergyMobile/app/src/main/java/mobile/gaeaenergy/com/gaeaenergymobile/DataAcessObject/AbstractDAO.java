package mobile.gaeaenergy.com.gaeaenergymobile.DataAcessObject;

import android.database.sqlite.SQLiteDatabase;

import mobile.gaeaenergy.com.gaeaenergymobile.Models.DBModel;

/**
 * Created by Jean on 10/12/2017.
 */

public abstract class AbstractDAO {

    protected SQLiteDatabase db;
    protected DBModel db_helper;

    protected final void Open(){
        db = db_helper.getWritableDatabase();
    }

    protected final void Close(){
        db_helper.close();
    }
}
