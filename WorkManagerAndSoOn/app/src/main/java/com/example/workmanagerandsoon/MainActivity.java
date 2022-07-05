package com.example.workmanagerandsoon;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.workmanagerandsoon.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        tvAuthor = findViewById(R.id.author);
//        tvTitle = findViewById(R.id.title);
//        tvRating = findViewById(R.id.rating);
        Book book = new Book("Android高性能编程","叶问");
        book.rating = 5;
//        tvAuthor.setText(book.author);
//        tvRating.setText(book.rating);
//        tvTitle.setText(book.title);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        activityMainBinding.setEventHandler(new EventHandleListener(this));
        activityMainBinding.setVariable(BR.book,book);

        activityMainBinding.setNetworkImage("https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg");
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        activityMainBinding.setNetworkImage("https://img-blog.csdn.net/20171120115623218?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvd2doaGR6d3pxYngwMg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center");
        //activityMainBinding.setLocalImage(R.drawable.test_pic);
        //activityMainBinding.setNetworkImage(R.drawable.test_pic);

    }



    void uploadLog(){
        Constraints constraints = new Constraints.Builder()
                .setRequiresCharging(true)
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresBatteryNotLow(true)
                .build();
        OneTimeWorkRequest uploadWorkRequest = new OneTimeWorkRequest.Builder(UpLoadLogWorker.class).build();
        WorkManager.getInstance(this).enqueue(uploadWorkRequest);
    }
}