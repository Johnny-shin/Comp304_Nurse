package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Patient;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Test;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel.NurseViewModel;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel.TestViewModel;

import java.util.ArrayList;
import java.util.List;

public class ViewTestInfoActivity extends AppCompatActivity {

    TextView ptText;
    ListView listView;
    private int patientId;
    private int nurseId;
    private TestViewModel mTestViewModel;
    private List<Test> tests;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_test_info);
        Intent intent = getIntent();
        String fullName = intent.getExtras().getString("PatientFullName");
        patientId = intent.getExtras().getInt("PatientId");
        listView = (ListView)findViewById(R.id.lvTestList);
        ptText = (TextView) findViewById(R.id.ptText);
        ptText.append(fullName);
        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
        nurseId = sharedPreferences.getInt(getResources().getString(R.string.shared_preference_NURSE_ID), 0);
        mTestViewModel = new ViewModelProvider(this).get(TestViewModel.class);

        tests = mTestViewModel.SyncGetTestByNurseIdPatientId(nurseId, patientId);
        ArrayList<String> stringTest = new ArrayList();
        for(Test t : tests){
            stringTest.add(t.toString());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stringTest);
        listView.setAdapter(adapter);
    }


    public void RegisterTest(View view){
        Intent intent = new Intent(this,TestActivity.class);
        intent.putExtra("PatientId", patientId);

        startActivity(intent);

    }

}