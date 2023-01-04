package com.abedkhan.quizpro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.abedkhan.quizpro.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
         ActivityMainBinding activityMainBinding;



         String usergender;
  Boolean isagreementchecked=false;
  Boolean isgenderchecked =false;
  String [] countrylist ={
          "America",
          "Australiya",
          "Africa",
          "Brazil",
          "Bangladesh",
          "congo",
          "Emirat",
          "Saoudi arab",
          "Afganisthan",
          "Sweeden",
          "Naizwriya",
          "Maldeep",
          "Itali",
          "Maleshaya"
  };

    String [] professionlist = {
            "Select your profession",
            "Doctor",
            "Engineer",
            "Farmer",
            "Student",
            "Teacher",
            "Businessman",
            "Army"           };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());


        ArrayAdapter<String> usercountry=new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                countrylist
        );
        activityMainBinding.autocompleateCountry.setAdapter(usercountry);





        ArrayAdapter<String> professionadapter=new ArrayAdapter<>(
                MainActivity.this,
                android.R.layout.simple_dropdown_item_1line,
                professionlist
        );
        activityMainBinding.spinnerProfession.setAdapter(professionadapter);

        activityMainBinding.spinnerProfession.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String   userprofession=professionlist[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });







              activityMainBinding.checkboxAgreement.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                      isagreementchecked=b;
                  }
              });




              activityMainBinding.gendergroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                  @Override
                  public void onCheckedChanged(RadioGroup radioGroup, int i) {
                      RadioButton radioButton=findViewById(i);
                      isgenderchecked=true;
                       usergender =radioButton.getText().toString();
                  }
              });













        activityMainBinding.registrationButton.setOnClickListener(view -> {
            Log.i("TAG", "registered: ");

            activityMainBinding.username.findViewById(R.id.username);
            activityMainBinding.usermail.findViewById(R.id.usermail);
            activityMainBinding.userpass.findViewById(R.id.userpass);
            activityMainBinding.gendergroup.findViewById(R.id.gendergroup);
            activityMainBinding.genderfemale.findViewById(R.id.genderfemale);
            activityMainBinding.gendermale.findViewById(R.id.gendermale);
            activityMainBinding.genderothers.findViewById(R.id.genderothers);
            activityMainBinding.checkboxAgreement.findViewById(R.id.checkbox_agreement);
            activityMainBinding.autocompleateCountry.findViewById(R.id.autocompleate_country);
            activityMainBinding.spinnerProfession.findViewById(R.id.spinner_profession);



            String name=activityMainBinding.username.getText().toString();
            String mail=activityMainBinding.usermail.getText().toString();
            String pass=activityMainBinding.userpass.getText().toString();
            String country=activityMainBinding.autocompleateCountry.getText().toString();
            String profession=activityMainBinding.spinnerProfession.getSelectedItem().toString();
            String agreement=activityMainBinding.checkboxAgreement.getText().toString();


                                 if (name.equals("")){
                                     activityMainBinding.username.setError("Enter your name");
                                     Log.i("TAG", "name: "+name);
                                 }else if (mail.equals("")){
                                     activityMainBinding.usermail.setError("Enter your mail");
                                     Log.i("TAG", "Mail: "+mail);
                                 }else if (pass.equals("")){
                                     activityMainBinding.userpass.setError("Enter your mail");
                                 }else  if (country.equals("")){
                                     activityMainBinding.autocompleateCountry.setError("select your country");
                                 }else if (isagreementchecked==false) {
                                     activityMainBinding.checkboxAgreement.setError("Check agreement");
                                 }else if (profession.equals("")){
                                     return;
                                 }else if (isgenderchecked==false) {
                                      return;
                                 }else {


                                     Intent intent = new Intent(MainActivity.this, home.class);
                                     startActivity(intent);

                                     intent.putExtra("name", name);
                                     intent.putExtra("mail", mail);
                                     intent.putExtra("pass", pass);
                                     intent.putExtra("profession", profession);
                                     intent.putExtra("country", country);
                                     intent.putExtra("gender", usergender);
                                     intent.putExtra("agreement", agreement);
         }

            //shear data to all over the project............................
            SharedPreferences sharedPreferences=getSharedPreferences("MY_SP",MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("name",name);
            editor.putString("mail",mail);
            editor.putString("pass",pass);
            editor.putString("profession",profession);
            editor.putString("country",country);
            editor.putString("gender",usergender);
            editor.apply();



        });
     }
}