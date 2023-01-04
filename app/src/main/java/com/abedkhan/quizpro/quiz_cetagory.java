package com.abedkhan.quizpro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.abedkhan.quizpro.databinding.ActivityQuizCetagoryBinding;
import com.abedkhan.quizpro.databinding.ActivityQuizItBinding;

public class quiz_cetagory extends AppCompatActivity {
ActivityQuizCetagoryBinding activityQuizCetagoryBinding;
TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityQuizCetagoryBinding=ActivityQuizCetagoryBinding.inflate(getLayoutInflater());
        setContentView(activityQuizCetagoryBinding.getRoot());


userName=findViewById(R.id.user_name);
             androidx.appcompat.widget.Toolbar toolbar=findViewById(R.id.mytoolbar);
               setSupportActionBar(toolbar);



        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                quiz_cetagory.this,
                activityQuizCetagoryBinding.drawermenu,
                toolbar,
                R.string.open,
                R.string.close
        );activityQuizCetagoryBinding.drawermenu.addDrawerListener(toggle);
        toggle.syncState();



//set up bottom menu clickable.........................


        activityQuizCetagoryBinding.bottommenu.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.hommenue:
                    Intent intent=new Intent(quiz_cetagory.this,home.class);
                    startActivity(intent);
                    break;
                case R.id.profilemenu:
                    Intent intentprofile = new Intent(quiz_cetagory.this, my_profile.class);
                    startActivity(intentprofile);
                    break;
                case R.id.dashboardmenu:
                    Intent intentdashboard = new Intent(quiz_cetagory.this, dashboard.class);
                    startActivity(intentdashboard);
                    break;
                case R.id.categorymenu:
                    Intent intentcetagory = new Intent(quiz_cetagory.this, quiz_cetagory.class);
                    startActivity(intentcetagory);
                    break;
                case R.id.favourite:
                    Toast.makeText(this, "Under devolopment..!", Toast.LENGTH_SHORT).show();
                     Intent intentfavo = new Intent(quiz_cetagory.this, quiz_cetagory.class);
                    startActivity(intentfavo);
                    break;
            }
            return true;
        });




        activityQuizCetagoryBinding.navview.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.hommenue:
                    Log.i("tag", "home menu: ");
                    Intent intenthome = new Intent(quiz_cetagory.this, home.class);
                    startActivity(intenthome);
                    break;
                case R.id.profilemenu:
                    Intent intentprofile = new Intent(quiz_cetagory.this, my_profile.class);
                    startActivity(intentprofile);
                    break;
                case R.id.dashboardmenu:
                    Intent intentdashboard = new Intent(quiz_cetagory.this, dashboard.class);
                    startActivity(intentdashboard);
                    break;
                case R.id.categorymenu:
                    Intent intentcetagory = new Intent(quiz_cetagory.this, quiz_cetagory.class);
                    startActivity(intentcetagory);
                    break;
                case R.id.settingsmenu:
                    Toast.makeText(this, "This Function is on devoloper mood!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.supportmenu:
                    Toast.makeText(this, "This Function is on devoloper mood!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.suggestionmenu:
                    Toast.makeText(this, "This Function is on devoloper mood!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.loge_outmenu:
                    Toast.makeText(this, "LOGGING OUT....", Toast.LENGTH_SHORT).show();
                    Intent logeoutintent = new Intent(quiz_cetagory.this, Logein.class);
                    startActivity(logeoutintent);
                    break;
                default:
                    Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();

            }

            return true;

        });




        activityQuizCetagoryBinding.categoryGame.setOnClickListener(view -> {
            Log.i("TAG", "Game clicked: ");
            Intent intent = new Intent(quiz_cetagory.this,quiz_game.class);
            startActivity(intent);
        });
 activityQuizCetagoryBinding.categoryTechonolodge.setOnClickListener(view -> {
            Log.i("TAG", "Game clicked: ");
            Intent intent = new Intent(quiz_cetagory.this,quiz_it.class);
            startActivity(intent);
        });
 activityQuizCetagoryBinding.categoryEducation.setOnClickListener(view -> {
            Log.i("TAG", "Game clicked: ");
            Intent intent = new Intent(quiz_cetagory.this,quiz_wducation.class);
            startActivity(intent);
        });
 activityQuizCetagoryBinding.cetagoryGlobal.setOnClickListener(view -> {
            Log.i("TAG", "Game clicked: ");
            Intent intent = new Intent(quiz_cetagory.this,quiz_global.class);
            startActivity(intent);
        });
 activityQuizCetagoryBinding.categoryFood.setOnClickListener(view -> {
            Log.i("TAG", "Game clicked: ");
            Intent intent = new Intent(quiz_cetagory.this,quiz_food.class);
            startActivity(intent);
        });
 activityQuizCetagoryBinding.categoryOthers.setOnClickListener(view -> {
           Log.d("TAG", "Game clicked: ");
            Intent intent = new Intent(quiz_cetagory.this,quiz_others.class);
            startActivity(intent);
        });



//        SharedPreferences sharedPreferences=getSharedPreferences("MY_SP",MODE_PRIVATE);
//        String sp_name=sharedPreferences.getString("name",getString(R.string.app_name));
//        Log.i("LOG", "onCreate: "+sp_name);
//          userName.setText(sp_name);



//        if (sp_name.equals("")) {
//            userName.setText("");
//
//        }else {
//            userName.setText(sp_name);
//
//        }


    }

    private void setSupportActionBar(Toolbar toolbar) {
    }
}