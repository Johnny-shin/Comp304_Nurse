package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.model.Nurse;
import com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04.viewmodel.NurseViewModel;

public class SignIn extends AppCompatActivity {

    private NurseViewModel mNurseModel;

    EditText etNurseIdSignIn, etPasswordSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        etNurseIdSignIn = (EditText) findViewById(R.id.etNurseIdSignIn);
        etPasswordSignIn = (EditText) findViewById(R.id.etPasswordSignIn);


    }


    public void btnSignIn(View view) throws InterruptedException {
        if (TextUtils.isEmpty(etNurseIdSignIn.getText()) && TextUtils.isEmpty(etPasswordSignIn.getText())) {
            Toast.makeText(this, "Invalid Input!! Try again!", Toast.LENGTH_SHORT).show();
        } else {
            int nurse_id = Integer.parseInt(etNurseIdSignIn.getText().toString());
            mNurseModel = new ViewModelProvider(this).get(NurseViewModel.class);
            Nurse nurse = mNurseModel.findOneNurseName(nurse_id);
//            Toast.makeText(this, tempNurse.toString(), Toast.LENGTH_SHORT).show();
//            Nurse nurse = tempNurse.getValue();

            if (nurse == null) {
                Toast.makeText(this, "Invalid Account", Toast.LENGTH_SHORT).show();
            } else {
                Log.w("myTag", nurse.toString());
                SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                editor.putInt(getResources().getString(R.string.shared_preference_NURSE_ID),nurse_id);

                editor.putBoolean(getResources().getString(R.string.login_status), true);
                editor.commit();
            }


            finish();
        }
    }
}
