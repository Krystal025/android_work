package com.example.step01example;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //버튼 1) 버튼에 리스너 등록한 후 별도로 메소드 정의
        //전송 버튼의 참조값 얻어오기
        Button sendBtn = findViewById(R.id.sendBtn);
        //버튼에 리스너 등록하기
        sendBtn.setOnClickListener(this);

        //버튼 2) 메소드가 하나이기 때문에 함수형태로 전달가능함
        Button sendBtn2 = findViewById(R.id.sendBtn2);
        sendBtn2.setOnClickListener(view -> {
            //EditText에 입력한 문자열 읽어오기
            EditText editText = findViewById(R.id.editText);
            String msg = editText.getText().toString();
            //TextView에 출력하기
            TextView textView = findViewById(R.id.textView);
            textView.setText(msg);
        });
    }

    @Override
    public void onClick(View view) {
        //EditText에 입력한 문자열 읽어오기
        EditText editText = findViewById(R.id.editText);
        String msg = editText.getText().toString();
        //TextView에 출력하기
        TextView textView = findViewById(R.id.textView);
        textView.setText(msg);
    }

    /*
        public void sendClicked(View v){
            //EditText에 입력한 문자열 읽어오기
            EditText editText = findViewById(R.id.editText);
            String msg = editText.getText().toString();
            //TextView에 출력하기
            TextView textView = findViewById(R.id.textView);
            textView.setText(msg);
        }
     */
}