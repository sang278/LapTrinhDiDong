package vn.edu.ntu.intent_dl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class Login1Activity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_USER_TO_MAIN = "KEY_USER_TO_MAIN";
    public static final String KEY_PASSWORD_TO_MAIN = "KEY_PASSWORD_TO_MAIN";

    public static final String KEY_USER_FROM_REGISTER = "KEY_USER_FROM_REGISTER";

    public static final int REQUEST_CODE_REGISTER = 1;

    private Context context;

    private EditText editUserName;
    private EditText editPassword;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        context = this;

        connectView();
    }

    private void connectView() {
        editUserName = (EditText) findViewById(R.id.editUserName);
        editPassword = (EditText) findViewById(R.id.editPassword);

        progressBar = (ProgressBar) findViewById(R.id.progressLogin);

        findViewById(R.id.btnLogin).setOnClickListener(this);
        findViewById(R.id.btnRegister).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnLogin:
                login();
                break;
            case R.id.btnRegister:
                register();
                break;
        }
    }

    private void login() {
        boolean error = false;

        showProgress(true);
        // when process we must have sometime

        // get data
        String userName = editUserName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();

        // password empty
        if (TextUtils.isEmpty(password)) {
            editPassword.requestFocus();
            editPassword.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // username empty
        if (TextUtils.isEmpty(userName)) {
            editUserName.requestFocus();
            editUserName.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

        // all data is ok
        showProgress(false);

        if (!error) {
            // create intent to show Main Activity
            Intent intent = new Intent(context, MainActivity.class);

            // send data if need
            intent.putExtra(KEY_USER_TO_MAIN, userName);
            intent.putExtra(KEY_PASSWORD_TO_MAIN, password);

            // start Main Activity
            startActivity(intent);
        }
    }

    private void register() {
        Intent intent = new Intent(context, RegisterActivity.class);
        startActivityForResult(intent, REQUEST_CODE_REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE_REGISTER && resultCode == Activity.RESULT_OK) {
            String userName = data.getStringExtra(KEY_USER_FROM_REGISTER);
            editUserName.setText(userName);
            editPassword.requestFocus();
        }
    }

    private void showProgress(boolean isShow) {
        progressBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
        findViewById(R.id.login_form).setVisibility(!isShow ? View.VISIBLE : View.GONE);
    }
}