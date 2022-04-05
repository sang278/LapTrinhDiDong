package vn.edu.ntu.intent_dongian;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
    }
    public void QuayVe(View v){
        Intent iManHinhCHINH = new Intent(this, MainActivity.class);
        startActivity(iManHinhCHINH);
    }
}