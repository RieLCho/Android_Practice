package com.example.challenge06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int MENU_REQUEST_CODE = 101;
    Button button;
    EditText inputID;
    EditText inputPW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button2);
        inputID = (EditText)findViewById(R.id.editTextTextID);
        inputPW = (EditText)findViewById(R.id.editTextTextPassword);
    }

    public void onLoginClicked(View v){
        if(!checkLogin()){
            Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 다시 확인해주세요.",
                    Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
            startActivityForResult(intent, MENU_REQUEST_CODE);
            finish();
        }
    }

    public boolean checkLogin(){
        if(inputID.length()>0 && inputPW.length()>0){
            return true;
        }else{
            return false;
        }
    }
}