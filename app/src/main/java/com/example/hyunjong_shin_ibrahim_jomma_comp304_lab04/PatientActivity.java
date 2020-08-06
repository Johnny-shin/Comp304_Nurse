package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel.PatientViewModel;

import java.util.List;

public class PatientActivity extends AppCompatActivity implements PatientAdapter.ItemClickListener {

    private int nurseId;
    private PatientViewModel mPatientViewModel;
    private List<Patient> patients;
    private RecyclerView rvPatientList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient);
        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
        nurseId = sharedPreferences.getInt(getResources().getString(R.string.shared_preference_NURSE_ID), 0);

        mPatientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        patients = mPatientViewModel.SyncGetPatientByNurseId(nurseId);
        if (patients == null || patients.size() == 0) {
            Toast.makeText(this, "No Patinet", Toast.LENGTH_SHORT).show();
        } else {
            Log.w("myTag", patients.toString());
            rvPatientList = (RecyclerView) findViewById(R.id.rvPatientList);
            rvPatientList.setLayoutManager(new LinearLayoutManager(this));
            PatientAdapter patientAdapter = new PatientAdapter(this, patients);
            patientAdapter.setItemClickListener(this);
            rvPatientList.setAdapter(patientAdapter);
        }




    }

    public void btnPatientRegister(View view) {
        Intent intent = new Intent(this,PatientRegisterActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onItemClick(View view, int position) {
        Patient temp = patients.get(position);
        Intent intent = new Intent(this, ViewTestInfoActivity.class);
        intent.putExtra("PatientFullName", temp.getFirstname()+" " +temp.getLastname());
        intent.putExtra("PatientId", temp.getPatientId());
        startActivity(intent);
    }
}