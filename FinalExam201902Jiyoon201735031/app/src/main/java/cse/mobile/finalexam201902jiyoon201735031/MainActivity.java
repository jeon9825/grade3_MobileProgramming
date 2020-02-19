package cse.mobile.finalexam201902jiyoon201735031;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int num = 0;
    ArrayList<String> mALItems = new ArrayList<>();
    ArrayAdapter<String> mAdapter;
    ActionMode mActionMode = null;
    final int REQ_CODE_MEMO_EDIT = 0;
    boolean mRunning;
    String etMemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            num = savedInstanceState.getInt("num");
            mALItems = savedInstanceState.getStringArrayList("mALItems");
        }
        ListView lvMemo = findViewById(R.id.lvMemo);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mALItems);

        lvMemo.setAdapter(mAdapter);

        lvMemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent sIntent = new Intent(getApplicationContext(), MemoEditActivity.class);
                sIntent.putExtra("memo", mALItems.get(i));
                startActivityForResult(sIntent, REQ_CODE_MEMO_EDIT);
//                if(sIntent.getStringExtra("etMemo")!=null){
//                    mALItems.set(i,sIntent.getStringExtra("etMemo"));
//                    mAdapter.notifyDataSetChanged();
//                }
//                mALItems.remove(i);
//                mALItems.add(i,etMemo);
//                mAdapter.notifyDataSetChanged();
                //etMemo를 가져와서 원래 어레이리스트에 변경 후 mAdapter.notifyDataSetChanged() 코드가 있어야 함.
            }
        });
//        registerForContextMenu(lvMemo);

        lvMemo.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (mActionMode != null)
                    return false;
                mActionMode = MainActivity.this.startSupportActionMode(mActionModeCallback);
                view.setSelected(true);
                return true;
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
//        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        return super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menuNewMemo:
                mALItems.add("New Memo " + num++);
                mAdapter.notifyDataSetChanged();
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_MEMO_EDIT:
                if (resultCode == RESULT_OK) {
                    etMemo = data.getStringExtra("etMemo");
                }
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("num", num);
        outState.putStringArrayList("mALItems", mALItems);
    }

    ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            MenuInflater inflater = mode.getMenuInflater();
            inflater.inflate(R.menu.cmenu_main_lvmemo, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            switch (item.getItemId()) {
                case R.id.cmenuDeleteMemo:
                    mALItems.remove(info.position);
                    mAdapter.notifyDataSetChanged();

                    return true;

                case R.id.cmenuShareMemo:
                    ThCounter thCounter = new ThCounter();
                    mRunning = true;
                    thCounter.execute();
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            mActionMode = null;
        }
    };

    class ThCounter extends AsyncTask<Integer, Integer, Integer> {
        static final String TAG = "AsyncTask";
        TextView message;

        @Override
        protected Integer doInBackground(Integer... integers) {
            int i;
            for (i = 0; i < 100 && mRunning; i++) {
                Log.i(TAG, "[" + Thread.currentThread().getName() + "] count: " + i);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return i;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            ShareMemoDialogFragment shareMemoDialogFragment = new ShareMemoDialogFragment();
            shareMemoDialogFragment.setCancelable(false);
            shareMemoDialogFragment.show(getSupportFragmentManager(), "shareMemoDialogFragment");
            getSupportFragmentManager().executePendingTransactions();
            message = shareMemoDialogFragment.getDialog().findViewById(android.R.id.message);
            message = shareMemoDialogFragment.getDialog().findViewById(android.R.id.message);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Toast.makeText(getApplicationContext(), "Completed Sharing Memo.", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            message.setText("Sharing Memo:" + values[0]);
        }
    }

    class ShareMemoDialogFragment extends DialogFragment {
        int p = 0;

        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
            adBuilder.setTitle("Share Memo")
                    .setMessage("Sharing Memo " + p + "%")
                    .setCancelable(false);
            return adBuilder.create();
        }
    }
}
