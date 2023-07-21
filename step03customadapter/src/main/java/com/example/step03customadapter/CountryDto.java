package com.example.step03customadapter;

import java.io.Serializable;

public class CountryDto implements Serializable { //CountryDto객체를 Intent객체에 담기 위해서 구현
    // 필드
    private int resId;  // 출력할 이미지 resource id 값
    private String name;  // 국가 이름
    private String content;  // 국가 설명

    // 생성자
    public CountryDto(){};

    // alt + ins로 Generate (shift로 전체선택)
    public CountryDto(int resId, String name, String content) {
        this.resId = resId;
        this.name = name;
        this.content = content;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
