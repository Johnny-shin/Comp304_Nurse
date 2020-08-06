package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Test;

import java.util.List;

@Dao
public interface TestDao {

    @Query("SELECT * FROM test_table WHERE :nurseId")
    List<Test> getAllTestByNurseId(int nurseId);

    @Query("SELECT * FROM test_table WHERE nurseId = :nurseId AND patientId = :patientId")
    List<Test> SyncGetTestByNurseIdPatientId(int nurseId, int patientId);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTest(Test test);
}
