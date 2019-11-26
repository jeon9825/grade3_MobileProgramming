package com.skhu.cse.listviewactionmodetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
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
    ActionMode mActionMode = null;

    ActionMode.Callback actionModeCallback = new ActionMode.Callback() {

        // Called when the action mode is created; startActionMode() was called
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            // Inflate a menu resource providing context menu items
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.cmenu_activity_main_lvitems, menu);
            return true;
        }

        // Called each time the action mode is shown. Always called after onCreateActionMode, but
        // may be called multiple times if the mode is invalidated.
        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false; // Return false if nothing is done
        }

        // Called when the user selects a contextual menu item
        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
//            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

            switch (item.getItemId()) {
                case R.id.cmenuDelete:
                    mALItems.remove(mAdapter.getCount());
                    mAdapter.notifyDataSetChanged();
                    mode.finish();
                    return true;
                default:
                    return false;
            }
        }

        // Called when the user exits the action mode
        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


/*        final ArrayList<String> alItems = new ArrayList<String>();
        ListView lvItems = findViewById(R.id.lvItems);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, alItems);  */

        mALItems = new ArrayList<String>();
        final ListView lvItems = findViewById(R.id.lvItems);
        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, mALItems);

        lvItems.setAdapter(mAdapter);

        lvItems.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(mActionMode != null) {
                    return false;
                }

//                mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
                mActionMode = MainActivity.this.startActionMode(actionModeCallback);
                view.setSelected(true);
                return true;
            }
        });

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
        lvItems.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        lvItems.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int position, long id, boolean checked) {
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                actionMode.getMenuInflater().inflate(R.menu.cmenu_activity_main_lvitems,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.cmenuDelete:
                        SparseBooleanArray checkitem = lvItems.getCheckedItemPositions();   //체크된 position값을 boolean으로 맵핑
                        for(int i=mALItems.size()-1; i>=0; i--)     //앞부터 제거시 index위치 변경된다
                        {
                            if(checkitem.get(i))                //해당위치 check상태 가져옴
                                mALItems.remove(i);
                        }
                        lvItems.clearChoices();             //선택상태 초기화
                        mAdapter.notifyDataSetChanged();    //갱신

                        actionMode.finish();        //액션모드 종료
                        mActionMode =null;
                        return true;

                    default:
                        return false;
                }
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                mActionMode = null;
            }
        });
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
//        lvItems.setOnLongClickListener(new View.OnLongClickListener() {
//            // Called when the user long-clicks on someView
//            public boolean onLongClick(View view) {
//                if (actionMode != null) {
//                    return false;
//                }
//                Toast.makeText(getApplicationContext(), "jiyoon", Toast.LENGTH_SHORT).show();
//                // Start the CAB using the ActionMode.Callback defined above
//                actionMode = startActionMode(actionModeCallback);
//                view.setSelected(true);
//                return true;
//            }
//        });
//  }
}
