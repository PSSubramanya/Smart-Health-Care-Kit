package com.example.smart_health_care_kit;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;

public class Main4Activity extends AppCompatActivity {
    ImageView signimg1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        signimg1 = (ImageView)findViewById(R.id.signimg1);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.signin);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        signimg1.setImageDrawable(roundedBitmapDrawable);
    }
}

