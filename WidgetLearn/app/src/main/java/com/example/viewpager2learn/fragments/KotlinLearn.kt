package com.example.viewpager2learn.fragments

import java.lang.reflect.Array.get


//class KotlinLearnWrapper{
//    companion object KotlinLearn {
//        @JvmStatic
//        fun  foo(){
//            print(1)
//        }
//    }
//}

//class User private constructor(name:String){
//    companion object{
//        val user:User? by lazy { User("name") }
//
//        @JvmStatic
//        fun create(name: String):User?{
//            return User(name)
//        }
//
//        fun loadUser():User?{
//            return create("ss");
//        }
//
//    }
//}


abstract class BaseSingleton<in P, out T> {
    @Volatile
    private var instance: T? = null
    protected abstract fun creator(param: P): T

    fun getInstance(param: P): T =
        instance ?: synchronized(this) {
            //            ④
            //            ↓
            instance ?: creator(param).also { instance = it }
        }
}



fun mian() = 2


class UserManager private constructor(name: String) {
    var UserManager.attrs:String
        get() = "ssd"
        set(value) { attrs = value}

    companion object : BaseSingleton<String, UserManager>() {
        override fun creator(param: String): UserManager {
            if (param != "mdzz") {
                return UserManager(param)
            }else{
                return UserManager("刁民")
            }

    }

    }

    fun foo(){

        this.attrs = "ss"
    }
}





val String.lastElement: Char? get() = if (isEmpty()) { null } else { get(length - 1) }


fun UserManager.extMethod(){
    print("Extension method")
}


class KotlinLearn {
    var UserManager.attrs:String
        get() = "ssd"
        set(value) { attrs = value}

    fun main(){
        fun UserManager.extFunc(){
            print("1")
        }



        UserManager.getInstance("ss").extMethod()




        UserManager.getInstance("mdzz").extFunc()
        UserManager.getInstance("mzdd").attrs = "sdd"

    }
}
