package cse.mobile.myviewtest;
/*
https://developer.android.com/guide/topics/ui/custom-components#modifying
 */

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

class MyView extends View {
Paint paint = new Paint();
    int x, y;

    public MyView(Context context) {
        super(context);
        paint.setTextSize(20);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint.setTextSize(20);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint.setTextSize(20);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=(int) event.getX();
        y=(int) event.getY();
        invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(x,y,6,paint);
        canvas.drawText("("+x+", "+y+") 에서 터치 이벤트가 발생하였음",x,y+20,paint);
    }
}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        MyView myView = new MyView(this);
//        setContentView(myView);
    }
}
