package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao.PatientDao;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao.TestDao;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Nurse;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Test;

@Database(entities = {Test.class}, version = 1, exportSchema = false)
public abstract class TestRoomDatabase extends RoomDatabase {
    private static final String DATABASE = "Test";
    private static TestRoomDatabase instance;

    static TestRoomDatabase getDatabase(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    TestRoomDatabase.class,
                    DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract TestDao getPatientDao();
}

/*

@Database(entities = {Nurse.class}, version = 1)
public abstract class NurseRoomDatabase extends RoomDatabase{
    private static final String DATABASE = "Nurse";
    private static NurseRoomDatabase instance;
    static NurseRoomDatabase getDatabase(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    NurseRoomDatabase.class,
                    DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract NurseDao getNurseDao();
}
 */


