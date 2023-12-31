package com.example.step07sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class TodoDao {
    private DBHelper dbHelper;
    //생성자
    public TodoDao(DBHelper dbHelper){
        this.dbHelper = dbHelper;
    }
    //할일 저장
    public void insert(Todo todo){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "INSERT INTO todo"+
                " (content, regdate)"+
                " VALUES(?, datetime('now','localtime'))";
        //?에 순서대로 바인딩할 인자를 Object[]에 준비함
        Object[] args = {todo.getContent()};
        //sql문 실행하기
        db.execSQL(sql, args);
        db.close();
    }
    //할일 정보를 수정하는 메소드
    public void update(Todo todo){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "UPDATE todo"+
                " SET content=?"+
                " WHERE num=?";
        Object[] args = {todo.getContent(), todo.getNum()};
        db.execSQL(sql, args);
        db.close();
    }
    //할일 정보를 삭제하는 메소드
    public void delete(Todo todo) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "DELETE FROM todo WHERE num=?";
        Object[] args = {todo.getContent(), todo.getNum()};
        db.execSQL(sql, args);
        db.close();
    }
    //할일 1개의 정보를 리턴하는 메소드
    public Todo getData(int num){
        Todo todo = null;
        //Select이므로 읽기전용 참조값 얻어오기
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT content, regdate"+
                " FROM todo"+
                " WHERE num=?";
        //query문에는 String[]배열에 selection 인자를 준비해야함
        String[] args = {Integer.toString(num)};
        Cursor result = db.rawQuery(sql, args);
        //만일 select된 값이 있다면
        if(result.moveToNext()){
            todo = new Todo();
            todo.setNum(num);
            //0번째 col에 select된 문자열을 Todo 객체에 담음
            todo.setContent(result.getString(0));
            //1번째 col에 select된 문자열을 Todo 객체에 담음
            todo.setRegdate(result.getString(1));
        }
        return todo;
    }
}
