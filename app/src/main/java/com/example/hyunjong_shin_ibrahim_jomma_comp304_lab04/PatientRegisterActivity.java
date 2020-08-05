package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel.PatientViewModel;

public class PatientRegisterActivity extends AppCompatActivity {

    PatientViewModel mPatientViewModel;
    EditText etPatientFirstName, etPatientLastName, etPatientDepartment, etPatientRoom;
    int nurseId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_register);
        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
        nurseId = sharedPreferences.getInt(getResources().getString(R.string.shared_preference_NURSE_ID), 0);
        mPatientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        etPatientFirstName = (EditText) findViewById(R.id.etPatientFirstName);
        etPatientLastName = (EditText) findViewById(R.id.etPatientLastName);
        etPatientDepartment = (EditText) findViewById(R.id.etPatientDepartment);
        etPatientRoom = (EditText) findViewById(R.id.etPatientRoom);
    }

    public void btnPatientRigister(View view){
        Patient patient = new Patient();
        patient.setFirstname(etPatientFirstName.getText().toString());
        patient.setLastname(etPatientFirstName.getText().toString());
        patient.setDepartment(etPatientFirstName.getText().toString());
        patient.setRoom(etPatientFirstName.getText().toString());
        patient.setNurseId(nurseId);
        mPatientViewModel.insertPatient(patient);
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void btnPatientFormClear(View view){
        etPatientFirstName.setText("");
        etPatientLastName.setText("");
        etPatientDepartment.setText("");
        etPatientRoom.setText("");
    }
}