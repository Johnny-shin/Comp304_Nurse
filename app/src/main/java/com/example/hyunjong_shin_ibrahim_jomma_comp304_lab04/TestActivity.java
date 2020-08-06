package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Test;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel.TestViewModel;

public class TestActivity extends AppCompatActivity {

    private int patientId, nurseId;
    private TestViewModel mTestViewModel;
    EditText etTestName,etTestDescription,etTemperature;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Intent intent = getIntent();
        patientId = intent.getExtras().getInt("PatientId");
        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
        nurseId = sharedPreferences.getInt(getResources().getString(R.string.shared_preference_NURSE_ID), 0);

        etTestName = (EditText)findViewById(R.id.etTestName);
        etTestDescription = (EditText)findViewById(R.id.etTestDescription);
        etTemperature = (EditText)findViewById(R.id.etTemperature);

        mTestViewModel = new ViewModelProvider(this).get(TestViewModel.class);

    }

    public void btnTestClear(View view){
        etTestName.setText("");
        etTestDescription.setText("");
        etTemperature.setText("");
    }

    public void TestRegister(View view){
        //insert
        if (TextUtils.isEmpty(etTestName.getText()) || TextUtils.isEmpty(etTestDescription.getText()) || TextUtils.isEmpty(etTemperature.getText()) ){
            Toast.makeText(this, "Must be filled all values!!", Toast.LENGTH_SHORT).show();
        }else {
            double temperature;
            try {
                temperature = Double.parseDouble(etTemperature.getText().toString());
            }catch (Exception e){
                Toast.makeText(this, "Must be Numeric value in Temperature!!", Toast.LENGTH_SHORT).show();
                return;
            }
            mTestViewModel.insertTest(new Test(patientId, nurseId, etTestName.getText().toString(), etTestDescription.getText().toString(), temperature));

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    //    public Test(int testId, int patientId, int nurseId, String testName, String test_description, double temperature) {
}