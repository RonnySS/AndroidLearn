package com.example.viewmodelandlivedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initComponent();
        //initLiveDataComponent();

        //TimerViewModel timerViewModel = new ViewModelProvider(this).get(TimerViewModel.class);

        StudentViewModel studentViewModel = new ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication())).get(StudentViewModel.class);
        studentViewModel.getLiveDataStudent().observe(MainActivity.this, new Observer<List<Student>>() {
            @Override
            public void onChanged(List<Student> students) {
                for (Student student : students){
                    Log.d("TAG", "onChanged: "+student.name);
                }
            }
        });
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        MyDataBase.getInstance(MainActivity.this).studentDao().insertStudent(new Student("Deb","19"));
                    }
                }).start();
//                 timerViewModel.initProgress();


            }
        });



    }




    void initComponent(){
        final TextView tvTime = findViewById(R.id.tvTime);
        TimerViewModel timerViewModel = new ViewModelProvider(this).get(TimerViewModel.class);
        timerViewModel.setOnTimeChangeListener(new TimerViewModel.OnTimeChangeListener() {
            @Override
            public void onTimeChanged(int second) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvTime.setText("TIME:"+second);
                    }
                });
            }
        });
        timerViewModel.startTiming();
    }

    void initLiveDataComponent(){
        final TextView tvTimeForLiveData=findViewById(R.id.tvTimeForLiveData);
        TimerViewModel timerViewModel = new ViewModelProvider(this).get(TimerViewModel.class);
        final MutableLiveData<Integer> liveData = (MutableLiveData<Integer>) timerViewModel.getCurrentSecond();
        liveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                Log.d("TAG", "发生了改变onChanged: ");
                if (integer>10){
                    liveData.setValue(0);
                }
                tvTimeForLiveData.setText("TIME:"+integer);
            }
        });
//        timerViewModel.PostAValue();
        timerViewModel.startTiming();
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                liveData.setValue(1);

            }
        });
    }

}