package com.example.challenge06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CustomerActivity extends AppCompatActivity {

    public static final int LOGIN_REQUEST_CODE = 105;
    public static final int MENU_REQUEST_CODE = 106;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);
    }

    public void backToMenu(View v){
        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
        startActivityForResult(intent, MENU_REQUEST_CODE);
        finish();
    }

    public void backToLogin(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivityForResult(intent, LOGIN_REQUEST_CODE);
        finish();
    }
}