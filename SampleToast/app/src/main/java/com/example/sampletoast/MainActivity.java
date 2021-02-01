package com.example.sampletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    EditText editText2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);

    }

    public void onButton1Clicked(View v){
        try{
            Toast toastView = Toast.makeText(this, "위치가 바뀐 토스트 메시지입니다.", Toast.LENGTH_LONG);
            int xOffSet = Integer.parseInt(editText.getText().toString());
            int yOffSet = Integer.parseInt(editText.getText().toString());
            toastView.setGravity(Gravity.CENTER | Gravity.TOP, xOffSet, yOffSet);
            toastView.show();
        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }

    public void onButton2Clicked(View v){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.toastborder, (ViewGroup)findViewById(R.id.toast_layout_root));
        TextView text =  (TextView)layout.findViewById(R.id.text);
        Toast toast = new Toast(this);
        text.setText("모양 바꾼 토스트");
        toast.setGravity(Gravity.CENTER, 0 , -100);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }

    public void onButton3Clicked(View v){
        Snackbar.make(v, "스낵바입니다. ", Snackbar.LENGTH_LONG).show();
    }
}