package com.example.myandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    int switchFrame = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.bluecolor);
        textView2 = (TextView) findViewById(R.id.greencolor);
    }

    public void onButton1Clicked(View v){
        if(switchFrame == 0){
            textView1.setVisibility(View.VISIBLE);
            textView2.setVisibility(View.INVISIBLE);
            switchFrame = 1;
        }else{
            textView1.setVisibility(View.INVISIBLE);
            textView2.setVisibility(View.VISIBLE);
            switchFrame = 0;
        }
    }
}

