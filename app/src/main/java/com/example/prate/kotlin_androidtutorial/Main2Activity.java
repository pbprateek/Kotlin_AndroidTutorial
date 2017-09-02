package com.example.prate.kotlin_androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView textView=(TextView) findViewById(R.id.some);
       Intent i =getIntent();
        Bundle b=i.getExtras();

        if(i!=null){
           String j =(String) b.get("key");
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                textView.setText(Html.fromHtml(j,Html.FROM_HTML_SEPARATOR_LINE_BREAK_HEADING));
            } else {
                textView.setText(Html.fromHtml(j));
            }

        }



    }
}
