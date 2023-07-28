package com.example.hellokotlin

//함수 type을 매개변수로 전달받는 함수를 정의하고자 함
fun useFunc(a:()->Unit){
    //인자로 전달받은 함수 호출하기
    a()
}
fun main(){
    // 위의 useFunc()함수 호출
    useFunc(fun(){
        println("useFunc() 호출됨")
    })
    // fun() 생략가능
    useFunc({
       println("useFunc() 호출됨")
    })
    // 함수 호출 표현식 () 생략가능
    useFunc {
        println("useFunc() 호출됨")
    }
    //ReadOnly(수정불가) 숫자배열
    var nums:List<Int> = listOf(10, 20, 30)

    /*
        변수 자체 수정은 가능, 배열의 아이템 수정은 불가능
        가능 : nums = listOf(100, 200, 300)
        불가능 : nums[0] = 99
     */

    nums.forEach(fun(item){
        println(item)
    })

    nums.forEach({
        //it : 매개변수에 전달되는 바로 그것(it)을 가리킴
        //매개변수가 하나인 경우 해당 값을 it으로 지칭할 수 있음
        println(it)
    })

    nums.forEach{
        println(it)
    }
}