package com.abedkhan.quizpro;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Web_view extends AppCompatActivity {

    WebView web_view;
    ProgressBar progressBar;
    final String url ="https://www.deshbangla71.news/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        progressBar=findViewById(R.id.progressbar);
        web_view=findViewById(R.id.webview);

       web_view.loadUrl(url);
       web_view.getSettings().setJavaScriptEnabled(true);



    }
}