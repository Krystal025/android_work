package com.example.step04gallery;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Util.RequestListener {
    //필드
    List<GalleryDto> list;
    GalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ListView의 참조값 얻어오기
        ListView listView = findViewById(R.id.listView);
        //모델객체 생성
        list = new ArrayList<>();
        //Adapter 생성
        adapter = new GalleryAdapter(this, R.layout.lisetview_cell, list);
        //ListView에 Adapter 연결
        listView.setAdapter(adapter);
        //listView에 아이템 클릭 리스너 등록
        listView.setOnItemClickListener(((adapterView, view, i, l) -> {
            //클릭한 셀의 인덱스에 해당하는 GalleryDto
            GalleryDto dto = list.get(i);
            //Activity를 이동할 Intent 객체 생성
            Intent intent = new Intent(this, DetailActivity.class);
            //Intent 객체에 Serializable 타입 담기
            intent.putExtra("dto", dto);
            //Activity 이동
            startActivity(intent);
        }));

        Util.sendGetRequest(0,
                 AppConstants.BASE_URL+"/android/gallery/list",
                null,
                this);
    }

    @Override
    public void onSuccess(int requestId, Map<String, Object> result) {
        if(requestId == 0){
            //Map에는 "data"라는 키값으로 [{}, {}, {} ... ]형식의 json문자열이 들어있음
            String json = (String) result.get("data");
            try {
                JSONArray arr = new JSONArray(json);
                //반복문 돌면서 JSONObject 객체를 하나씩 얻어냄
                for(int i=0; i<arr.length(); i++){
                    JSONObject tmp = arr.getJSONObject(i);
                    //JSONObject 안에있는 정보를 추출해서 GalleryDto에 담음
                    GalleryDto dto = new GalleryDto();
                    dto.setNum(tmp.getInt("num"));
                    dto.setWriter(tmp.getString("writer"));
                    dto.setCaption(tmp.getString("caption"));
                    dto.setRegdate(tmp.getString("regdate"));
                    String url = AppConstants.BASE_URL+"/gallery/images/"+tmp.getString("imagePath");
                    dto.setImagePath(url);
                    //GaellryDto를 list에 누적시킴
                    list.add(dto);
                }
                //모델이 업데이트 되었다고 adapter에 알려서 listView가 업데이트 되도록 함
                adapter.notifyDataSetChanged();
            }catch (JSONException e){
                throw new RuntimeException(e);
            }

        }
    }

    @Override
    public void onFail(int requestId, Map<String, Object> result) {

    }
}