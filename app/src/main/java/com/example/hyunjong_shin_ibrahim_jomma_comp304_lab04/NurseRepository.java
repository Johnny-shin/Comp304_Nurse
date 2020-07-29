package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NurseRepository {

    private NurseDao mNurseDao;
    private LiveData<List<Nurse>> mAllNurse;
    private LiveData<Nurse> mNurse;

    NurseRepository(Application application){
        NurseRoomDatabase db = NurseRoomDatabase.getDatabase(application);
        mNurseDao = db.nurseDao();
        mAllNurse = mNurseDao.getAllNurse();
    }

    LiveData<List<Nurse>> getAllNurses(){return mAllNurse;}

    void insert(Nurse nurse){
        NurseRoomDatabase.databaseWriteExecutor.execute(()->{
            mNurseDao.insertNurse(nurse);
        });
    }

    LiveData<Nurse> findOneNurseName(int nurseId){
         NurseRoomDatabase.databaseWriteExecutor.execute(()->{
            mNurseDao.findOneNurseName(nurseId);
        });
         return mNurse;
    }
}
