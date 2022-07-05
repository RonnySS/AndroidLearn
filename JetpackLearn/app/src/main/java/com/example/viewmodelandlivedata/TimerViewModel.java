package com.example.viewmodelandlivedata;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModel extends ViewModel {
    private Timer timer;
    private int currentSecond;
    private MutableLiveData<Integer> LiveDataSecond,progress;
    private OnTimeChangeListener onTimeChangeListener;

    public LiveData<Integer> getProgress(){
        if (progress == null){
            progress = new MutableLiveData<>();
            Log.d("TAG", "getProgress: "+progress.hashCode());
        }
        return progress;
    }


    public void setOnTimeChangeListener(OnTimeChangeListener onTimeChangeListener){
        this.onTimeChangeListener = onTimeChangeListener;
    }


    public LiveData<Integer> getCurrentSecond(){
        if (LiveDataSecond == null){
            LiveDataSecond = new MutableLiveData<>();
        }
        return LiveDataSecond;
    }
    

    @Override
    protected void onCleared() {
        super.onCleared();
        timer.cancel();
        progress = null;
        LiveDataSecond = null;
    }

    public interface OnTimeChangeListener{
        void onTimeChanged(int second);
    }

    public void startTiming(){
        if (timer == null){
            currentSecond = 0;
            LiveDataSecond.setValue(0);
            Log.d("TAG", "startTiming: 执行了一次，在"+Thread.currentThread().getName());
            timer = new Timer();
            TimerTask timerTask = new TimerTask() {
                @Override
                public void run() {
                    LiveDataSecond.postValue(LiveDataSecond.getValue()+1);
                    Log.d("TAG", "startTiming: 执行了一次"+LiveDataSecond.getValue()+"在"+Thread.currentThread().getId());

                    currentSecond++;
                    if (onTimeChangeListener!=null){
                        onTimeChangeListener.onTimeChanged(currentSecond);
                    }
                }
            };
            timer.schedule(timerTask,1000,1000);
        }
    }

    public void PostAValue(){
        LiveDataSecond.setValue(5);
    }

    public void  initProgress(){
        progress.setValue(30);
    }

}
