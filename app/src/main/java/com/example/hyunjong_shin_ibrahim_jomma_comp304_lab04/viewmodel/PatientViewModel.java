package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.NurseDataRepository;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.R;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Nurse;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class PatientViewModel extends AndroidViewModel {
    private NurseDataRepository mRepository;
    private LiveData<List<Patient>> mAllPatients;
    private int NurseId;

    public PatientViewModel(@NonNull Application application) {
        super(application);
        mRepository = new NurseDataRepository(application);

        SharedPreferences sharedPreferences = getApplication().getSharedPreferences(getApplication().getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
        NurseId = sharedPreferences.getInt(getApplication().getResources().getString(R.string.shared_preference_NURSE_ID), 0);

    }

//    public LiveData<List<Nurse>> getAllPatientByNurseId(){
//        return mAllNurses;
//    }

    public void insert(Nurse nurse){
        mRepository.insert(nurse);
    }

    public Nurse findOneNurseName(int nurseId){
        Nurse nurse =  mRepository.findOneNurseName(nurseId);
        return nurse;
    }

}


