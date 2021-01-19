package com.example.challenge04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView inputMessage = findViewById(R.id.editTextTextMultiLine);
        TextView inputByteCount = findViewById(R.id.textView);
        Button sendButton = findViewById(R.id.sendButton);
        Button eraseButton = findViewById(R.id.eraseButton);

        sendButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String message = inputMessage.getText().toString();
                Toast.makeText(getApplicationContext(), "전송할 메세지:\n"+message,
                        Toast.LENGTH_LONG).show();
            }
        });

        eraseButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                inputMessage.setText(null);
            }
        });

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                byte[] bytes = null;
                try{
                    bytes = s.toString().getBytes("EUC-KR");
                    int cnt = bytes.length;
                    inputByteCount.setText(cnt + " / 80바이트");
                }catch (UnsupportedEncodingException errors){
                    errors.printStackTrace();
                }
            }
            @Override
            public void afterTextChanged(Editable s) {
                String str = s.toString();
                try{
                    byte[] strBytes = str.getBytes("EUC-KR");
                    // 80 바이트 이상 입력할 시 더 이상 작성하지 못하도록
                    if(strBytes.length > 80){
                        s.delete(s.length()-2, s.length()-1);
                    }
                }catch (UnsupportedEncodingException errors){
                    errors.printStackTrace();
                }
            }
        };
        inputMessage.addTextChangedListener(watcher);
    }
}