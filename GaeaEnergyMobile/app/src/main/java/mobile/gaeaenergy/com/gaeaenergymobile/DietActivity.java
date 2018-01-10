package mobile.gaeaenergy.com.gaeaenergymobile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import mobile.gaeaenergy.com.gaeaenergymobile.DataAcessObject.DietDAO;

public class DietActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button btn_gravar;
    private EditText txt_info;
    private EditText txt_qtd;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diet);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        final DietDAO mydb = new DietDAO(this);

        btn_gravar = (Button) findViewById(R.id.btn_gravar);
        btn_gravar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt_info = (EditText) findViewById(R.id.txtInfo);
                txt_qtd = (EditText) findViewById(R.id.txtQtd);

                String aux_txt_info = txt_info.getText().toString();
                double aux_txt_qtd = Double.parseDouble(txt_qtd.getText().toString());

                if(mydb.Insert(aux_txt_info, aux_txt_qtd) != 0){
                    Toast.makeText(DietActivity.this, "CADASTRADO", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(DietActivity.this, "ERRO", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
