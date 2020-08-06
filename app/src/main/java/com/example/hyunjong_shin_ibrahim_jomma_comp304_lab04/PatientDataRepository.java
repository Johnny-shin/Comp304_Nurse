package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.dao.PatientDao;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Nurse;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;

import java.util.List;

public class PatientDataRepository {
    private PatientDao mPatientDao;

    public PatientDataRepository(Application application) {
        PatientRoomDatabase db = PatientRoomDatabase.getDatabase(application);
        mPatientDao = db.getPatientDao();
    }

    public LiveData<List<Patient>> getAllPatientByNurseId(int nurseId) {
        return mPatientDao.getAllPatientByNurseId(nurseId);
    }

    public List<Patient> SyncGetPatientByNurseId(int nurseId) {
        return mPatientDao.SyncGetPatientByNurseId(nurseId);
    }

    public void insertPatient(Patient patient){
        mPatientDao.insertPatient(patient);
    }

    public List<Patient> getAllPatient(){
       return mPatientDao.getAllPatient();
    }

    public void updatePatient(Patient patient){
        mPatientDao.updatePatient(patient);
    }


}


