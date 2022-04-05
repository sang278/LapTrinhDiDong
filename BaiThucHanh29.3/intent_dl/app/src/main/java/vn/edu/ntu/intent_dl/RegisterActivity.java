package vn.edu.ntu.intent_dl;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Context context;

    private EditText editUserName;
    private EditText editPassword;
    private EditText editRePassword;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        context = this;

        connectView();
    }

    private void connectView() {
        editUserName = (EditText) findViewById(R.id.editUserName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        editRePassword = (EditText) findViewById(R.id.editRePassword);

        progressBar = (ProgressBar) findViewById(R.id.progressLogin);

        findViewById(R.id.btnRegister).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btnRegister:
                register();
                break;
        }
    }

    private void register() {
        boolean error = false;

        showProgress(true);
        // when process we must have sometime

        // get data
        String userName = editUserName.getText().toString().trim();
        String password = editPassword.getText().toString().trim();
        String rePassword = editRePassword.getText().toString().trim();

        // password empty
        if (TextUtils.isEmpty(rePassword)) {
            editRePassword.requestFocus();
            editRePassword.setError(context.getResources().getString(R.string.error_field_required));
            error = true;
        }

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

        if (!password.equals(rePassword)) {
            editRePassword.requestFocus();
            editRePassword.setError(context.getResources().getString(R.string.error_password_not_match));
            error = true;
        }

        // all data is ok
        showProgress(false);

        if (!error) {
            // create intent to send data back Login Activity
            Intent intent = new Intent();

            // send data
            intent.putExtra(LoginActivity.KEY_USER_FROM_REGISTER, userName);

            setResult(RESULT_OK, intent);
            finish();
        }
    }

    private void showProgress(boolean isShow) {
        progressBar.setVisibility(isShow ? View.VISIBLE : View.GONE);
        findViewById(R.id.login_form).setVisibility(!isShow ? View.VISIBLE : View.GONE);
    }
}
