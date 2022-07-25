package com.example.kotlinplayground

import kotlinx.coroutines.*


// 代码段2

fun main() {
    runBlocking {
        val job = launch(start = CoroutineStart.LAZY) {
            logX("Coroutine start!")
            delay(5000L)
            print("协程执行完毕了")
        }

        job.invokeOnCompletion {
            logX("认为完成了！！！！！！！")
        }

        delay(500)
        job.log()       //1
        job.start()
        job.log()       //2
        delay(500)
        job.join()
        logX("EnD!!!")
    }
    logX("外面的情况")
}

/**
 * 打印Job的状态信息
 */
fun Job.log() {


    logX("""
        isActive = $isActive
        isCancelled = $isCancelled
        isCompleted = $isCompleted
    """.trimIndent())
}

/**
 * 控制台输出带协程信息的log
 */
fun logX(any: Any?) {
    println("""
================================
$any
Thread:${Thread.currentThread().name}
================================""".trimIndent())
}


/*
输出结果：
================================
isActive = true
isCancelled = false
isCompleted = false
Thread:main @coroutine#1
================================
================================
isActive = false
isCancelled = true
isCompleted = false
Thread:main @coroutine#1
================================
*/