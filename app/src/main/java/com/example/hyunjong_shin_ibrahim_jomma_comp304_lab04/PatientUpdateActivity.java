package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Test;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel.PatientViewModel;

import java.util.ArrayList;
import java.util.List;

public class PatientUpdateActivity extends AppCompatActivity {

    ListView listView;
    private PatientViewModel mPatientViewModel;
    List<Patient> patients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_update);
        listView = (ListView) findViewById(R.id.lvUpdateList);
        mPatientViewModel = new ViewModelProvider(this).get(PatientViewModel.class);
        patients = mPatientViewModel.getAllPatient();

        ArrayList<String> stringPatient = new ArrayList();
        for (Patient t : patients) {
            stringPatient.add(t.getPatientId() + "\n" + t.getFirstname() + " " + t.getLastname());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringPatient);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(PatientUpdateActivity.this, PatientRegisterActivity.class);
                intent.putExtra("UpdatePatientId", patients.get(position).getPatientId());
                startActivity(intent);
            }
        });
    }


//
//                new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    Intent intent = new Intent(PatientUpdateActivity.this, PatientRegisterActivity.class);
//                    intent.putExtra("UpdatePatientId", patients.get(position).getPatientId());
//                    startActivity(intent);
//                }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//
//            }
//        });


}
