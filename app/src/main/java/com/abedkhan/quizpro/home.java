package com.abedkhan.quizpro;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.abedkhan.quizpro.databinding.ActivityHomeBinding;
public class home extends AppCompatActivity {
    ActivityHomeBinding activityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(activityHomeBinding.getRoot());



//     activityHomeBinding.swithTmeme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//         @Override
//         public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//             if (b){
//
//                 AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
//             }else {
//                 AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
//
//             }
//         }
//     });


        Toolbar toolbar =findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);


//set tool bar/ action bar................................................
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                home.this,
                activityHomeBinding.drawermenu,
                toolbar,
                R.string.open,
                R.string.close
        );activityHomeBinding.drawermenu.addDrawerListener(toggle);
        toggle.syncState();


//set bottom menu list clickable........................................
                    activityHomeBinding.bottommenu.setOnNavigationItemSelectedListener(item -> {
                        switch (item.getItemId()){
                            case R.id.hommenue:
                                Intent intent=new Intent(home.this,home.class);
                                startActivity(intent);
                                break;
                            case R.id.profilemenu:
                                Intent intentprofile = new Intent(home.this, my_profile.class);
                                startActivity(intentprofile);
                                break;
                            case R.id.dashboardmenu:
                                Intent intentdashboard = new Intent(home.this, dashboard.class);
                                startActivity(intentdashboard);
                                break;
                            case R.id.categorymenu:
                                Intent intentcetagory = new Intent(home.this, quiz_cetagory.class);
                                startActivity(intentcetagory);
                                break;
                            case R.id.favourite:
                                Intent intentfavo = new Intent(home.this, quiz_cetagory.class);
                                startActivity(intentfavo);
                                break;
                        }
                        return true;
                    });


//set drawer nev menu clickable...................................


        activityHomeBinding.navvie.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.hommenue:
                    Log.i("tag", "home menu: ");
                    Intent intenthome = new Intent(home.this, home.class);
                    startActivity(intenthome);
                    break;
                case R.id.profilemenu:
                    Intent intentprofile = new Intent(home.this, my_profile.class);
                    startActivity(intentprofile);
                    break;
                case R.id.dashboardmenu:
                    Intent intentdashboard = new Intent(home.this, dashboard.class);
                    startActivity(intentdashboard);
                    break;
                case R.id.categorymenu:
                    Intent intentcetagory = new Intent(home.this, quiz_cetagory.class);
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
                    Intent logeoutintent = new Intent(home.this, Logein.class);
                    startActivity(logeoutintent);
                    break;
                default:
                    Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();

            }

            return true;

        });









// leyout get button clickable......................................................

        activityHomeBinding.playQuiz.setOnClickListener(view -> {
            Log.d("TAG", "PLAY QUIZ LICKED: ");

            Intent intent = new Intent(home.this,quiz_cetagory.class);
            startActivity(intent);

        });


        activityHomeBinding.myProfile.setOnClickListener(view -> {
            Log.d("TAG", "PLAY QUIZ LICKED: ");

            Intent intent = new Intent(home.this,my_profile.class);
            startActivity(intent);

        });


        activityHomeBinding.dashboard.setOnClickListener(view -> {
            Log.d("TAG", "PLAY QUIZ LICKED: ");

            Intent intent = new Intent(home.this,dashboard.class);
            startActivity(intent);

        });


        activityHomeBinding.webview.setOnClickListener(view -> {
            Log.d("TAG", "PLAY QUIZ LICKED: ");

            Intent intent = new Intent(home.this,Web_view.class);
            startActivity(intent);

        });


activityHomeBinding.competetion.setOnClickListener(view -> {
            Log.d("TAG", "PLAY QUIZ LICKED: ");

            Intent intent = new Intent(home.this,Ranking_recycleView.class);
            startActivity(intent);

        });













    }

    //top corner option menu...................................


    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {



        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.top_corner_menu , menu);
        return super.onCreateOptionsMenu(menu);
    }
}