package com.example.hellokotlin
/*
    Kotlin에서의 배열과 반복문
 */
fun main(){
    //수정 불가능한 목록(List)
    val names:List<String> = listOf("kim","lee","park")
    //상수의 type이 추론가능하기 때문에 생략가능
    val animals = listOf<String>("dog","cat","rabbit")
    //listOf() 안에있는 데이터가 추론 가능하기 떄문에 listOf의 Generic도 생략가능
    val nums = listOf(10, 20, 30)
    //배열의 참조
    println(names[0])
    println(names[1])
    println(names[2])

    //수정 불가
    //names[0] = "nam"

    //indices : index의 복수형(names 배열의 index로 이루어진 배열)
    val result = names.indices

    for (i in names.indices){
        println(i)
    }
    println("----------------")
    for (i in names.indices){
        println(names[i])
    }
    println("----------------")
    for (i in names.indices){
        println("$i : ${names[i]}")
    }
    println("----------------")
    for (item in names){
        println(item)
    }
    println("----------------")
    names.forEach{
        println(it)
    }
}