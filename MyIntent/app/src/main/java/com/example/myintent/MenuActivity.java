package com.example.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                // 인텐트를 사용하여 다른 액티비티에 데이터를 전달 할 수 있음.
                // name이라는 key 값으로 mike라는 값을 저장.
                intent.putExtra("name", "mike");
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}