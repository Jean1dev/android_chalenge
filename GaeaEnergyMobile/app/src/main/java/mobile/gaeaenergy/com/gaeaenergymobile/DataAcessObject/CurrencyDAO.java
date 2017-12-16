package mobile.gaeaenergy.com.gaeaenergymobile.DataAcessObject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Path;

import java.sql.ResultSet;
import java.sql.SQLException;

import mobile.gaeaenergy.com.gaeaenergymobile.Models.CurrencyModel;
import mobile.gaeaenergy.com.gaeaenergymobile.Models.DBModel;

/**
 * Created by Jean on 10/12/2017.
 */

public class CurrencyDAO extends AbstractDAO {

    private Context io_context;

    private String[] colunas = {
            CurrencyModel.COLUNA_ID,
            CurrencyModel.COLUNA_MY_VALUE,
            CurrencyModel.COLUNA_PAI_VALUE
    };

    public CurrencyDAO(final Context context){
        this.io_context = context;
        db_helper = new DBModel(this.io_context);
    }

    public long Insert(final double myValue, final double paiValue){
        Open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(CurrencyModel.COLUNA_MY_VALUE, myValue);
        contentValues.put(CurrencyModel.COLUNA_PAI_VALUE, paiValue);

        long retorno = db.insert(CurrencyModel.TABELA_NOME, null, contentValues);

        Close();
        return retorno;
    }

    public void  Update(final double myValue, final double paiValue){
        Open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(CurrencyModel.COLUNA_MY_VALUE, myValue);
        contentValues.put(CurrencyModel.COLUNA_PAI_VALUE, paiValue);

        //long retorno = db.update(CurrencyModel.TABELA_NOME, contentValues
        //,null, myValue);
        String sql = "UPDATE "+ CurrencyModel.TABELA_NOME + "SET " + CurrencyModel.COLUNA_MY_VALUE + " = "+ myValue + ","+ CurrencyModel.COLUNA_PAI_VALUE + "=" + paiValue;
        System.out.println(sql);

        db.execSQL(sql);

        Close();
    }

    public Cursor getCursor(){
        Open();
        String sql = "SELECT _id, Mvalor, Pvalor FROM " + CurrencyModel.TABELA_NOME;

        Cursor cursor = db.rawQuery(sql, null);

        Close();
        return cursor;
    }

    public CurrencyModel getDados(){
        Open();
        String sql = "SELECT _id, Mvalor, Pvalor FROM " + CurrencyModel.TABELA_NOME;

        Cursor cursor = db.rawQuery(sql, null);

        CurrencyModel model = new CurrencyModel();

        cursor.moveToLast();

        model.setId(cursor.getColumnIndex("_id"));
        model.setMvalor(cursor.getColumnIndex("Mvalor"));
        model.setPvalor(cursor.getColumnIndex("Pvalor"));

        Close();
        return model;
    }

    public long Delete(final long id){
        Open();

        long retorno = db.delete(CurrencyModel.TABELA_NOME, CurrencyModel.COLUNA_ID + " = '" + id + "'", null);

        Close();
        return retorno;
    }

    public long DeleteALL(){
        Open();
        long retorno;
        String sql = "DELETE * FROM " + CurrencyModel.TABELA_NOME;

        retorno = db.delete(CurrencyModel.TABELA_NOME, null, null);

        Close();
        return retorno;
    }

    public int Select() throws SQLException {
        int retorno = 0;
        Open();
        String sql = "SELECT * FROM " + CurrencyModel.TABELA_NOME;

        Cursor res = db.rawQuery(sql, null);
        res.moveToFirst();
        while (res.moveToNext()){
            retorno++;
        }

        Close();
        return retorno;
    }
}
