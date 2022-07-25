package com.example.kotlinplayground

import android.app.Application
import android.util.Log
import java.lang.Exception
import java.security.SecureRandom
import javax.net.ssl.*
import javax.security.cert.X509Certificate

class mApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("TAG", "应用onCreate: ")
        //SSLAgent.getInstance().trustAllHttpsCertificates()
    }



}