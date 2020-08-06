package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.PatientDataRepository;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.R;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.TestDataRepository;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Test;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class TestViewModel extends AndroidViewModel {
    private TestDataRepository mRepository;
    private int NurseId;
    private int PatientId;

    public TestViewModel(@NonNull Application application) {
        super(application);
        mRepository = new TestDataRepository(application);

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(getApplication().getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
        NurseId = sharedPreferences.getInt(getApplication().getResources().getString(R.string.shared_preference_NURSE_ID), 0);

    }

    public List<Test> getAllTestByNurseId(int nurseId) {
        return mRepository.getAllTestByNurseId(nurseId);
    }

    public List<Test> SyncGetTestByNurseIdPatientId(int nurseId, int patientId) {
        return mRepository.SyncGetTestByNurseIdPatientId(nurseId,patientId);
    }

    public void insertTest(Test test) {
        mRepository.insertTest(test);
    }


//
//
//    @Query("SELECT * FROM patient_table WHERE :nurseId")
//    List<Test> getAllTestByNurseId(int nurseId);
//
//    @Query("SELECT * FROM test_table WHERE nurseId = :nurseId AND patientId = :patientId")
//    List<Test> SyncGetTestByNurseIdPatientId(int nurseId, int patientId);
//
//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    void insertTest(Test test);


//    public LiveData<List<Patient>> getAllPatientByNurseId(int nurseId) {
//        return mRepository.getAllPatientByNurseId(nurseId);
//    }
//
//
//    public List<Patient> SyncGetPatientByNurseId(int nurseId) {
//        return mRepository.SyncGetPatientByNurseId(nurseId);
//    }
//
//    public void insertPatient(Patient patient){
//        mRepository.insertPatient(patient);
//    }


}
