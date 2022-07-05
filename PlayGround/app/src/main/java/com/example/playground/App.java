package com.example.playground;

import android.app.Application;
import android.hardware.Camera;

import com.example.playground.callback.EmptyCallback;
import com.kingja.loadsir.callback.HintCallback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new EmptyCallback())
                .setDefaultCallback(EmptyCallback.class)
                .commit();

    }
}
