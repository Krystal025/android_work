package com.example.step05fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.step05fragment.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity
                            //MyFragment에서 전달하는 메세지를 받고싶으면
                            implements MyFragment.MyFragmentListener {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main.xml 문서에 <fragment> 요소가 있을떄 해당 Fragment의 참조값을 얻어내는 방법
        //setContentView(R.layout.activity_main);

        //view binding 객체를 얻어내서 필드에 저장
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //화면 구성하기
        setContentView(binding.getRoot());

        //FragmentManager 객체 얻어오기
        FragmentManager fm = getSupportFragmentManager();
        //FrgmentManager 객체를 이용해서 Fragment 객체의 참조값을 얻어낼 수 있음
        MyFragment frag1 = (MyFragment) fm.findFragmentById(R.id.fragment1);
        MyFragment frag2 = (MyFragment) fm.findFragmentById(R.id.fragment2);

        //리셋버튼에 리스너 등록
        Button resetBtn = findViewById(R.id.resetBtn);
        resetBtn.setOnClickListener(view -> {
            frag1.reset();
            frag2.reset();
        });

        binding.moveBtn.setOnClickListener(view -> {
            //SubActivity로 이동하기
            startActivity(new Intent(this, SubActivity.class));
        });

//        Button moveBtn = findViewById(R.id.moveBtn);
//        moveBtn.setOnClickListener(view -> {
//            //SubActivity로 이동하기
//            startActivity(new Intent(this, SubActivity.class));
//        });
    }

    //MyFragment 객체에서 특정시점에 호출하는 메소드
    @Override
    public void sendMsg(String msg) {
        Toast.makeText(this, "MyFragment:"+msg, Toast.LENGTH_SHORT).show();
    }
}