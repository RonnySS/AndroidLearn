package com.example.viewpager2learn.fragments

import android.util.Log
import android.view.Surface
import kotlin.math.log

class Activity :onClickListener{
    override fun funA() {
        print("一些A的操作")
    }




}


class EventManager{
    val screenBeClicked:Boolean = true
    var clickListener:onClickListener? = null

    fun B(a:Activity){
        if (screenBeClicked){
            a.funA()
        }
    }


    fun funB(){
        print("sss")
    }


}




interface onClickListener{
    fun funA()
}



interface passer{
    fun passValue(value:Int)
}


class A{
    val passedValue:Int = 5
    val aPasser:passer = B
    fun main(){
        aPasser.passValue(1)
    }

}

object B:passer{
    var needValue:Int = 0
    override fun passValue(value: Int) {
        needValue = value
    }

    fun passValue2(){

    }

}




//  ①                          ②
//  ↓                           ↓




fun main(){
    print("output is here")
    print(mian())
}