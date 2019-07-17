package com.example.myandroidproject;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    Button thumbupButton;
    Button thumbdownButton;
    TextView test;
    View view1;
    ListView listView;
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
            public boolean onTouch(View view, MotionEvent motionEvent) {//onCreate부분이 길어지기 때문에 메소드로 따로 빼서 구현하는 것을 추천한다.

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

        //SingerAdapter를 ListView에 set시켜 연결시킨 후 onCreate()에 추가하여 생성한 view를 연결시켜준다.
        SingerAdapter singerAdapter = new SingerAdapter();
        //adapter에 item을 직접 추가한다.
        singerAdapter.addItem(new SingerItem("프로미스나인", "010-0000-0000"));
        singerAdapter.addItem(new SingerItem("에이프릴", "010-1111-1111"));
        singerAdapter.addItem(new SingerItem("러블리즈", "010-2222-2222"));
        singerAdapter.addItem(new SingerItem("주은", "010-3333-3333"));

        listView.setAdapter(singerAdapter);

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

    //ListView를 사용하기 위해 adapter pattern을 이용한다. ListView는 xml파일로 껍데기만 만들고 동작하는 코드는 java로 구현한다.
    //adapter pattern에는 list형의 클래스의 size, 포함하는 object, id, view를 return하는 method를 무조건적으로 작성해야 한다.
    class SingerAdapter extends BaseAdapter{

        ArrayList<SingerItem> singerItems = new ArrayList<SingerItem>();
        @Override
        public int getCount() {
            return singerItems.size();
        }

        @Override
        public Object getItem(int position) {
            return singerItems.get(position);
        }

        @Override
        public long getItemId(int id) {
            return id;
        }

        public void addItem(SingerItem singerItem){
            singerItems.add(singerItem);
        }

        //작성한 SingerItemView의 method를 이용하여 view를 set하고 return하여 화면에 보여주도록 한다.
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {

            SingerItemView singerItemView = new SingerItemView(getApplicationContext());//view는 기본적으로 context parameter를 가진다.

            SingerItem singerItem = singerItems.get(position);
            singerItemView.setName(singerItem.getName());
            singerItemView.setMobile(singerItem.getMobile());

            return singerItemView;
        }
    }

}

