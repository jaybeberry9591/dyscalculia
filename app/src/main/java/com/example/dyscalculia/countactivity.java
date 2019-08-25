package com.example.dyscalculia;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class countactivity extends AppCompatActivity {
     ImageButton home, info, cancel;
     TextToSpeech mTTS;
     EditText mEditText;
     ImageButton mButtonSpeak;
     TextView resultText2;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.countactivity);
        home=(ImageButton) findViewById(R.id.homebtn2);
        info=(ImageButton) findViewById(R.id.infobtn2);
        cancel=(ImageButton) findViewById(R.id.cancelbtn2);
        mButtonSpeak=(ImageButton) findViewById(R.id.speackerBtn);
        mEditText=(EditText) findViewById(R.id.edcount);
        resultText2=(TextView) findViewById(R.id.resultTxt2);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohomeActivity1();

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goinfoActivity1();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelprogram1();

            }
        });

        mTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status == TextToSpeech.SUCCESS) {
                    int result = mTTS.setLanguage(Locale.ENGLISH);

                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        Log.e("TTS", "Language not supported");
                    } else {
                        mButtonSpeak.setEnabled(true);
                    }
                } else {
                    Log.e("TTS", "Initialization failed");
                }
            }
        });


        mButtonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

    }


    private void speak() {
        String n= null;
        String substring=null;
        int num= 0;
        String s = mEditText.getText().toString().trim();
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(s);

        //substring=s.substring(0,3);
        //Toast.makeText(getApplicationContext(),substring,Toast.LENGTH_LONG).show();
        if(s.contains("cos")){
            while (m.find()){
                n=m.group();

            }

            String con=n.toString();
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);
            double x=Math.cos(i);
            String z=new DecimalFormat("##.###").format(x);
            resultText2.setText(z);
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }

        else if(s.contains("sin")){
            while (m.find()){
                n=m.group();

            }

            String con=n.toString();
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);

            double x=Math.sin(i);
            String z=new DecimalFormat("##.###").format(x);
            resultText2.setText(z);
            //Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }

        else if(s.contains("tan")){
            while (m.find()){
                n=m.group();

            }

            String con=n.toString();
            num=Integer.parseInt(con);
            Double i= new Double(num);
            i=Math.toRadians(i);
            double x=Math.tan(i);
            String z=new DecimalFormat("##.###").format(x);
            resultText2.setText(z);
          //  Toast.makeText(getApplicationContext(),new DecimalFormat("##.###").format(x)+"",Toast.LENGTH_LONG).show();

        }


        String text = resultText2.getText().toString().trim();
        mTTS.speak(text, TextToSpeech.QUEUE_FLUSH, null);
    }


    @Override
    protected void onDestroy() {
        if (mTTS != null) {
            mTTS.stop();
            mTTS.shutdown();
        }

        super.onDestroy();
    }

    void gohomeActivity1(){

        Intent intent5 = new Intent(countactivity.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity1(){

        Intent intent=new Intent(countactivity.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram1(){

        finish();
        moveTaskToBack(true);
    }
}
