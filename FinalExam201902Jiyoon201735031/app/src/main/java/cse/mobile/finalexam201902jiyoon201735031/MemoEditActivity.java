package cse.mobile.finalexam201902jiyoon201735031;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MemoEditActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memoedit);

        final EditText etMemo = findViewById(R.id.etMemo);
        if (getIntent().getStringExtra("memo") != null) {
            etMemo.setText(getIntent().getStringExtra("memo"));
        }
        Button btEdit = findViewById(R.id.btEdit);
        btEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sIntent = new Intent();
                sIntent.putExtra("etMemo", etMemo.getText().toString());
                setResult(RESULT_OK, sIntent);
                finish();
            }
        });

        Button btCancel = findViewById(R.id.btCancel);
        btCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sIntent = new Intent();
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
