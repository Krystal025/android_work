package com.example.hellokotlin

class Cat constructor(){
    //init 블럭은 primary 생성자의 일부
    init {
        println("야옹이가 생겼어요!")
    }
    //뒤늦은 초기화가 가능한 필드 lateinit 예약어 붙여서 선언
    lateinit var name:String
    constructor(name:String) : this() { //primary 생성자를 호출하는 표현식
        println("야옹이의 이름은:${name}")
        this.name = name
    }
}
class Dog constructor(){
    init {
        println("멍멍이가 생겼어요!")
    }
    var name:String? = null
    constructor(name:String):this(){
        //null이 가능한 type공간에 null이 불가능한 type 공간에 담긴값을 대입하는 것은 가능
        this.name = name
    }
}

fun main(){
    var c1 = Cat("톰캣")
    var c2 = Cat()
    println(c1.name)
    c2.name = "키티"
    println(c2.name)

    //null값이 가능한 data type은 type뒤에 ?를 붙여줘야함
    var myName:String? = null
    myName = "꾸꾸"
    myName = null
    //Int(숫자) 타입도 null을 넣어놓고 값을 나중에 대입할 수 있음
    var myNum:Int? = null
    myNum = 999
    myNum = null

    var d1 = Dog("바둑이")
    var d2 = Dog()
    println(d1.name)
    println(d2.name)
}
