package com.example.dyscalculia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Mainmoney extends AppCompatActivity {

    Button checkmoney,countmoney;
    ImageButton home, info, cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmoney);

        home=(ImageButton) findViewById(R.id.homebtn);
        info=(ImageButton) findViewById(R.id.infobtn);
        cancel=(ImageButton) findViewById(R.id.cancelbtn);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gohomeActivity();

            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goinfoActivity();

            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancelprogram();

            }
        });

        checkmoney=(Button) findViewById(R.id.checkmoney);
        countmoney=(Button) findViewById(R.id.countmoney);

        countmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tm();
            }
        });

        checkmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm();
            }
        });
    }

    void tm(){

        Intent i=new Intent(Mainmoney.this,totalmoney.class);
        startActivity(i);
    }

    void cm(){

        Intent i1= new Intent(Mainmoney.this,givenmoney.class);
        startActivity(i1);
    }


    void gohomeActivity(){

        Intent intent5 = new Intent(Mainmoney.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(Mainmoney.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }

}
