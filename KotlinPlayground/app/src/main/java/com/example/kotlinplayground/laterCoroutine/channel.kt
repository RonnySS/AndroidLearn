package com.example.kotlinplayground.laterCoroutine

import com.example.kotlinplayground.logX
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


// 代码段1

fun main() = runBlocking {
    // 1，创建管道
//    val channel = Channel<Int>()
//    val channel2 = Channel<Int>()
//    launch {
//        // 2，在一个单独的协程当中发送管道消息
//        (1..3).forEach {
//            delay(1000)
//            channel.send(it) // 挂起函数
//        }
//    }

    val channelP = produce<Int>(capacity = 10) {
        delay(1000)
        println("开始发送了")
        send(1)
        println("发送完毕了")
        delay(1000)
        send(2)
        delay(1000)
        send(3)
        println("发送完毕了")

    }

    delay(3000)

//    launch {
//        (10..12).forEach {
//            delay(1000)
//            channel.send(it)
//        }
//    }

//
//    launch {
//        channel.consumeEach {
//            println(it)
//        }
//    }
    val startTime = System.currentTimeMillis()
    channelP.receive()
    channelP.receive()
    channelP.receive()
    println("Time cost: ${System.currentTimeMillis() - startTime}")
    logX("end")
}

/*
================================
end
Thread:main @coroutine#1
================================
================================
Receive: 1
Thread:main @coroutine#3
================================
================================
Send: 1
Thread:main @coroutine#2
================================
================================
Send: 2
Thread:main @coroutine#2
================================
================================
Receive: 2
Thread:main @coroutine#3
================================
================================
Receive: 3
Thread:main @coroutine#3
================================
================================
Send: 3
Thread:main @coroutine#2
================================
// 4，程序不会退出
*/