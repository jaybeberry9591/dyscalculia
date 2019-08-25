package com.example.dyscalculia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {


    Button pb,pb1,pb2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        pb=(Button) findViewById(R.id.calculatorBtn);
        pb1=(Button)findViewById(R.id.DirectionBtn);
        pb2=(Button)findViewById(R.id.countBtn);
        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity();

            }
        });
        pb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity1();

            }
        });
        pb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openactivity2();

            }
        });

    }
    public void openactivity() {

        Intent intent5 = new Intent(HomeActivity.this, calculationactivity.class);
        startActivity(intent5);


    }
    public void openactivity1() {

        Intent intent6 = new Intent(HomeActivity.this, directionActivity.class);
        startActivity(intent6);


    }
    public void openactivity2() {

        Intent intent66 = new Intent(HomeActivity.this, countactivity.class);
        startActivity(intent66);


    }

}
