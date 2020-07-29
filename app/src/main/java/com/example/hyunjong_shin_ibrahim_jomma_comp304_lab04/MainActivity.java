package com.example.hyunjong_shin_ibrahim_jomma_comp304_lab04;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int SUCCESS_LOGIN_CODE = 1;


    private Button btnSign;
    private int currentId = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSign = (Button)findViewById(R.id.btnSign);

        CheckSharedPreferences();
    }

    private void CheckSharedPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(getResources().getString(R.string.shared_preference_text), MODE_PRIVATE);
        boolean isLogIned = sharedPreferences.getBoolean(getResources().getString(R.string.shared_preference_Login),false);

        if(isLogIned){
            btnSign.setText("Sign Out");
            currentId = sharedPreferences.getInt(getResources().getString(R.string.shared_preference_NURSE_ID), 0);
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

//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == SUCCESS_LOGIN_CODE && resultCode == RESULT_OK) {
//            btnSign.setText("Log Out");
//            Word word = new Word(data.getStringExtra(NewWordActivity.EXTRA_REPLY));
//        }
//    }




}