package com.example.step07sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*
    DB 생성 및 리셋을 도와주는 도우미 클래스 만들기
    - SQLiteOpenHelper 추상클래스를 상속 받아서 만듦
 */
public class DBHelper extends SQLiteOpenHelper {
    //생성자
    public DBHelper(@Nullable Context context,
                    @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }
    //App에서 DB를 처음 사용할 때 호출되는 메소드
    @Override
    public void onCreate(SQLiteDatabase db) {
        //사용할 테이블을 만들면 됨
        String sql = "CREATE TABLE todo "+
                "(num INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "content TEXT, regdate TEXT)";
        //SQLiteDataBase 객체를 이용해서 실행함
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //업그레이드할 내용을 작성하면 됨
        db.execSQL("DROP TABLE IF EXISTS todo");
        //다시 만들어 칠 수 있도록 onCreate() 메소드를 호출함
        onCreate(db);
    }
}
