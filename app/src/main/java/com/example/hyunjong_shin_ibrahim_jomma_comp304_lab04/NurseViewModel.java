package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {
    private NurseRepository mRepository;
    private LiveData<List<Nurse>> mAllNurses;

    public NurseViewModel(@NonNull Application application) {
        super(application);
        mRepository = new NurseRepository(application);
        mAllNurses = mRepository.getAllNurses();
    }

    public LiveData<List<Nurse>> getmAllNurses(){
        return mAllNurses;
    }

    void insert(Nurse nurse){
        mRepository.insert(nurse);
    }

    public LiveData<Nurse> findOneNurseName(int nurseId){
        LiveData<Nurse> singleNurse =  mRepository.findOneNurseName(nurseId);
        return singleNurse;
    }
//    LiveData<List<Nurse>> getAllNurses{return mAllNurses;}
//    @NonNull
//    @Override
//    public <T extends Application> T getApplication() {
//        return super.getApplication();
//    }
}
