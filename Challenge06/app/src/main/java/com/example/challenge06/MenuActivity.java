package com.example.challenge06;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    public static final int MENU_REQUEST_CODE = 101;
    public static final int CUSTOMER_REQUEST_CODE = 102;
    public static final int SALES_REQUEST_CODE = 103;
    public static final int PRODUCT_REQUEST_CODE = 104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void customerManagement(View v){
        Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
        startActivityForResult(intent, CUSTOMER_REQUEST_CODE);
        finish();
    }

    public void salesManagement (View v){
        Intent intent = new Intent(getApplicationContext(), SalesActivity.class);
        startActivityForResult(intent, SALES_REQUEST_CODE);
        finish();
    }

    public void productManagement(View v){
        Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
        startActivityForResult(intent, PRODUCT_REQUEST_CODE);
        finish();
    }

}