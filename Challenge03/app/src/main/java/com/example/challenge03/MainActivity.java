package com.example.challenge03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView1, imageView2;
    ImageButton button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);
        button1 = findViewById(R.id.imageButton);
        button2 = findViewById(R.id.imageButton2);

        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                imageUp();
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                imageDown();
            }
        });

        // init
        imageUp();
    }

    private void imageUp(){
        imageView1.setImageResource(R.drawable.angelic);
        imageView2.setImageResource(0);
    }

    private void imageDown(){
        imageView1.setImageResource(0);
        imageView2.setImageResource(R.drawable.angelic);
    }

}