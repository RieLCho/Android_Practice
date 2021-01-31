package com.example.challenge05;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE = 101;
    private static final int CUSTOMER_CALLBACK = 102;
    private static final int SALES_CALLBACK = 103;
    private static final int PRODUCT_CALLBACK = 104;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToMainMenu(View v){
        Intent intent = new Intent(this, MenuActivity.class);
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == REQUEST_CODE){
            if(resultCode == CUSTOMER_CALLBACK){
                Toast.makeText(getApplicationContext(), "고객 관리에서 돌아왔습니다.", Toast.LENGTH_SHORT).show();
            }
            else if(resultCode == SALES_CALLBACK){
                Toast.makeText(getApplicationContext(), "매출 관리에서 돌아왔습니다.", Toast.LENGTH_SHORT).show();
            }
            else if(resultCode == PRODUCT_CALLBACK){
                Toast.makeText(getApplicationContext(), "상품 관리에서 돌아왔습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}