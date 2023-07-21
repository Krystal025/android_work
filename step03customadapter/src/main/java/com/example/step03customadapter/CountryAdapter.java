package com.example.step03customadapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
/*
    ListView에 연결할 Adapter 클래스 정의하기
    - BaseAdapter 추상클래스를 상속받아서 만듦
 */
public class CountryAdapter extends BaseAdapter {
    // 필드
    Context context;
    int layoutRes;
    List<CountryDto> list;

    // 생성자 (Context, cell의 layout resource id, 모델)
    public CountryAdapter(Context context, int layoutRes, List<CountryDto> list){
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
    }

    // 모델의 개수를 리턴
    @Override
    public int getCount() {
        return list.size();
    }

    // i번째 인덱스에 해당하는 모델을 리턴
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    // i번째 인덱스에 해당하는 모델의 id(PK)가 있으면 리턴
    @Override
    public long getItemId(int i) {
        // 없으면 인덱스 리턴
        return i;
    }

    // i번쨰 인덱스에 해당하는 cell view를 리턴
    /*
        인자로 전달되는 i번째 cell, view를 만들어서 리턴해야함
        <cell view>
        - 레이아웃 xml문서를 전개해서 만들어야함
        - 전개해서 만든 view의 ImageView와 TextView에 적절한 데이터를 출력한 후 View 객체를 리턴해줌
        - 모델 갯수만큼 다 생성X, 화면을 채울만큼 최소한의 갯수만 만들고 기존에 만든 View객체를 재사용해야함
     */
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.d("CountryAdapter", "getView() 호출됨 i:"+i);
        if(view == null){
            Log.d("CountryAdapter", "view가 null이므로 cell view를 새로 만듦");
            //레이아웃 xml문서를 전개해서 View객체를 새롭게 만듦
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layoutRes, viewGroup, false);
        }
        // i에 해당하는 CountryDto 객체
        CountryDto dto = list.get(i);
        // View객체 안에있는 ImageView, TextView의 참조값을 얻어옴
        ImageView imageView = view.findViewById(R.id.imageView);
        TextView textView = view.findViewById(R.id.textView);
        // ImageView, TextView에 정보를 출력
        imageView.setImageResource(dto.getResId());
        textView.setText(dto.getName());
        // i번쨰 인덱스에 해당하는 View 리턴
        return view;
    }
}
