package com.example.hellokotlin

/*
 *  [Kotlin 기본 데이터 타입]
 *
 *  Byte, Short, Int, Long
 *  Float, Double
 *  Boolean, Char
 *  String
 */

fun main(){
    //정수를 담을 수 있는 num이라는 이름의 변수를 만들어서 10 대입
    var num:Int = 10
    //상수를 담을 수 있는 num2라는 이름의 변수를 만들어서 10.1 대입
    var num2:Double = 10.1
    //myName이라는 변수에 문자열 "수정공주" 대입
    var myName:String = "수정공주"
    //yourName이라는 상수에 문자열 "진이" 대입
    val yourName:String = "진이"
    //변수는 값이 변경 가능함
    myName = "정정이"
    //상수는 값이 한번 할당되면 변경 불가능함
    //yourName="희진"

    //type 추론이 가능한 경우 type 생략 가능
    var num3 = 30
    var ourName = "에이콘"
    var num4 = 10.1

    //변수를 미리 선언하고
    var num5:Int
    //값을 나중에 넣을 수 있음
    num5 = 50

    //변수나 상수를 미리 선언하고 값을 나중에 할당할 때는 반드시 type을 명시해야함
    //var num6
    //num6 = 60

    //상수도 미리 선언후
    val PI:Float
    //나중에 값을 할당당할 수 있음
    PI = 3.14159f
    //단, 상수는 값이 한번 결정되면 값이 변결 불가능함
    //PI = 3.14f

    println("main()메소드가 종료됨")
}