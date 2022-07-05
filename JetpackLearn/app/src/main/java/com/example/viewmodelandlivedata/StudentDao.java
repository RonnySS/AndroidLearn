package com.example.viewmodelandlivedata;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface StudentDao {
    @Insert
    void insertStudent(Student student);

    @Delete
    void deleteStudent(Student student);

    @Update
    void updateStudent(Student student);

    @Query("select * from student")
    LiveData<List<Student>> getStudentList();

    @Query("select * from student where id = :id")
    Student getStudentById(int id);



}
