package com.example.smart_health_care_kit;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;


public class Main6Activity extends AppCompatActivity {
    ImageView symptimg;
    EditText sympttext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

//        symptimg = (ImageView)findViewById(R.id.synptimg);
        symptimg = (ImageView)findViewById(R.id.synptimg);
        sympttext = (EditText)findViewById(R.id.sympttext);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.ntpdb);
        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
        roundedBitmapDrawable.setCircular(true);
        symptimg.setImageDrawable(roundedBitmapDrawable);
    }

    public void symptnextpage(View view)
    {
//        Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
//        startActivityForResult(intent,5);
        String dname1 = sympttext.getText().toString();
        if (dname1.length()==0)
        {
            sympttext.setError("Enter the symptoms before sending");
        }
        else
        {
            Intent returnintent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7204958072"));
            //returnintent.putExtra("result",dname1);
            returnintent.putExtra("sms_body",dname1);
            //startActivity(intent);
            startActivity(returnintent);
//            if (dname == "Diabetes")
//            {
//                Intent returnintent = new Intent(Main3Activity.this,Main4Activity.class);
//                returnintent.putExtra("result",dname);
//                startActivity(returnintent);
//            }
//
//            if (dname == "BP")
//            {
//                Intent returnintent = new Intent(Main3Activity.this,Main5Activity.class);
//                returnintent.putExtra("result",dname);
//                startActivity(returnintent);
//            }
        }
    }

}
