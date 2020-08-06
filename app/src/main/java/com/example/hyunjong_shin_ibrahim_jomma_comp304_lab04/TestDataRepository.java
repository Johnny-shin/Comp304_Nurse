package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import android.app.Application;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao.TestDao;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Test;

import java.util.List;

public class TestDataRepository {
    private TestDao mTestDao;

    public TestDataRepository(Application application) {
        TestRoomDatabase db = TestRoomDatabase.getDatabase(application);
        mTestDao = db.getPatientDao();
    }

    public List<Test> getAllTestByNurseId(int nurseId) {
        return mTestDao.getAllTestByNurseId(nurseId);
    }

    public List<Test> SyncGetTestByNurseIdPatientId(int nurseId, int patientId) {
        return mTestDao.SyncGetTestByNurseIdPatientId(nurseId, patientId);
    }

    public void insertTest(Test test) {
        mTestDao.insertTest(test);
    }


//    @Query("SELECT * FROM patient_table WHERE :nurseId")
//    List<Test> getAllTestByNurseId(int nurseId);
//
//    @Query("SELECT * FROM test_table WHERE nurseId = :nurseId AND patientId = :patientId")
//    List<Test> SyncGetTestByNurseIdPatientId(int nurseId, int patientId);
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertTest(Patient patient);
}


