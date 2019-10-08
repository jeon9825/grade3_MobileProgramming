package cse.mobile.inflationtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        TextView tvHello = new TextView(this);
        tvHello.setText("Hello, Android in Code");

//        Button btOK = new Button(this);
//        btOK.setText("OK in Code.");

//      위와 같은 코드임. 세가지 방법이 있음.
//        LayoutInflater inflater = getLayoutInflater();
//        LayoutInflater inflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        LayoutInflater inflater2 = LayoutInflater.from(this);
//
//        Button btMyButton = (Button) inflater.inflate(R.layout.mybutton, null);

        //위와 같은 코드임. 가장 많이 쓰는 방법
        Button btMyButton = (Button) View.inflate(this, R.layout.mybutton, null);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linearLayout.addView(tvHello, llParams);
//        linearLayout.addView(btOK,llParams);
//        linearLayout.addView(btMyButton); //addView의 default가 width=MATCH_PARENT, height=WRAP_CONTENT
        linearLayout.addView(btMyButton,llParams);

        setContentView(linearLayout);
    }
}
