package com.example.challenge05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MenuActivity extends AppCompatActivity {
    public static final int CUSTOMER_CALLBACK = 102;
    public static final int SALES_CALLBACK = 103;
    public static final int PRODUCT_CALLBACK = 104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void customerManagement(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        setResult(CUSTOMER_CALLBACK, intent);
        finish();
    }

    public void salesManagement(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        setResult(SALES_CALLBACK, intent);
        finish();
    }

    public void productManagement(View v){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        setResult(PRODUCT_CALLBACK, intent);
        finish();
    }
}