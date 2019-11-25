package cse.mobile.lisviewupdatetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> mALItems;
    ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        final ArrayList<String> alItems = new ArrayList<String>();
        ListView lvItems = findViewById(R.id.lvItems);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alItems);  */

        mALItems = new ArrayList<String>();
        ListView lvItems = findViewById(R.id.lvItems);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mALItems);

        lvItems.setAdapter(mAdapter);

        final EditText etAdd = findViewById(R.id.etAdd);
        Button btAdd = findViewById(R.id.btAdd);
        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mALItems.add(etAdd.getText().toString());
                etAdd.setText("");
                mAdapter.notifyDataSetChanged();

            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });

        registerForContextMenu(lvItems);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cmenu_activity_main__lvitems, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();

        switch(item.getItemId()) {
            case R.id.cmenuDelete:
                mALItems.remove(info.position);
                mAdapter.notifyDataSetChanged();
                return true;
            default:
                return false;
        }
    }

}
