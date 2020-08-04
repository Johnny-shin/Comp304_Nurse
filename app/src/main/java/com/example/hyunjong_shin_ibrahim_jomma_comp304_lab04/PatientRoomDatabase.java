package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao.PatientDao;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Nurse;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;

@Database(entities = {Patient.class}, version = 1)
public abstract class PatientRoomDatabase extends RoomDatabase {
    private static final String DATABASE = "Patient";
    private static PatientRoomDatabase instance;

    static PatientRoomDatabase getDatabase(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    PatientRoomDatabase.class,
                    DATABASE)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract PatientDao getPatientDao();
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


