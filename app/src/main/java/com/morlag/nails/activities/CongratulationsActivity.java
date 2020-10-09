package com.morlag.nails.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.morlag.nails.R;

public class CongratulationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_congratulations);

        Intent i = getIntent();
        ((EditText)findViewById(R.id.txt_name)).setText(i.getStringExtra("name"));
        String date = i.getStringExtra("datetime");
        String[] dateSplitted = date.split(" ");
        ((EditText)findViewById(R.id.txt_date)).setText(dateSplitted[0]);
        ((EditText)findViewById(R.id.txt_time)).setText(dateSplitted[1]);
        ((TextView)findViewById(R.id.txt_services)).setText(i.getStringExtra("service"));
        ((EditText)findViewById(R.id.txt_comment)).setText(i.getStringExtra("comment"));

        Button end = findViewById(R.id.btn_end);
        end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("confirmed","t");
                setResult(Activity.RESULT_OK,intent);
                finish();
            }
        });

    }
}