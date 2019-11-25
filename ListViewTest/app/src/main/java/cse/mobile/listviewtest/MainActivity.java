package cse.mobile.listviewtest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String[] FRUITS = {"Apple", "Banana", "Cherry", "Durian"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvFruits = findViewById(R.id.lvFruits);

//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, FRUITS);
//        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fruits_res, android.R.layout.simple_list_item_1);
//        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.fruits_res, R.layout.mytextview);
//        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mylayout, FRUITS);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.mylayout, R.id.tvFruits, FRUITS);

        lvFruits.setAdapter(adapter);

        lvFruits.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(), ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), FRUITS[position], Toast.LENGTH_SHORT).show();
//                Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();

//                String[] resFruits = getResources().getStringArray(R.array.fruits_res);
//                Toast.makeText(getApplicationContext(), resFruits[position], Toast.LENGTH_SHORT).show();

//                Toast.makeText(getApplicationContext(), adapter.getItem(position), Toast.LENGTH_SHORT).show();

                TextView tvFruits = view.findViewById(R.id.tvFruits);
                Toast.makeText(getApplicationContext(), tvFruits.getText(), Toast.LENGTH_SHORT).show();
            }
        });


    }
}
