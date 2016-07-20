package us.antenado.sthetosample.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import us.antenado.sthetosample.R;
import us.antenado.sthetosample.StethoSample;
import us.antenado.sthetosample.db.ControllerDB;

/**
 * Created by isilva on 19/07/16.
 */
public class SqliteActivity extends AppCompatActivity {

    Button bt_save;
    EditText et_name, et_age;
    TextView tv_db_response;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sqlite);

        bt_save = (Button) findViewById(R.id.bt_save);
        et_name = (EditText) findViewById(R.id.et_name);
        et_age = (EditText) findViewById(R.id.et_age);
        tv_db_response = (TextView) findViewById(R.id.tv_db_content);

        final ControllerDB db = new ControllerDB(this);

        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String result = db.insertData(et_name.getText().toString(),
                        et_age.getText().toString());

                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                finish();
                startActivity(getIntent());
            }
        });

        tv_db_response.setText(db.getAllData());

    }
}
