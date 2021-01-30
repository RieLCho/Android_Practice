package com.example.samplepdfview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    EditText editText = findViewById(R.id.editText);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButton1Clicked(View v){
        String fileName = editText.getText().toString();
        if(fileName != null){
            openPDF(fileName.trim());
        }else{
            Toast.makeText(getApplicationContext(),"PDF 파일명을 입력해주세요.",
                    Toast.LENGTH_LONG).show();
        }
    }

    public void openPDF(String fileName){
        String sdCardFolder = Environment.getExternalStorageDirectory().getAbsolutePath();
        String filePath = sdCardFolder + File.separator + fileName;
        File file = new File(filePath);

        if(file.exists()){
            Uri uri = Uri.fromFile(file);

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri, "application/pdf");
            try{
                startActivity(intent);
            }catch (ActivityNotFoundException exception){
                Toast.makeText(this, "PDF 파일을 열기 위한 앱이 없습니다." ,
                        Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "PDF 파일이 존재하지 않습니다.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}