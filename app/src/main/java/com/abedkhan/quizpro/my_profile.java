package com.abedkhan.quizpro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.abedkhan.quizpro.databinding.ActivityMyProfileBinding;

public class my_profile extends AppCompatActivity {
ActivityMyProfileBinding activityMyProfileBinding;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMyProfileBinding= ActivityMyProfileBinding.inflate(getLayoutInflater());
        setContentView(activityMyProfileBinding.getRoot());

String username,usermail,usergender,userpass,userprofession,usercountry,tramsandcondition;




        activityMyProfileBinding.name.findViewById(R.id.name);
        activityMyProfileBinding.mail.findViewById(R.id.mail);
        activityMyProfileBinding.pass.findViewById(R.id.pass);
        activityMyProfileBinding.profession.findViewById(R.id.profession);
        activityMyProfileBinding.gender.findViewById(R.id.gender);
        activityMyProfileBinding.tramscondition.findViewById(R.id.tramscondition);
        activityMyProfileBinding.country.findViewById(R.id.country);


        Intent intent = getIntent();



username =intent.getStringExtra("name");
        activityMyProfileBinding.name.setText(username);

usermail =intent.getStringExtra("mail");
        activityMyProfileBinding.mail.setText(usermail);

userpass =intent.getStringExtra("pass");
        activityMyProfileBinding.pass.setText(userpass);

userprofession =intent.getStringExtra("profession");
        activityMyProfileBinding.profession.setText(userprofession);

usercountry =intent.getStringExtra("country");
        activityMyProfileBinding.country.setText(usercountry);

usergender =intent.getStringExtra("gender");
        activityMyProfileBinding.gender.setText(usergender);

tramsandcondition =intent.getStringExtra("agreement");
        activityMyProfileBinding.tramscondition.setText(tramsandcondition);










        Toolbar toolbar =findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);


//nev set................................
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                my_profile.this,
                activityMyProfileBinding.drawermenu,
                toolbar,
                R.string.open,
                R.string.close
        );activityMyProfileBinding.drawermenu.addDrawerListener(toggle);
        toggle.syncState();






        activityMyProfileBinding.navview.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.hommenue:
                    Log.i("tag", "home menu: ");
                    Intent intenthome = new Intent(my_profile.this, home.class);
                    startActivity(intenthome);
                    break;
                case R.id.profilemenu:
                    Intent intentprofile = new Intent(my_profile.this, my_profile.class);
                    startActivity(intentprofile);
                    break;
                case R.id.dashboardmenu:
                    Intent intentdashboard = new Intent(my_profile.this, dashboard.class);
                    startActivity(intentdashboard);
                    break;
                case R.id.categorymenu:
                    Intent intentcetagory = new Intent(my_profile.this, quiz_cetagory.class);
                    startActivity(intentcetagory);
                    break;
                case R.id.settingsmenu:
                    Toast.makeText(this, "This Function is on devoloper mood!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.supportmenu:
                    Toast.makeText(this, "This Function is on devoloper mood!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.suggestionmenu:
                    Toast.makeText(this, "Sorry! This Function is on devoloper mood!", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.loge_outmenu:
                    Toast.makeText(this, "LOGGING OUT....", Toast.LENGTH_SHORT).show();
                    Intent logeoutintent = new Intent(my_profile.this, Logein.class);
                    startActivity(logeoutintent);
                    break;
                default:
                    Toast.makeText(this, "nothing", Toast.LENGTH_SHORT).show();

            }

            return true;

        });

        activityMyProfileBinding.editprofile.setOnClickListener(view -> {
            Intent intent1=new Intent(this,MainActivity.class);
            startActivity(intent1);
        });


        SharedPreferences sharedPreferences=getSharedPreferences("MY_SP",MODE_PRIVATE);
        String sp_name=sharedPreferences.getString("name",getString(R.string.app_name));
        activityMyProfileBinding.name.setText(sp_name);
        String mail=sharedPreferences.getString("mail",getString(R.string.app_name));
        activityMyProfileBinding.mail.setText(mail);
        String pass=sharedPreferences.getString("pass",getString(R.string.app_name));
        activityMyProfileBinding.pass.setText(pass);
        String country=sharedPreferences.getString("country",getString(R.string.app_name));
        activityMyProfileBinding.country.setText(country);
        String profession=sharedPreferences.getString("profession",getString(R.string.app_name));
        activityMyProfileBinding.profession.setText(profession);
        String gender=sharedPreferences.getString("gender",getString(R.string.app_name));
        activityMyProfileBinding.gender.setText(gender);
        String name=sharedPreferences.getString("name",getString(R.string.app_name));
        activityMyProfileBinding.userName.setText(name);




    }
}