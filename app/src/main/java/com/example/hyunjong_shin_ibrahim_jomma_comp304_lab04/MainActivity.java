package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int SUCCESS_LOGIN_CODE = 1;
    boolean isLogIned;

    private Button btnSign;
    private int currentId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSign = (Button)findViewById(R.id.btnSign);

    }

    @Override
    protected void onResume() {
        super.onResume();
        CheckSharedPreferences();

    }

    private void CheckSharedPreferences() {
//        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
//        SharedPreferences.Editor editor = sharedPreferences.edit();
////            int id = Integer.parseInt(etNurseIdSignIn.getText().toString());
//
//        editor.putInt(getResources().getString(R.string.shared_preference_NURSE_ID),
//                Integer.parseInt(etNurseIdSignIn.getText().toString()));
//
//        editor.putBoolean(getResources().getString(R.string.shared_preference_Login), true);
        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
        isLogIned = sharedPreferences.getBoolean(getResources().getString(R.string.login_status),false);
        currentId = sharedPreferences.getInt(getResources().getString(R.string.shared_preference_NURSE_ID), 0);

        Log.w("myTag", "" + currentId +", " + isLogIned);

        if(isLogIned && currentId !=0){
            btnSign.setText("Sign Out");
            currentId = sharedPreferences.getInt(getResources().getString(R.string.shared_preference_NURSE_ID), 0);
            Log.w("myTag", currentId+"");
        }else {
            btnSign.setText("Sign in");

        }

    }


    //SignUp
    public void SignUp(View view){
            Intent intent = new Intent(this, SignUp.class);
            startActivity(intent);
    }

    public void btnSignIn(View view){
        Intent intent = new Intent(MainActivity.this, SignIn.class);
        startActivity(intent);
    }

    public void btnTestList(View view){
        if(isLogIned) {
            Intent intent = new Intent(this, PatientActivity.class);
            startActivity(intent);
        }{
            Toast.makeText(this, "Please Sign In First!!!", Toast.LENGTH_SHORT).show();
        }

    }


}