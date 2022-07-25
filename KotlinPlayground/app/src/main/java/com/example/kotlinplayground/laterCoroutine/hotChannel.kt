package com.example.kotlinplayground.laterCoroutine

import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.runBlocking


// 代码段15

fun main() = runBlocking {
    // 只发送不接受
    val channel = produce<Int>(capacity = 10) {
        (1..3).forEach {
            send(it)
            println("Send $it")
        }
    }

    println("end")
}

/*
输出结果：
end
Send 1
Send 2
Send 3
程序结束
*/