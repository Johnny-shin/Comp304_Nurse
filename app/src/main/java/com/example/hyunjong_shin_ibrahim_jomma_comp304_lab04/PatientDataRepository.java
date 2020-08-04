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

}


//    public LiveData<List<Nurse>> getAllNurses(){return mAllNurse;}
//
//    public void insert(Nurse nurse){
//        mNurseDao.insertNurse(nurse);
////        NurseRoomDatabase.databaseWriteExecutor.execute(()->{
////            mNurseDao.insertNurse(nurse);
////        });
//    }
//
//    //    Nurse findOneNurseName(int nurseId){
////        Nurse nurse = NurseRoomDatabase.databaseWriteExecutor.execute(()->{
////             mNurseDao.findOneNurseName(nurseId);
////        });
////         return nurse;
////    }
//    public Nurse findOneNurseName(int nurseId){
//        Nurse nurse = mNurseDao.findOneNurseName(nurseId);
//        return nurse;
//    }
//}
