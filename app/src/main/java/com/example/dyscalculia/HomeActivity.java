package com.example.dyscalculia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.GridLayout;

public class HomeActivity extends AppCompatActivity {


    GridLayout mainGrid;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        mainGrid=(GridLayout) findViewById(R.id.mainGrid);
        setSingleEvent(mainGrid);

    }

    private  void setSingleEvent(GridLayout mainGrid){

        for(int i=0;i<mainGrid.getChildCount();i++){
            CardView cardView=(CardView) mainGrid.getChildAt(i);
            final int finalI = i;
            cardView.setOnClickListener(new View.OnClickListener(){
                @Override
                public  void onClick(View view){
                    if(finalI==0){
                        Intent intent= new Intent(HomeActivity.this,calculationactivity.class);
                        startActivity(intent);
                    }
                    else if(finalI==1){
                        Intent intent= new Intent(HomeActivity.this,directionActivity.class);
                        startActivity(intent);
                    }

                    else if(finalI==2){
                        Intent intent= new Intent(HomeActivity.this,countactivity.class);
                        startActivity(intent);
                    }


                    else if(finalI==3){
                        Intent intent= new Intent(HomeActivity.this,Mainmoney.class);
                        startActivity(intent);
                    }

                    else if(finalI==4){
                        Intent intent= new Intent(HomeActivity.this, transpose.class);
                        startActivity(intent);
                    }

                    else if(finalI==5){
                        Intent intent= new Intent(HomeActivity.this,eventmana.class);
                        startActivity(intent);
                    }

                }

            });

        }


    }

}
