package com.example.viewmodelandlivedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class StudentViewModel extends AndroidViewModel {
    private MyDataBase myDataBase;
    private LiveData<List<Student>> liveDataStudent;
    public StudentViewModel(@NonNull Application application) {
        super(application);
        myDataBase = MyDataBase.getInstance(application);
        liveDataStudent = myDataBase.studentDao().getStudentList();

    }


    public LiveData<List<Student>> getLiveDataStudent(){
        return liveDataStudent;
    }
}
