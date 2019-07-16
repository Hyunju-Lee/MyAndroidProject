package com.example.myandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        //onClickListener는 Button, View모두로부터 접근이 가능하지만 onTouchListener는 View로만 접근이 가능하다.
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

    //토스트와 비슷하게 스낵바라는 기능도 있다. 또한 이것들은 xml로 구성할 수 없다??
    public void onThumbupButtonClicked(View v){//Toast를 띄우는 2가지 방법, 아래 방법은 view를 제대로 만들어야 정상 작동한다.
        Toast.makeText(getApplicationContext(), "따봉", Toast.LENGTH_LONG).show();
        /*Toast toast = new Toast(getApplicationContext()); //getApplicationContext()로 (아마?) 앱의 최상위 레이어에 toast를 띄우도록 한다.
        toast.setGravity(Gravity.CENTER, 200, 200);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(v);
        toast.show();*/

    }

    public void onThumbdownButtonClicked(View v){

    }

}

