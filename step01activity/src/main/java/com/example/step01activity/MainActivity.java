package com.example.step01activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //카운트를 셀 필드
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    //click 버튼을 클릭했을 떄 실행되는 메소드
    public void clicked(View v){
        //필드 값을 1 증가시킴
        count ++;
        /* 필드의 값을 TextView에 출력
           (res/layout/activity_main.xml 문서를 전개해서 레이아웃을 구성했기 때문에
           TextView의 참조값을 얻어와야함 */
        TextView a = findViewById(R.id.textView);
        a.setText(Integer.toString(count));
    }
    //reset 버튼을 클릭했을 떄 실행되는 메소드
    public void resetClicked(View v){
        count = 0;
        /*
         * 현재 활성화되어있는 Activity가 구성한 화면에서
         * textView라는 id를 갖고있는 UI의 참조값을 얻어와서
         * textView 타입의 b라는 지역변수에 담음
         */
        TextView b = findViewById(R.id.textView);
        b.setText(Integer.toString(count));
    }
}