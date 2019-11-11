package cse.mobile.dialogtest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btDialog = findViewById(R.id.btDialog);
        btDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* 첫번째 방법
                AlertDialog.Builder adBuilder = new AlertDialog.Builder(MainActivity.this); //getApplicationContext()로 안됨
                adBuilder.setTitle("NOTICE");
                adBuilder.setMessage("결제하쉴?");
                adBuilder.setIcon(R.mipmap.ic_launcher);
                adBuilder.setPositiveButton("웅!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"결제완료쑤~",Toast.LENGTH_SHORT).show();
                    }
                });
                adBuilder.show();
                 */

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("JIYOON")
                        .setIcon(R.mipmap.ic_launcher)
                        .setMessage("I Love you")
                        .setPositiveButton("웅!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getApplicationContext(), "결제완료쑤~", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setCancelable(false)
                        .show();
            }
        });

        Button btNotice = findViewById(R.id.btNoticeDialog);
        btNotice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dfNotice = new NoticeDialogFragment();
                dfNotice.setCancelable(false);
                dfNotice.show(getSupportFragmentManager(), "dfNotice");

            }
        });

        Button btList = findViewById(R.id.btListDialog);
        btList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dfList = new ListDialogFragment();
                dfList.setCancelable(false);
                dfList.show(getSupportFragmentManager(), "dfList");

            }
        });
    }

    public static class NoticeDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
            adBuilder.setTitle("JIYOON")
                    .setIcon(R.mipmap.ic_launcher)
                    .setMessage("I Love you")
                    .setPositiveButton("웅!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    })
                    .setCancelable(false);
            return adBuilder.create();
        }
    }

    public static class ListDialogFragment extends DialogFragment {
        @NonNull
        @Override
        public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
            final CharSequence[] items = {"Red", "Green", "Blue"};
            final boolean[] checkedItems = {true, false, true}; //items의 개수와 같아야함. //초기값

            AlertDialog.Builder adBuilder = new AlertDialog.Builder(getActivity());
            adBuilder.setTitle("색깔골라보슈~")
                    /*
                    .setItems(items, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            Toast.makeText(getActivity(),items[which], Toast.LENGTH_SHORT).show();
                        }
                    })
                     */
                    /*
                    .setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() { //누를 때 다이어로그가 안없어진다. close를 해줘야 없어짐.
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which) {
                            Toast.makeText(getActivity(),items[which], Toast.LENGTH_SHORT).show();
                        }
                    })
                     */
                    .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                            String str = (isChecked) ? " Checked" : " Unchecked";
                            Toast.makeText(getActivity(), items[which] + str, Toast.LENGTH_SHORT).show();
//                            checkedItems[which] = isChecked;
                        }
                    })
                    .setPositiveButton("Close", null)
                    .setCancelable(false);
            return adBuilder.create();
        }
    }
}
