package vn.edu.ntu.intent_dl;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Context context;

    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        connectView();
        getData();
    }

    private void connectView() {
        tvMain = (TextView) findViewById(R.id.tvMain);
    }

    private void getData() {
        String userName = getIntent().getStringExtra(LoginActivity.KEY_USER_TO_MAIN);
        String password = getIntent().getStringExtra(LoginActivity.KEY_PASSWORD_TO_MAIN);

        String helloText = context.getResources().getString(R.string.login_success);
        helloText = completeText(helloText, new String[]{userName, password});
        tvMain.setText(helloText);
    }

    private String completeText(String source, String[] items) {
        for (int i = 0; i < items.length; i++) {
            source = source.replace("{" + i + "}", items[i]);
        }
        return source;
    }
}