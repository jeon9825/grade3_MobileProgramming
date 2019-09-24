package cse.mobile.checkboxtest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox cbMeat = findViewById(R.id.main_cbMeat);
        CheckBox cbCheese = findViewById(R.id.main_cbCheese);

//        cbMeat.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                boolean checked = ((CheckBox)view).isChecked();
//
//                if(checked) {
//                    Toast.makeText(getApplicationContext(),"Meat Checked", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getApplicationContext(),"Meat Unchecked", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        cbCheese.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//                boolean checked = ((CheckBox)view).isChecked();
//
//                if(checked) {
//                    Toast.makeText(getApplicationContext(),"Cheese Checked", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getApplicationContext(),"Cheese Unchecked", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        cbMeat.setOnClickListener(mCBClickListener);
        cbCheese.setOnClickListener(mCBClickListener);
    }

    View.OnClickListener mCBClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            boolean checked = ((CheckBox) view).isChecked();
            switch (view.getId()) {
                case R.id.main_cbMeat:
                    if (checked) {
                        Toast.makeText(getApplicationContext(), "Meat Checked", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Meat Unchecked", Toast.LENGTH_SHORT).show();
                    }
                    break;
                case R.id.main_cbCheese:
                    if (checked) {
                        Toast.makeText(getApplicationContext(), "Cheese Checked", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Cheese Unchecked", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    };
}

