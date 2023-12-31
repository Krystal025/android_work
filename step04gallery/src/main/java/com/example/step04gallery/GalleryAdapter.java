package com.example.step04gallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class GalleryAdapter extends BaseAdapter {
    //필요한 필드 정의
    private LayoutInflater inflater; //layout 전개자 객체를 담을 필드
    private Context context; //앱 컨택스트를 담을 필드
    private int layoutRes; //셀의 레이아웃 resource id를 담을 필드
    private List<GalleryDto> list; //모델

    //생성자
    public GalleryAdapter(Context context, int layoutRes, List<GalleryDto> list) {
        this.context = context;
        this.layoutRes = layoutRes;
        this.list = list;
        //레이아웃 전개자 객체의 참조값을 얻어내서 필드에 저장
        inflater = LayoutInflater.from(context);
    }

    //여기있는 모든 메소드는 listView가 사용할 것

    //모델의 갯수
    @Override
    public int getCount() {
        return list.size();
    }

    //i번째 모델
    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    //i번째 모델의 id(PK)가 있으면 리턴
    @Override
    public long getItemId(int i) {
        return list.get(i).getNum();
    }

    //i번째 cell의 View를 만들거나 수정해서 리턴
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView == null){
            //레이아웃 전개자 객체를 이용해서 cell view를 만듦
            convertView=inflater.inflate(layoutRes, viewGroup, false);
        }
        // position 에 해당하는 GalleryDto 를 얻어내서
        GalleryDto dto=list.get(position);
        ImageView imageView=convertView.findViewById(R.id.imageView);
        TextView textWriter=convertView.findViewById(R.id.writer);
        TextView textCaption=convertView.findViewById(R.id.caption);
        TextView textRegdate=convertView.findViewById(R.id.regdate);
        //TextView에는 작성자, 제목, 등록일을 출력하고
        textWriter.setText(dto.getWriter());
        textCaption.setText(dto.getCaption());
        textRegdate.setText(dto.getRegdate());
        //ImageView에는 Glide를 이용해서 이미지 출력
        Glide.with(context)
                .load(dto.getImagePath())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
        //gallery 정보가 출력된 View객체 리턴해주기
        return convertView;
    }
}
