package com.example.hellokotlin

//클래스 정의하기
class MyCar

class YourCar{
    //멤버 함수
    fun drive(){
        println("달려요~~붕붕")
    }
    //생성자
    //대표(primary)생성자는 클래스명 우측에 선언
    class Ship constructor(){
        init {
            //객체를 생성하는 시점에 초기화하고 싶은 작업이 있으면 여기서 실행
            println("Ship 클래스의 init")
        }
    }
    //constructor 예약어 생략가능
    class Ship2 (){
        init {
            //객체를 생성하는 시점에 초기화하고 싶은 작업이 있으면 여기서 실행
            println("Ship2 클래스의 init")
        }
    }
    //생성자의 인자로 전달받을게 없으면 ()도 생략가능
    class Ship3 {
        init {
            //객체를 생성하는 시점에 초기화하고 싶은 작업이 있으면 여기서 실행
            println("Ship3 클래스의 init")
        }
    }
}




fun main(){
    //MyCar 클래스로 객체를 생성해서 참조값을 c1이라는 변수에 담음
    var c1:MyCar = MyCar()
    //YourCar 클래스로 객체를 생성해서 참조값을 c2라는 변수에 담음
    var c2 = YourCar()
    c2.drive()
}