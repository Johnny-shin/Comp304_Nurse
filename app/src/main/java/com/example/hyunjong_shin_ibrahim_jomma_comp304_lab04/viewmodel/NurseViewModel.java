package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.NurseDataRepository;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Nurse;

import java.util.List;

public class NurseViewModel extends AndroidViewModel {
    private NurseDataRepository mRepository;
    private LiveData<List<Nurse>> mAllNurses;
    private LiveData<Nurse> mNurse;


    public NurseViewModel(@NonNull Application application) {
        super(application);
        mRepository = new NurseDataRepository(application);
        mAllNurses = mRepository.getAllNurses();
//        mNurse = mRepository.findOneNurseName()
    }

    public LiveData<List<Nurse>> getmAllNurses(){
        return mAllNurses;
    }

    public void insert(Nurse nurse){
        mRepository.insert(nurse);
    }

    public Nurse findOneNurseName(int nurseId){
        Nurse nurse =  mRepository.findOneNurseName(nurseId);
        return nurse;
    }

}
