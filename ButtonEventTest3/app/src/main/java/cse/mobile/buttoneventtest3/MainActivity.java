package cse.mobile.buttoneventtest3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity //implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(this);
    }

//    @Override
//    public void onClick(View view) {
//        Toast.makeText(getApplicationContext(),"Button Clicked", Toast.LENGTH_SHORT).show();
//    }

    public void onButtonClick(View view){
        Toast.makeText(getApplicationContext(),"Button Clicked", Toast.LENGTH_SHORT).show();
    }
}
