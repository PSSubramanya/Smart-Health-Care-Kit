package com.example.smart_health_care_kit;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

public class Main5Activity extends AppCompatActivity {
    Button logins1,sign1;
    EditText pass1;
    TextView marklog1;
    ImageView signimg2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        logins1= (Button)findViewById(R.id.logins1);
        sign1 = (Button)findViewById(R.id.sign1);
        pass1 = (EditText)findViewById(R.id.pass1);
        marklog1 = (TextView)findViewById(R.id.marklog1);
        marklog1.setSelected(true);

        logins1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        sign1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main5Activity.this,Main4Activity.class);
                startActivity(intent);
            }
        });

        signimg2 = (ImageView)findViewById(R.id.signimg2);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.docb);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        signimg2.setImageDrawable(roundedBitmapDrawable);
    }
}
