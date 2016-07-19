package us.antenado.sthetosample.Activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import us.antenado.sthetosample.R;
import us.antenado.sthetosample.StethoSample;

/**
 * Created by isilva on 18/07/16.
 */
public class JsonPostActivity extends AppCompatActivity {

    StethoSample app;
    Button bt_post;
    EditText et_title, et_body, et_userid;
    TextView tv_post_response;
    String url = "http://jsonplaceholder.typicode.com/posts";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_json_post);

        app = (StethoSample) getApplication();

        bt_post = (Button) findViewById(R.id.bt_post);
        et_title = (EditText) findViewById(R.id.et_title);
        et_body = (EditText) findViewById(R.id.et_body);
        et_userid = (EditText) findViewById(R.id.et_userid);
        tv_post_response = (TextView) findViewById(R.id.tv_post_response);

        bt_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    postJson();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void postJson() throws IOException, JSONException {

        JSONObject payload = new JSONObject();
        payload.put("title", et_title.getText())
                .put("body", et_body.getText())
                .put("userId", et_userid.getText());

        MediaType JSON = MediaType.parse("application/json; charset=utf-8");

        RequestBody body = RequestBody.create(JSON, payload.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        app.httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                final String responseData = response.body().string();

                JsonPostActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        JsonPostActivity.this.tv_post_response.setText(responseData);
                    }
                });

            }
        });

    }
}
