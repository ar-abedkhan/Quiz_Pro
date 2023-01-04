package com.abedkhan.quizpro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.abedkhan.quizpro.databinding.ActivityDashboardBinding;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class dashboard extends AppCompatActivity {
ActivityDashboardBinding activityDashboardBinding;
TextView rightans,wrongans,userlevel,progressscore;
int user_level,userrightans,userscore,userwrongans,totalquestion;

TextView score;
CircularProgressBar circularProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding=ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());
            Intent intent=getIntent();






        userlevel=findViewById(R.id.userlevel);
        score=findViewById(R.id.score);
        rightans=findViewById(R.id.rightans);
        wrongans=findViewById(R.id.wrongans);
        circularProgressBar=findViewById(R.id.circularProgressBar);
        progressscore=findViewById(R.id.progressscore);



//tool bar set................
        Toolbar toolbar =findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);


//nev set................................
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                dashboard.this,
                activityDashboardBinding.drawermenu,
                toolbar,
                R.string.open,
                R.string.close

        );activityDashboardBinding.drawermenu.addDrawerListener(toggle);
        toggle.syncState();


        SharedPreferences sharedPreferences=getSharedPreferences("MY_SP",MODE_PRIVATE);
        String sp_name=sharedPreferences.getString("name",getString(R.string.app_name));
        activityDashboardBinding.username.setText(sp_name);






//setting nevication menu in drawer and clickable
        activityDashboardBinding.navview.setNavigationItemSelectedListener(item -> {




            switch (item.getItemId()) {

                case R.id.hommenue:
                    Log.i("tag", "home menu: ");
                    Intent intenthome = new Intent(dashboard.this, home.class);
                    startActivity(intenthome);
                    break;
                case R.id.profilemenu:
                    Intent intentprofile = new Intent(dashboard.this, my_profile.class);
                    startActivity(intentprofile);
                    break;
                case R.id.dashboardmenu:
                    Intent intentdashboard = new Intent(dashboard.this, dashboard.class);
                    startActivity(intentdashboard);
                    break;
                case R.id.categorymenu:
                    Intent intentcetagory = new Intent(dashboard.this, quiz_cetagory.class);
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
                    Intent logeoutintent = new Intent(dashboard.this, Logein.class);
                    startActivity(logeoutintent);
                    break;
                default:
                    Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();

            }

            return true;

        });



//intent data from quiz it
        userrightans=intent.getIntExtra("rightans",0);
                       rightans.setText(""+userrightans);
        userwrongans=intent.getIntExtra("wrongans",0);
                       wrongans.setText(""+userwrongans);
        userscore=intent.getIntExtra("score",0);
                       score.setText(""+userscore);
        totalquestion=intent.getIntExtra("totalquestion",0);

//level set..................




circularProgressBar.setProgress(userrightans);
progressscore.setText(userrightans+"/"+totalquestion);




//level.........................



     setuserlevel();

    }

    private void setuserlevel() {

        if (userscore==50){
            userlevel.setText("LEVEL : PRO");
        }else if (userscore<=40) {
            userlevel.setText("LEVEL : 3");
        }else if (userscore<=30) {
            userlevel.setText("LEVEL : 2");
        }else if (userscore>=25){
            userlevel.setText("LEVEL : 1");
        }else {
            userlevel.setText("NOOB");
        }

    }
}