package com.example.playground;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.playground.callback.EmptyCallback;
import com.example.playground.databinding.ActivityMainBinding;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    LoadService loadService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        View view = LayoutInflater.from(this).inflate(R.layout.activity_main,null);
        setContentView(R.layout.activity_main);



//        setContentView(R.layout.activity_main);

        /*
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request request = new Request.Builder().url("https://www.baidu.com").get().build();
        okHttpClient.newCall(request).enqueue(new okhttp3.Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {

            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {

            }
        });

         */
        LoadSir.getDefault().register(this, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                Log.d("TAG", "onReload: 在callback发生MainActivity的注册");
            }
        });

        LoadSir loadSir = new LoadSir.Builder()
                .addCallback(new EmptyCallback())
                .setDefaultCallback(EmptyCallback.class)
                .build();

        loadService = loadSir.register(this, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {
                loadService.showCallback(EmptyCallback.class);
                Log.d("TAG", "onReload: ");
                //loadService.showSuccess();
            }
        });
        loadService.showSuccess();



    }
}