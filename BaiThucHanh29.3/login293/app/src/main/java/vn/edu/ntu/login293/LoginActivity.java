package vn.edu.ntu.login293;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText edtTitle,edtdes,edtmail;
    private Button btnxn;

    public static final String TITLE = "TITLE";
    public static final String DES = "DES";
    public static final String MAIL = "MAIL";
    public LoginActivity()
    {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtTitle = (EditText) findViewById(R.id.edt_Title);
        edtdes = (EditText) findViewById(R.id.edt_des);
        edtdes = (EditText) findViewById(R.id.edt_mail);
        btnxn = (Button) findViewById(R.id.btn_xn);

        btnxn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = edtTitle.getText().toString();
                String des = edtdes.getText().toString();
                String mail = edtmail.getText().toString();
                byExtras(title,des,mail);

            }
        });


    }
    public void byExtras(String Title, String des, String mail)
    {
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        intent.putExtra(TITLE,Title);
        intent.putExtra(DES,des);
        intent.putExtra(MAIL,mail);
        startActivity(intent);
    }
}