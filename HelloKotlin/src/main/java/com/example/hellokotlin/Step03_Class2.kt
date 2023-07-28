package com.example.hellokotlin
/*
     var 또는 val을 생성자의 인자에 선언하면 전달받은 값이 자동으로 같은 이름의 필드가 만들어지면서
     값이 필드에 대입됨 (선언을 하지 않아도 에러가 나진 않지만, 수정이 불가능함)
     var : 수정이 가능한 필드가 만들어짐
     val : 수정이 불가능한 필드가 만들어짐
 */
class Person constructor(name: String){
     //필드 선언
     var name:String
     //초기화 블럭
     init {
         //생성자의 인자로 전달받은 값을 매개변수에 저장
         this.name = name //name이라는 필드에 name이라는 이름의 인자로 전달받은 값은 저장한 것
     }
}
//위를 줄이면 아래와 같음
class Person2(var name:String)

data class Member(var num:Int, var name: String, var addr: String)

fun main(){
     var p1 = Person("수정")
     println("p1.name:"+p1.name)
     println(p1)

     //Member 객체 생성
     var m1 = Member(1, "수정", "서울")
     println("번호:${m1.name} 이름:${m1.name} 주소:${m1.addr}")
     println(m1)

     //수정가능한 List 객체를 얻어내서 참조값을 members라는 상수에 담음
     val members:MutableList<Member> = mutableListOf<Member>()
     //type추론이 가능하기 때문에 members2의 type이 생략가능함
     val members2 = mutableListOf<Member>()

     //List의 add메소드를 이용해서 Member객체의 참조값을 저장
     members.add(m1)
     members.add(Member(2, "영현", "부여"))

     //list의 forEach()를 호출하면서 함수를 전달하면 전달한 함수의 매개변수에 list의 아이템이 순서대로 전달됨
     members.forEach(fun(item){
          println(item)
     })
     println("-----------")
     //매개변수가 하나인 경우 생략할 수 있음
     members.forEach({
          println(it)
     })
     //중괄호도 생략할 수 있음
     members.forEach{
          println(it)
     }
}

