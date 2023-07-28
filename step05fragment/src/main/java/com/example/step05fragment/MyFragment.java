package com.example.step05fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/*
    [Fragment]

    - Activity 제어 하에 존재하는 mini Controller
    - 재활용을 염두에 두고 만드는 경우가 많음
    - 재활용 : 여러개의 Activity에서 활용된다는 뜻

    [Fragment 생성 방법]
    1. Fragment 클래스 상속
    2. Fragment의 layout xml 문서를 만듦
    3. onCreateView() 메소드를 @Override
 */

public class MyFragment extends Fragment implements View.OnClickListener {
    TextView textView;
    //해당 Fragment가 제어할 View 객체를 만들어서 리턴해주는 메소드
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //1. Fragment_my.xml 문서를 전개해서 View를 만든 다음
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        //만든 View 객체에서 TextView의 참조값을 얻어냄
        textView = view.findViewById(R.id.textView);
        //TextView에 OnClickListener를 등록함
        textView.setOnClickListener(this);
        //2. 해당 View를 리턴해줌
        return view;
    }

    @Override
    public void onClick(View view) {
        //textView에 출력한 문자열을 숫자로 바꿔서 얻어냄
        int count = Integer.parseInt(textView.getText().toString());
        //count를 1씩 증가시킴
        count++;
        //TextView에 문자열로 바꿔서 출력
        textView.setText(Integer.toString(count));
        /*
            만일 Fragment에서 현재 자신을 제어하고 있는 Activity에 데이터를 전달하고자 할 때
         */

        //이 Fragment를 제어하고 있는 Activity의 참조값을 얻어냄
        FragmentActivity fa = getActivity();
        //만일 이 Activity가 MyFragmentListener 타입이 맞다면
        if(fa instanceof MyFragmentListener) {
            //Activity의 참조값을 MyFragmentListener 타입으로 Casting해서
            MyFragmentListener ma = (MyFragmentListener) fa;
            //메세지를 보낼 수 있음
            ma.sendMsg("hello!");
        }
    }
    //Activity에서 특정 시점에 호출할 예정인 메소드
    public void reset(){
        textView.setText("0");
    }

    //이 Fragment에서 전달하는 메세지를 받을 Activity에서 구현할 인터페이스를 클래스 안에 정의함
    public interface MyFragmentListener{
        public void sendMsg(String msg);

    }
}
