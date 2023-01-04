package com.abedkhan.quizpro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.abedkhan.quizpro.databinding.ActivityLogeinBinding;

public class Logein extends AppCompatActivity {
    ActivityLogeinBinding logeinbinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logeinbinding=ActivityLogeinBinding.inflate(getLayoutInflater());
        setContentView(logeinbinding.getRoot());
        EditText username;

logeinbinding.username.findViewById(R.id.username);






        SharedPreferences sharedPreferences=getSharedPreferences("MY_SP",MODE_PRIVATE);
        String sp_name=sharedPreferences.getString("name",getString(R.string.app_name));
        Log.i("TAG", "onCreate: "+sp_name);
        logeinbinding.username.setText(sp_name);





        logeinbinding.logeinButton.setOnClickListener(view -> {
            Log.i("TAG", "LOGEIN: ");

          String username1=     logeinbinding.username.getText().toString();
            if (username1.equals("")) {

                logeinbinding.username.setError("ENTER YOUR USER NAME!");
            }else {

                Intent intent =new Intent(Logein.this,home.class);
                startActivity(intent);
            }

        });

        logeinbinding.registrationButton.setOnClickListener(view -> {
            Log.i("TAG", "REGISTRATION: ");

          Intent intent=new Intent(Logein.this, MainActivity.class);
startActivity(intent);


        });




        }

    }
