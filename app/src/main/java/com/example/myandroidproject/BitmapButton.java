package com.example.myandroidproject;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.appcompat.widget.AppCompatButton;

//AppCompatButton을 superclass로 둔 bitmapbutton 클래스를 생성
//이 BitmapButton은 xml에서 view 자체로 쓰일 수 있다. <BitmapButton></BitmapButton>
//거기에 action을 넣은 구조라고 생각하면 된다.
public class BitmapButton extends AppCompatButton {

    public BitmapButton(Context context) {//context parameter로 super를 이용하여 superclass의 constructor를 충족시켜주도록 한다.
        super(context);

        init(context);//하위클래스인 BitmapButton은 init()으로 background image를 설정하도록 한다.
    }

    public BitmapButton(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context) {
        setBackgroundResource(R.drawable.ic_thumb_up);//이 메소드를 통해서 이미지를 지정한다.
        setTextSize(15);//자바코드에서 dp를 설정할 수 없기 때문에 dimen을 이용해서 dp단위의 크기를 지정하도록 해주어야 한다.
    }

    //onClickEvent와 onTouchEvent가 독립적으로 동작하도록 코딩을 해보는 것도 해보자.
    @Override
    public boolean onTouchEvent(MotionEvent event) {//역시 Override를 통해서 기존 CompatButton에서 TouchEvent()를 넣어주는(설정하는) 역할을 한다.
        int action = event.getAction();

        switch (action) {
            case MotionEvent.ACTION_DOWN:
                setBackgroundResource(R.drawable.ic_thumb_up);
                break;
            case MotionEvent.ACTION_UP:
                setBackgroundResource(R.drawable.ic_thumb_up_selected);
                break;
        }

        invalidate();//다시 이벤트가 발생해도 그래픽을 그릴 수 있도록 하는 메소드

        return true;
    }

}
