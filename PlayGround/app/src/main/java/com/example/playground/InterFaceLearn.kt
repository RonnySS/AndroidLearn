package com.example.playground

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

interface test{
    fun fun1()
}

class TestImple : test{
    override fun fun1() {
        Log.d("TAG", "fun1: ")
    }

}

fun main(){

}