package cse.mobile.buttoneventtest1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        /*
         * 첫번째 방법
        ButtonClickListener buttonClickListener = new ButtonClickListener();
        button.setOnClickListener(buttonClickListener);
         */
        button.setOnClickListener(mButtonClickListener);

    }

    class ButtonClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"버튼눌림",Toast.LENGTH_SHORT).show();
        }
    }

    View.OnClickListener mButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),"버튼눌림",Toast.LENGTH_SHORT).show();
        }
    };
}
