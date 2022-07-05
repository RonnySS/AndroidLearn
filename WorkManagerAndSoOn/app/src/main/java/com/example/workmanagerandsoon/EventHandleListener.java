package com.example.workmanagerandsoon;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class EventHandleListener{
    private Context context;
    public EventHandleListener(Context context){
        this.context = context;
    }
    public void onButtonClicked(View view){
        Log.d("TAG", "onButtonClicked:被按了一下 ");
        Toast.makeText(context, "被按了一下", Toast.LENGTH_SHORT).show();

    }
}