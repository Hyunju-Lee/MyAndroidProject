package com.example.myandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button thumbupButton;
    Button thumbdownButton;
    TextView test;
    View view1;
    int switchFrame = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView1 = (TextView) findViewById(R.id.bluecolor);
        textView2 = (TextView) findViewById(R.id.greencolor);
        thumbupButton = (Button) findViewById(R.id.thumbup);
        thumbdownButton = (Button) findViewById(R.id.thumbdown);
        test = (TextView) findViewById(R.id.test);
        view1 = (View) findViewById(R.id.view1);

        view1.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                int action = motionEvent.getAction();

                float curX = motionEvent.getX();
                float curY = motionEvent.getY();

                if (action == MotionEvent.ACTION_DOWN) {
                    println("손가락 눌림 : " + curX + ", " + curY);
                } /*else if (action == MotionEvent.ACTION_MOVE) {
                    println("손가락 움직임 : " + curX + ", " + curY);
                }*/ else if (action == MotionEvent.ACTION_UP) {
                    println("손가락 뗌 : " + curX + ", " + curY);
                    view.performClick();
                }

                return true;
            }
        });
    }

    public void println(String str){
        test.append(str);
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

    public void onThumbupButtonClicked(View v){

    }

    public void onThumbdownButtonClicked(View v){

    }

}

