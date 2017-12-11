package mobile.gaeaenergy.com.gaeaenergymobile.Helper;

import android.content.Context;
import android.text.Editable;

import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by Jean on 10/12/2017.
 */

public class Helper {

    private String insert_valor = "http://neuraapi-net.umbler.net/methods/insert_valor.php";

    public Helper(){

    }

    public boolean send(double value, Context context){
        final int aux;
        Ion.with(context)
                .load(insert_valor)
                .setBodyParameter("valor", String.valueOf(value))
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                    }
                });
        return true;
    }

    public double tratar(Editable txt){
        double retorno;
        String aux = String.valueOf(txt);
        retorno = Double.parseDouble(aux);

        return retorno;
    }
}
