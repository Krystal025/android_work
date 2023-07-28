package com.example.step05fragment2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.step05fragment2.databinding.ActivityMainBinding;
import com.google.android.material.snackbar.Snackbar;

/*
    view binding 사용하는 방법

    1. build.gradle 파일에 설정(아래의 문자열을 추가)

    buildFeatures {
        viewBinding = true
    }

    2. build.gradle 파일의 우상단에 sync now 버튼을 눌러서 실제 반영되도록 한다.

    3. layout xml 문서의 이름을 확인해서 자동으로 만들어진 클래스명을 예측한다.

    예를들어  activity_main.xml  문서이면  ActivityMainBinding 클래스
    예를들어  activity_sub.xml 문서이면 ActivitySubBinding 클래스 ...
 */

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    /*
        우상단 "옵션메뉴"를 만들고 싶으면 onCreateOptionMenu() 메소드를 오버라이딩해서 Menu를 구성하면 됨
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //activity_main.xml 문서가 존재하기 때문에 ActivityMainBinding 클래스가 만들어진 것
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //바인딩 객체의 getRoot()메소드가 리턴해주는 View 객체로 화면을 구성함
        /*
             [원래모양]
            setContentView(R.layout.activity_main);
            setSupportActionBar(findViewById(R.id.toolbar));
         */
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        //id가 fab인 UI에 클릭이벤트 리스너 등록
        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //스낵바 띄우기
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAnchorView(R.id.fab)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // res/menu/menu_main.xml 문서를 활용해서 메뉴 아이템 구성
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    //메뉴 아이템을 클릭하면 호출되는 메소드
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //클릭한 아이템의 id가 리턴됨
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }else if(id == R.id.one){

        }else if(id == R.id.two){

        }

        return super.onOptionsItemSelected(item);
    }

    //좌상단 up버튼이 동잓하기 위한 설정 (up버튼 : 상위Activity로 이동, 보통 뒤로가기와 유사)
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}