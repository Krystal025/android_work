package com.example.hello2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
/*
 * 이 MainActivity는 hello2 App이 launch(실행)될 떄 최초로 사용자를 대면하는 Activity 이다
 * 대체로 Activity 하나는 화면 하나
 */
public class MainActivity extends AppCompatActivity {

    // Activity가 활성화될 떄 최초로 호출되는 메소드
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // res/layout/activity_main.xml 문서를 전개(해석)해서 화면을 구성함
        setContentView(R.layout.activity_main);
    }

    // 버튼을 클릭했을 때 호출되는 메소드 (View객체의 참조값이 매개변수에 전달됨)
    public void clicked(View v){
        Toast.makeText(this, "버튼을 눌렀습니다", Toast.LENGTH_SHORT).show();
    }

    public void deleteClicked(View v){
        Toast.makeText(this, "삭제되었습니다", Toast.LENGTH_SHORT).show();
    }
}