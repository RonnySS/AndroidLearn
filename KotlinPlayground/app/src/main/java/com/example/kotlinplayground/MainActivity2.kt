package com.example.kotlinplayground

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2:AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        test()

    }


    fun test(){

        repeat(3) {
            Thread.sleep(1000L)
            println("Print-1:${Thread.currentThread().name}")
        }

        repeat(3) {
            Thread.sleep(900L)
            println("Print-2:${Thread.currentThread().name}")
        }
    }

/*
输出结果：
Print-1:main
Print-1:main
Print-1:main
Print-2:main
Print-2:main
Print-2:main
*/



    fun startThread(){
        Thread(Runnable {
            println("Thread started!")
            Thread.sleep(10000)
            println("Hello World!")
        }).start()


        Thread(Runnable {
            println("Thread started!")
            Thread.sleep(1000)
            println("first Hello World!")
        }).start()
        println("Process end!")
    }

    fun startCoroutine(){
        GlobalScope.launch {
            delay(10000)
            println("Hello World!")
        }
        GlobalScope.launch {
            delay(1000)
            println("first Hello World!")
        }
        println("Process end!")
    }


    fun startBlockCoroutine(){
        GlobalScope.launch {
            Thread.sleep(10000)
            println("Hello World!")
        }
        GlobalScope.launch {
            Thread.sleep(1000)
            println("first Hello World!")
        }
        println("Process end!")
    }
}