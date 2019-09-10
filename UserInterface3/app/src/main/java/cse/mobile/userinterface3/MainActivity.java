package cse.mobile.userinterface3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.button1);
        button1.setText("First Button: modified in code");
        button1.setVisibility(View.INVISIBLE);
        Button button2 = findViewById(R.id.button2);
        button2.setEnabled(false); //Disabled
    }
}
