package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SignIn extends AppCompatActivity {

    private NurseViewModel mNurseModel;

    EditText etNurseIdSignIn, etPasswordSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mNurseModel = new ViewModelProvider(this).get(NurseViewModel.class);
        etNurseIdSignIn = (EditText)findViewById(R.id.etNurseIdSignIn);
        etPasswordSignIn = (EditText)findViewById(R.id.etPasswordSignIn);


    }


    public void btnSignIn(View view){
        if(TextUtils.isEmpty(etNurseIdSignIn.getText()) && TextUtils.isEmpty(etPasswordSignIn.getText())){
            Toast.makeText(this, "Invalid Input!! Try again!", Toast.LENGTH_SHORT).show();
        }else {
            int id = Integer.parseInt(etNurseIdSignIn.getText().toString());
             if(mNurseModel.findOneNurseName(id).hasObservers()){
                mNurseModel.findOneNurseName(id).;
             }


            SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
//            int id = Integer.parseInt(etNurseIdSignIn.getText().toString());

            editor.putInt(getResources().getString(R.string.shared_preference_NURSE_ID),
                    Integer.parseInt(etNurseIdSignIn.getText().toString()));

            editor.putBoolean(getResources().getString(R.string.shared_preference_Login), true);


            finish();
        }
    }

}