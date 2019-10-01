package cse.mobile.togglebuttontest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ToggleButton tbDecision = findViewById(R.id.tbDecision);
        tbDecision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((ToggleButton) view).isChecked();

                if (checked) {
                    Toast.makeText(getApplicationContext(), "Yes decided", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "No decided", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Switch swWifi = findViewById(R.id.swWifi);
        swWifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getApplicationContext(), "Wifi On", Toast.LENGTH_SHORT).show();
                } else {

                    Toast.makeText(getApplicationContext(), "Wifi Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
