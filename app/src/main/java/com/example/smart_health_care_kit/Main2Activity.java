package com.example.smart_health_care_kit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;
    private TextToSpeech myTTS;
    AutoCompleteTextView searchbtn;
    ImageButton dissearch;
    //Toolbar cal;

    //ImageView searimid;
    //TextView tv1;
    String [] inputs ={ "Diabetes","BP","Fever","Cold","Throat pain","Headache","Mouth ulcer","Migraine"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        //searimid = (ImageView)findViewById(R.id.searimid);






//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.search_btn);
//        RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(getResources(),bitmap);
//        roundedBitmapDrawable.setCircular(true);
//        searimid.setImageDrawable(roundedBitmapDrawable);

        //tv1 = (TextView)findViewById(R.id.tv1);


        dissearch = (ImageButton) findViewById(R.id.dissearch);
//      searimid = (ImageView)findViewById(R.id.searimid);
        searchbtn = (AutoCompleteTextView)findViewById(R.id.searchbtn);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,inputs);
        searchbtn.setAdapter(adapter);

        dissearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });




//        searchbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
//                startActivity(intent);
//            }
//        });
    }


    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Hello Sir, How can I Help");

        try {
            startActivityForResult(intent,REQUEST_CODE_SPEECH_INPUT);
        }
        catch (Exception e)
        {
            Toast.makeText(this,""+e.getMessage(),Toast.LENGTH_SHORT).show();;
        }
    }

    public void nextpage(View view)
    {
//        Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
//        startActivityForResult(intent,5);
        String dname = searchbtn.getText().toString();
        if (dname.length()==0)
        {
            searchbtn.setError("You must select the disease name");
        }
        else
        {
            Intent returnintent = new Intent(Main2Activity.this,Main3Activity.class);
            returnintent.putExtra("result",dname);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode)
        {
            case REQUEST_CODE_SPEECH_INPUT:
                if (resultCode == RESULT_OK && null!=data)
                {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    searchbtn.setText(result.get(0));
                }
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
//        if (id==R.id.cal)
//        {
//            Intent intent = new Intent(Intent.ACTION_DIAL);
//            intent.setData(Uri.parse("tel:7204958072"));
//            startActivity(intent);
//            //Toast.makeText(this,"Item4",Toast.LENGTH_SHORT).show();
//        }

        if (id==R.id.cal)
        {
//            Intent intent = new Intent(Intent.ACTION_DIAL);
//            intent.setData(Uri.parse("tel:7204958072"));
//            startActivity(intent);
            //Toast.makeText(this,"Item4",Toast.LENGTH_SHORT).show();
            makePhoneCall1();



//            if (id == R.id.doccl1)
//            {
//                makePhoneCall1();
//            }
//
//            if (id == R.id.doccl2)
//            {
//                makePhoneCall2();
//            }
//
//            return super.onOptionsItemSelected(item);




//            switch (item.getItemId())
//            {
//                case R.id.doccl1:
//                    makePhoneCall1();
//                    return true;
//
//                case R.id.doccl2:
//                    makePhoneCall2();
//                    return true;
//            }
        }

        if (id==R.id.sympt)
        {
            Intent intent = new Intent(Main2Activity.this,Main6Activity.class);
            startActivity(intent);
        }

//        if (id == R.id.camdoc)
//        {
//            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//            startActivityForResult(intent,0);
//        }


//        if (id == R.id.vidcal)
//        {
//
//        }
        return super.onOptionsItemSelected(item);
    }



    private void makePhoneCall1()
    {
//        String number = mEditTextNumber.getText().toString();
//        if (number.trim().length()>0)
//        {
        if (ContextCompat.checkSelfPermission(Main2Activity.this,
                Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Main2Activity.this,
                    new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else
        {
//                String dial = "tel:"+number;
            String dial = "tel:7204958072";
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
//        }
    }



    private void makePhoneCall2()
    {
//        String number = mEditTextNumber.getText().toString();
//        if (number.trim().length()>0)
//        {
        if (ContextCompat.checkSelfPermission(Main2Activity.this,
                Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Main2Activity.this,
                    new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
        }
        else
        {
//                String dial = "tel:"+number;
            String dial = "tel:9481506049";
            startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
        }
//        }
//        else
//        {
//            Toast.makeText(MainActivity.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
//        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL)
        {
            if (grantResults.length > 0 && grantResults[0] ==PackageManager.PERMISSION_GRANTED)
            {
                makePhoneCall1();
            }
            else
            {
                Toast.makeText(this,"Permission DENIED",Toast.LENGTH_SHORT).show();
            }
        }
    }
}

