package cse.mobile.customtoasttest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btOK = findViewById(R.id.btOK);
        btOK.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                LinearLayout rootView = (LinearLayout) View.inflate(getApplicationContext(),R.layout.mytoast,null);
                TextView tvMessage = rootView.findViewById(R.id.tvMessage);
                tvMessage.setText("Button clicked");

                Toast toast = new Toast(getApplicationContext());
                toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.setView(rootView);
                toast.show();
            }
        });
    }
}
