package com.example.step03customadapter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //DetailActivity가 활성화되기 위해서 전달된 Intent 객체의 참조값을 얻어냄
        Intent intent = this.getIntent();  //this. 생략가능
        //dto라는 키값으로 담긴 Serializeble type의 참조값을 얻어내서 CountryDto 타입으로 casting
        CountryDto dto = (CountryDto) intent.getSerializableExtra("dto");

        //선택된 cell에 해당하는 CountryDto를 얻어낼 수 있다면

        //아래의 ImageView와 TextView에 해당정보를 출력할 수 있음
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(dto.getResId());
        TextView textView = findViewById(R.id.textView);
        textView.setText(dto.getContent());
        //확인버튼을 눌렀을 떄 Activity 종료
        Button confirmBtn = findViewById(R.id.confirmBtn);
        confirmBtn.setOnClickListener(view -> {
            //finish()메소드를 호출하면 Activity가 종료됨
        });
    }
}