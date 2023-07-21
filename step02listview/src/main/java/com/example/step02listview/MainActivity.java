package com.example.step02listview;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    List<String> names;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //listView의 참조값
        ListView listView = findViewById(R.id.listView);
        //listView에 출력할 Sample Data
        names = new ArrayList<>();
        names.add("수정");
        names.add("희진");
        names.add("영현");
        for(int i=0; i<100; i++){
            names.add("우와왕"+i);
        }
        //listView에 연결할 id 검색
        //new ArrayAdapter<>( Content, layout resource, 모델 )
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );
        //Adapter를 listView에 연결
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this);

        listView.setOnItemLongClickListener(this);

        //버튼에 리스너 등록
        Button addBtn = findViewById(R.id.addBtn);
        addBtn.setOnClickListener(view -> {
            //EditText에 입력한 문자열을 읽어옴
            EditText inputName = findViewById(R.id.inputName);
            String name = inputName.getText().toString();
            //모델에 추가
            names.add(name);
            //Adapter에 names(모델)의 변경을 알림
            adapter.notifyDataSetChanged();
            //전체 item의 개수를 알아냄
            int position = adapter.getCount();
            //마지막 index로 스크롤
            listView.smoothScrollToPosition(position);
        });
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // i : 클릭한 item의 인덱스
        Log.d("MainActivity", "i:"+i);
        // 클릭한 item의 text
        String clickedName = names.get(i);
        // Toast 메세지로 출력
        Toast.makeText(MainActivity.this, clickedName, Toast.LENGTH_SHORT).show();
    }

    //ListView의 셀을 오래 클릭하면 호출되는 메소드
    @Override
    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

        DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int result) {
                // 알림창에 있는 버튼을 눌렀을 떄 호출되는 메소드를 갖고있는 Listener 객체
                if(result == DialogInterface.BUTTON_POSITIVE){ //긍정 버튼을 눌렀을 떄
                    // i번째 인덱스의 아이템 제거
                    // 1. 모델에서 제거
                    names.remove(i);
                    // 2. 모델이 변경되었음을 Adapter에 알리면 ListView가 업데이트 됨
                    adapter.notifyDataSetChanged();
                }
            }
        };

//        new AlertDialog.Builder(this)
//                .setMessage("Delete?")
//                .setPositiveButton("Yes", listener)
//                .setNegativeButton("No", listener)
//                .create()
//                .show();
//        return false;

        new AlertDialog.Builder(this)
                .setMessage("Delete?")
                // 내부에서 함수를 사용하면 조건식이 필요없음
                .setPositiveButton("Yes", (a, b) -> {
                    // 1. 모델에서 제거
                    names.remove(i);
                    // 2. 모델이 변경되었음으로 Adapter에 알리면 ListView가 업데이트됨
                    adapter.notifyDataSetChanged();
                })
                .setNegativeButton("No", null)
                .create()
                .show();
        return false;
    }

}