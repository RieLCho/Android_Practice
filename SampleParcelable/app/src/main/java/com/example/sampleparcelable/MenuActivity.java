package com.example.sampleparcelable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    TextView textView;
    public static final String KEY_SIMPLE_DATA = "data";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textView = (TextView)findViewById(R.id.textView);
        Button button = (Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 인텐트 객체를 만듭니다.
                Intent intent = new Intent();
                intent.putExtra("name", "mike");
                // 응답을 전달하고 이 액티비티를 종료합니다.
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        Intent intent = getIntent();
        processIntent(intent);

    }

    private void processIntent(Intent intent){
        if(intent != null){
            // 인텐트 안의 번들 객체를 참조
            Bundle bundle = intent.getExtras();
            // 번들 객체 안의 SimpleData를 참조
            SimpleData data = (SimpleData)bundle.getParcelable(KEY_SIMPLE_DATA);
            // 텍스트뷰에 값을 보여줍니다.
            textView.setText("전달 받은 데이터\nNumber : " + data.number + "\nMessage : "+data.message);
        }
    }
}