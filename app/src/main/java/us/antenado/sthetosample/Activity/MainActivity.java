package us.antenado.sthetosample.Activity;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import okhttp3.OkHttpClient;
import us.antenado.sthetosample.BuildConfig;
import us.antenado.sthetosample.R;

public class MainActivity extends AppCompatActivity {

    Button btn_json_get, btn_json_post, btn_image_get, btn_shared_preferences, btn_sqlitedb;
    public static OkHttpClient httpClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Build", BuildConfig.BUILD_TYPE);

        btn_json_get = (Button) findViewById(R.id.btn_json_get);
        btn_json_post = (Button) findViewById(R.id.btn_json_post);
        btn_image_get = (Button) findViewById(R.id.btn_image_get);
        btn_shared_preferences = (Button) findViewById(R.id.btn_shared_preferences);
        btn_sqlitedb = (Button) findViewById(R.id.btn_sqlitedb);

        btn_json_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartActivity(JsonGetActivity.class);
            }
        });

        btn_json_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartActivity(JsonPostActivity.class);
            }
        });

        btn_image_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartActivity(ImageGetActivity.class);
            }
        });

        btn_shared_preferences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStartActivity(SharedPreferencesActivity.class);
            }
        });


    }


    private void mStartActivity(Class activity){
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}
