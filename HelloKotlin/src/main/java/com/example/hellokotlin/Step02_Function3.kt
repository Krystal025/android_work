package com.example.hellokotlin

val nums = listOf<Int>(1,2,3,4,5,6,7,8,9,10)

fun main(){
    //nums 배열을 이용해서 item에 2를 곱한 item을 갖고있는 새로운 배열 얻어내기
    val result = nums.map {
        it*2
    }
    val result2 = nums.filter {
        it>5
    }
    //nums 배열을 이용해서 item에 모두 3을 곱한후 10보다 큰 item만 남겨놓은 새로운 배열 얻어내기
    val result3 = nums.map { it*3 }.filter { it>10 }
    println("main함수 종료")
}