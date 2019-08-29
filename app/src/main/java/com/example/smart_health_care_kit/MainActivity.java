package com.example.smart_health_care_kit;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView marq1;
    Button chkp,mediinfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        marq1 = (TextView)findViewById(R.id.marq1);
        marq1.setSelected(true);
        chkp=(Button)findViewById(R.id.chkp);
        mediinfo=(Button)findViewById(R.id.mediinfo);

        chkp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });

        mediinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
