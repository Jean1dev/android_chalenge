package mobile.gaeaenergy.com.gaeaenergymobile.Models;

/**
 * Created by Jean on 10/12/2017.
 */

public class CurrencyModel {

    public static final String TABELA_NOME      = "Currency";
    public static final String COLUNA_ID        = "_id";
    public static final String COLUNA_MY_VALUE  = "Mvalor";
    public static final String COLUNA_PAI_VALUE = "Pvalor";

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + TABELA_NOME + "(" + COLUNA_ID + " INTEGER PRIMARY KEY autoincrement,"
            + COLUNA_MY_VALUE + " REAL,"
            + COLUNA_PAI_VALUE + " REAL)";

    public static final  String DROP_TABLE = "drop table if exists " + TABELA_NOME;

    private long id;
    private double Mvalor;
    private double Pvalor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMvalor() {
        return Mvalor;
    }

    public void setMvalor(double mvalor) {
        Mvalor = mvalor;
    }

    public double getPvalor() {
        return Pvalor;
    }

    public void setPvalor(double pvalor) {
        Pvalor = pvalor;
    }
}
