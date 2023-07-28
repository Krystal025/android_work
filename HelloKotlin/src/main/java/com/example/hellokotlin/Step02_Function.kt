package com.example.hellokotlin

// run 했을 때 실행의 흐름이 시작되는 main함수 생성
fun main(){
    println("main 함수가 시작되었습니다")
    /*
        JAVA : public void a(){}
        Kotlin : fun a():Unit{} or fun a(){}
        - Kotlin에서 Unit은 원시타입이라고 지칭하고 Java의 void와 비슷한 역할을 함
     */

    // fun 함수명():리턴타입{}
    fun a():Unit{
        println("a 함수 호출")
    }
    a()

    //이름이 없는 함수를 만들어서 그 참조값을 변수에 담음
    var b = fun(){}

    /*
        대입연산자의 우측에 있는 함수를 관찰해보면
        리턴타입 : 없음(Unit)
        함수에 전달해야하는 인자 : 없음
     */
    var c:()->Unit = fun():Unit{} // c는 매개변수가 없고, 리턴타입이 없는 함수 타입
    //var c = fun():Unit{}
    c = fun(){}

    //매개변수는 1개 type은 String, 리턴타입은 Unit
    var d:(String)->Unit = fun(str:String){}

    //매개변수는 1개 type은 String, 리턴타입은 String
    var e:(String)->String = fun(str:String):String{
        return "hello"
    }

    //매개변수는 2개 type은 (Int, Int), 리턴타입은 Int
    var sum:(Int, Int)->Int = fun(a:Int, b:Int):Int{
        return a+b
    }

    var myName:String = "kim"

    var myNum:Int = 10

    println("main 함수가 종료되었습니다")
}