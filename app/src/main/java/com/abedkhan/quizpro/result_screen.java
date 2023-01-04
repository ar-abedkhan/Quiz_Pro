package com.abedkhan.quizpro;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.abedkhan.quizpro.databinding.ActivityResultScreenBinding;

public class result_screen extends AppCompatActivity {
ActivityResultScreenBinding activityResultScreenBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityResultScreenBinding=ActivityResultScreenBinding.inflate(getLayoutInflater());
        setContentView(activityResultScreenBinding.getRoot());










    }
}