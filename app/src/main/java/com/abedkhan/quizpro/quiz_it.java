package com.abedkhan.quizpro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.abedkhan.quizpro.databinding.ActivityQuizItBinding;

import java.util.ArrayList;
import java.util.List;

public class quiz_it extends AppCompatActivity {
    ActivityQuizItBinding activityQuizItBinding;

    CountDownTimer countDownTimer;
    int timelimit = 10;
    int count= 2000;
    TextView question, scoretv;
    List<quiz_class> qustionlists;
    int currentindex = 0, score = 0, totalquestion=0, questionno = 1;
    String userselectedans;
Boolean isoptionselected=false;
     int rightans=0;
    int wrongans = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityQuizItBinding = ActivityQuizItBinding.inflate(getLayoutInflater());
        setContentView(activityQuizItBinding.getRoot());


//timer  .........................................




        qustionlists = new ArrayList<>();


        qustionlists.add( new quiz_class("Whta is the language of andriod devolopment?","C++","JS","PYTHON","JAVA","JAVA"));

        qustionlists.add(new quiz_class("What is the platform for andriod app devolopment?","Neatbeans","Intellij","Andriod Stiduo","Pycham","Andriod Stiduo"));

        qustionlists.add(new quiz_class("Android is -","an operating system","a web browser","a web server","None of the above","an operating system"));

        qustionlists.add(new quiz_class("APK stands for -","Android Package Kit","Android Phone Kit","Android Page Kit","None of the above","Android Package Kit"));

        qustionlists.add(new quiz_class("What does API stand for?","Application Page Interface","Android Page Interface","Android Programming Interface","Application Programming Interface","Application Programming Interface"));

        qustionlists.add(new quiz_class("What is an activity in android?","None of the above","android package","android class","A single screen in an application with supporting java code","A single screen in an application with supporting java code"));

        qustionlists.add(new quiz_class("How can we kill an activity in android?","Using finish() method","Using finishActivity(int requestCode)","Both 1 & 2","Others","Both 1 & 2"));

        qustionlists.add(new quiz_class("ADB stands for -","None of the above","Android destroy bridge","Android debug bridge","Android delete bridge","Android debug bridge"));

        qustionlists.add(new quiz_class("Which of the following kernel is used in Android?","MAC","Linux","Redhat","Windows","Linux"));

        qustionlists.add(new quiz_class("Does android support other languages than java?","Yes","No","Maybe","Can't say","Yes"));


        setQuestuin(currentindex);


        SharedPreferences sharedPreferences=getSharedPreferences("MY_SP",MODE_PRIVATE);
        String sp_name=sharedPreferences.getString("name",getString(R.string.app_name));
        activityQuizItBinding.username.setText(sp_name);







        activityQuizItBinding.gendergroup.setOnCheckedChangeListener((radioGroup, i) -> {

            totalquestion=qustionlists.size();
//            texttimer=findViewById(R.id.textTimer);

            RadioButton selectedoption =findViewById(i);
            userselectedans =selectedoption.getText().toString();
        isoptionselected=true;
            Log.i("TAG", "option selected: " +userselectedans);

        });


        activityQuizItBinding.submitans.setOnClickListener(view -> {
            checkRightAns();
            if (isoptionselected=false){

            }else {
                return;
            }

        });
        







    }

//    private void timer() {
//        countDownTimer = new CountDownTimer(10000,1000) {
//            @Override
//            public void onTick(long l) {
//                activityQuizItBinding.playQuizTimer.setText("00:"+timelimit);
//                timelimit--;
//            }
//
//            @Override
//            public void onFinish() {
//
//
//                finishtimer();
////                    currentindex++;
////                setQuestuin(currentindex);
//
////
//            }
//
//            private void finishtimer() {
//
//                countDownTimer.cancel();
//                activityQuizItBinding.questiontv.setClickable(false);
//                activityQuizItBinding.option1.setClickable(false);
//                activityQuizItBinding.option2.setClickable(false);
//                activityQuizItBinding.option3.setClickable(false);
//                activityQuizItBinding.option4.setClickable(false);
//
//          setQuestuin(currentindex);
////                Intent splashintent=new Intent(quiz_it.this,dashboard.class);
////                startActivity(splashintent);
//            }
//        }.start();
//    }
//


    private void checkRightAns() {
        if (qustionlists.get(currentindex).getCurrectans().equals(userselectedans)){
            score = score+5;
            rightans++;
            questionno++;
            currentindex++;
            setQuestuin(currentindex);
            Toast.makeText(this, "Right ans.CONGRATULATION!You won 5 point", Toast.LENGTH_SHORT).show();

        }else {
            score =score-5;
            currentindex++;
            questionno++;
            wrongans++;
            setQuestuin(currentindex);
            Log.i("TAG", "wrong ans: ");
            Toast.makeText(this, "Wrong ans.You lose 5 point.", Toast.LENGTH_SHORT).show();

        }

    }






    private void setQuestuin(int currentindex) {


        if (currentindex==qustionlists.size()){
            finishQuiz();
            return;

        }
//            timer();


        activityQuizItBinding.scoretv.setText("SCORE:"+score);
        activityQuizItBinding.questionNo.setText("Question No:"+currentindex+"/"+totalquestion);
//        activityQuizItBinding.rightAns.setText("Right Ans :"+ rightans+"/"+totalquestion);
//        activityQuizItBinding.wrongAns.setText("Wrong Ans :"+wrongans+"/"+totalQuestion);


        activityQuizItBinding.questiontv.setText(qustionlists.get(currentindex).getQuestion());
        activityQuizItBinding.option1.setText(qustionlists.get(currentindex).getOption1());
        activityQuizItBinding.option2.setText(qustionlists.get(currentindex).getOption2());
        activityQuizItBinding.option3.setText(qustionlists.get(currentindex).getOption3());
        activityQuizItBinding.option4.setText(qustionlists.get(currentindex).getOption4());

        activityQuizItBinding.option1.setChecked(false);
        activityQuizItBinding.option2.setChecked(false);
        activityQuizItBinding.option3.setChecked(false);
        activityQuizItBinding.option4.setChecked(false);

    }
    private void finishQuiz() {

        Intent intent =new Intent(this,dashboard.class);
        intent.putExtra("rightans",rightans);
        intent.putExtra("wrongans",wrongans);
        intent.putExtra("score",score);
        intent.putExtra("totalquestion",totalquestion);
        startActivity(intent);



    }




}