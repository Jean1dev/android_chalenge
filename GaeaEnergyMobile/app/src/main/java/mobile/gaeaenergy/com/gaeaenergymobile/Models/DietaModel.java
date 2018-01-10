package mobile.gaeaenergy.com.gaeaenergymobile.Models;

import java.util.Date;

/**
 * Created by Jean on 09/01/2018.
 */

public class DietaModel {

    public static final String TABELA_NOME      = "DietaInfo";
    public static final String COLUNA_ID        = "_id";
    public static final String COLUNA_DATA      = "data"  ;
    public static final String COLUNA_INFO      = "info";
    public static final String COLUNA_QTD       = "qtd";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABELA_NOME + "(" + COLUNA_ID + " INTEGER PRIMARY KEY autoincrement,"
            + COLUNA_DATA + " TEXT"
            + COLUNA_QTD + " REAL"
            + COLUNA_INFO + " TEXT)";

    public static final  String DROP_TABLE = "drop table if exists " + TABELA_NOME;

    private long id;
    private Date data;
    private String info;
    private double qtd;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getQtd() {
        return qtd;
    }

    public void setQtd(double qtd) {
        this.qtd = qtd;
    }
}
