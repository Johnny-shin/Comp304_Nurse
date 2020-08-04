package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;

import java.util.List;

@Dao
public interface PatientDao {

    @Query("SELECT * FROM patient_table WHERE :nurseId")
    LiveData<List<Patient>> getAllPatientByNurseId(int nurseId);

    @Query("SELECT * FROM patient_table WHERE :nurseId")
    List<Patient> SyncGetPatientByNurseId(int nurseId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPatient();
}
