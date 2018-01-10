package mobile.gaeaenergy.com.gaeaenergymobile.DataAcessObject;

import android.content.ContentValues;
import android.content.Context;

import mobile.gaeaenergy.com.gaeaenergymobile.Models.DBModel;
import mobile.gaeaenergy.com.gaeaenergymobile.Models.DietaModel;

/**
 * Created by Jean on 09/01/2018.
 */

public class DietDAO extends AbstractDAO {

    private Context io_context;

    private String[] colunas = {
            DietaModel.COLUNA_ID,
            DietaModel.COLUNA_DATA,
            DietaModel.COLUNA_INFO,
            DietaModel.COLUNA_QTD
    };

    public DietDAO(final  Context context){
        this.io_context = context;
        db_helper = new DBModel(this.io_context);
    }

    public long Insert(final String info, final double qtd){
        Open();

        ContentValues ctv = new ContentValues();
        ctv.put(DietaModel.COLUNA_INFO, info);
        ctv.put(DietaModel.COLUNA_QTD, qtd);

        long retorno = db.insert(DietaModel.TABELA_NOME, null, ctv);
        Close();

        return retorno;
    }
}
