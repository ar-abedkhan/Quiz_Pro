package com.abedkhan.quizpro;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class splashScreen extends AppCompatActivity {
 int count =1500;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

progressBar=findViewById(R.id.progressbar);



//splash screen with progressbar.................
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
        progressBar.setProgress(count);
                Intent splashintent=new Intent(splashScreen.this,Logein.class);
                startActivity(splashintent);
                finish();

            }
        },count);





    }
}