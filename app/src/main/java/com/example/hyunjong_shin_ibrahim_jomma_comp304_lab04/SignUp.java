package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText etNurseId, etFirstName, etLastName, etDepartment, etPassword, etPasswordComfirm;
    private NurseViewModel mNurseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etNurseId = (EditText)findViewById(R.id.etNurseId);
        etFirstName = (EditText)findViewById(R.id.etfirstName);
        etLastName = (EditText)findViewById(R.id.etlastName);
        etDepartment = (EditText)findViewById(R.id.etDepartment);
        etPassword = (EditText)findViewById(R.id.etPassword);
        etPasswordComfirm = (EditText)findViewById(R.id.etPasswordComfirm);
    }

    public void btnClear(View view){
        etFirstName.setText("");
        etLastName.setText("");
        etDepartment.setText("");
        etPassword.setText("");
        etPasswordComfirm.setText("");
    }

    public void NurseRigister(View view) {
        if (TextUtils.isEmpty(etFirstName.getText()) && TextUtils.isEmpty(etLastName.getText()) && TextUtils.isEmpty(etDepartment.getText()) &&
                TextUtils.isEmpty(etPassword.getText()) && TextUtils.isEmpty(etPasswordComfirm.getText())) {
            Toast.makeText(this, "Invalid Input!!", Toast.LENGTH_SHORT).show();

        } else if (!etPassword.getText().toString().equals(etPasswordComfirm.getText().toString())) {
            Toast.makeText(this, "Password Not match!!", Toast.LENGTH_SHORT).show();
        } else {
            Nurse nurse = new Nurse(Integer.parseInt(etNurseId.getText().toString()), etFirstName.getText().toString(), etLastName.getText().toString(),
                    etDepartment.getText().toString(), etPassword.getText().toString());

            mNurseViewModel = new ViewModelProvider(this).get(NurseViewModel.class);
            mNurseViewModel.insert(nurse);
            Toast.makeText(this, nurse.toString(), Toast.LENGTH_SHORT).show();
            try {
                Thread.sleep(Toast.LENGTH_SHORT);
            }catch (Exception e){
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            finish();
        }


    }




}