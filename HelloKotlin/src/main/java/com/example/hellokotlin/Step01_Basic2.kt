package com.example.hellokotlin
/*
    String 타입의 편리한 기능 활용
 */
fun main(){
    val myName = "수정"
    val yourName = "영현"
    //연결 연산자 가능
    val result = "내 이름:"+myName
    val result2 = "너의 이름:$yourName"
    //${} JavaScript 백틱에서 활용했던 표현식도 가능
    val result3 = "우리 이름:${myName+yourName}"
    val num1 = 10
    val num2 = 20
    val result4 = "num1+num2 = ${num1+num2}"
    //여러줄의 문자열을 편리하게 작성할 수 있음
    val html = """
        <div>
            <p>p요소입니다</p>
        </div>
    """
    val html2 = """
        <div>
            <p>p요소입니다</p>
        </div>
    """.trimIndent()
    println(html)
    println("----------")
    println(html2)
}