package mobile.gaeaenergy.com.gaeaenergymobile.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jean on 10/12/2017.
 */

public class DBModel extends SQLiteOpenHelper {

    public static final String  BANCO_NOME = "mydb.db";
    public static final int VERSAO_BD = 1;

    public DBModel(Context context){
        super(context, BANCO_NOME, null, VERSAO_BD);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CurrencyModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
