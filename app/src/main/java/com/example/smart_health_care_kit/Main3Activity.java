package com.example.smart_health_care_kit;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {
    TextView dispview,prescp,cktxt1,cktxt2,cktxt3,cktxt4,cktxt5,diab;
    CheckBox ck1,ck2,ck3,ck4,ck5;
    EditText sug;
    Button checking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        dispview = (TextView)findViewById(R.id.dispview);
//        text2 = (TextView)findViewById(R.id.text2);
        prescp = (TextView)findViewById(R.id.prescp);
        ck1 = (CheckBox)findViewById(R.id.ck1);
        ck2 = (CheckBox)findViewById(R.id.ck2);
        ck3 = (CheckBox)findViewById(R.id.ck3);
        ck4 = (CheckBox)findViewById(R.id.ck4);
        ck5 = (CheckBox)findViewById(R.id.ck5);
        cktxt1 = (TextView)findViewById(R.id.cktxt1);
        cktxt2 = (TextView)findViewById(R.id.cktxt2);
        cktxt3 = (TextView)findViewById(R.id.cktxt3);
        cktxt4 = (TextView)findViewById(R.id.cktxt4);
        cktxt5 = (TextView)findViewById(R.id.cktxt5);
        sug = (EditText)findViewById(R.id.sug);
        checking = (Button)findViewById(R.id.checking);
        diab = (TextView) findViewById(R.id.diab);

        String name = getIntent().getStringExtra("result");
        dispview.setText("\t\t\t\t\t\t"+name);
        if (name.equals("Diabetes"))
        {
            ck3.setVisibility(View.INVISIBLE);
            cktxt3.setVisibility(View.INVISIBLE);
            ck4.setVisibility(View.INVISIBLE);
            cktxt4.setVisibility(View.INVISIBLE);
            ck5.setVisibility(View.INVISIBLE);
            cktxt5.setVisibility(View.INVISIBLE);
            checking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean check1 = ck1.isChecked();
                    boolean check2 = ck2.isChecked();
                    if (check1)
                    {
                        ck2.setVisibility(View.INVISIBLE);
                        cktxt2.setVisibility(View.INVISIBLE);

                        String sug1 = sug.getText().toString();
                        int valc = Integer.parseInt(sug1);
                        if (valc >100 && valc<=125)
                        {
                            prescp.setText("You are affected by Diabetes\n" +
                                    "Kazano\nOseni\nMetaglip\nGlucovance\nJentadueto\nDuetact\nActoplus\n");
                        }
                        else if (valc<100)
                        {
                            prescp.setText("You are affected by Prediabetes\nMetaglip\n" +
                                    "Glucovsnce\n"+
                                    "Actoplus Met\n"+
                                    "Prandimet\n"+
                                    "Kombiglyze\n"+
                                    "Janumet\n");
                        }
                        else
                        {
                            prescp.setText("Normal\n You are healthy");
                        }


                    }
                    else if (check2)
                    {
                        ck1.setVisibility(View.INVISIBLE);
                        cktxt1.setVisibility(View.INVISIBLE);
                        String sug1 = sug.getText().toString();
                        int valc = Integer.parseInt(sug1);
                        if (valc<180)
                        {
                            prescp.setText("Normal\n YOu are healthy");
                        }
                        else
                        {
                            prescp.setText("Diabetic\n" +
                                    "Kazano\nOseni\nMetaglip\nGlucovance\nJentadueto\nDuetact\nActoplus\n");
                        }
                    }
                    //prescp.setText("Hi");

                }
            });
        }

        else if (name.equals("BP"))
        {
            ck1.setVisibility(View.INVISIBLE);
            cktxt1.setVisibility(View.INVISIBLE);
            ck2.setVisibility(View.INVISIBLE);
            cktxt2.setVisibility(View.INVISIBLE);
            diab.setVisibility(View.INVISIBLE);
            sug.setVisibility(View.INVISIBLE);
            //checking.setVisibility(View.INVISIBLE);
            checking.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean check3 = ck3.isChecked();
                    boolean check4 = ck4.isChecked();
                    boolean check5 = ck5.isChecked();
                    if (check3)
                    {
                        ck4.setVisibility(View.INVISIBLE);
                        cktxt4.setVisibility(View.INVISIBLE);
                        ck5.setVisibility(View.INVISIBLE);
                        cktxt5.setVisibility(View.INVISIBLE);

                        prescp.setText("Low BP");


                    }
                    else if (check4)
                    {
                        ck3.setVisibility(View.INVISIBLE);
                        cktxt3.setVisibility(View.INVISIBLE);
                        ck5.setVisibility(View.INVISIBLE);
                        cktxt5.setVisibility(View.INVISIBLE);

                        prescp.setText("Normal BP");


                    }
                    else if (check5)
                    {
                        ck3.setVisibility(View.INVISIBLE);
                        cktxt3.setVisibility(View.INVISIBLE);
                        ck4.setVisibility(View.INVISIBLE);
                        cktxt4.setVisibility(View.INVISIBLE);

                        prescp.setText("High BP");


                    }
                }
            });
        }
//        ck1.setVisibility(View.VISIBLE);
//        cktxt1.setVisibility(View.VISIBLE);
//        ck2.setVisibility(View.VISIBLE);
//        cktxt2.setVisibility(View.VISIBLE);
//        diab.setVisibility(View.VISIBLE);
//        sug.setVisibility(View.VISIBLE);
//        checking.setVisibility(View.VISIBLE);
    }
    //    public  void compare()
//    {
//        int vals;
//        vals = sug.getText().toString();
//        if ()
//    }
    public void order(View view)
    {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:7204958072"));
        intent.putExtra("sms_body","We are having shortage of the prescribed medical drug\n" +
                "So we kindly request you to deliver the medicines to our address as soon as possible.");
        startActivity(intent);
    }
}
