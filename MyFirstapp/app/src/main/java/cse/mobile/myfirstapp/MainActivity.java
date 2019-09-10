package cse.mobile.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        // Java 코드로 layout을 만드는 방법
        TextView tvHello = new TextView(this);
        tvHello.setText("안녕하세요, 안드로이드입니다.");
        setContentView(tvHello);


    }
}
