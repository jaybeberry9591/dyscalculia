package com.example.dyscalculia;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class directionActivity extends AppCompatActivity {
    ImageButton home, info, cancel;
    Button left,right,uturn,straight;
    ListView list;

    ArrayList<String> arrayList;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.directionactivity);
        home=(ImageButton) findViewById(R.id.homebtn);
        info=(ImageButton) findViewById(R.id.infobtn);
        cancel=(ImageButton) findViewById(R.id.cancelbtn);
        left=(Button)findViewById(R.id.leftbtn);
        right=(Button) findViewById(R.id.rightbtn);
        uturn=(Button) findViewById(R.id.uturnbtn);
        straight=(Button) findViewById(R.id.straightbtn);
        list=(ListView) findViewById(R.id.listview);

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

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leftActivity();

            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rightActivity();

            }
        });
        uturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uturnActivity();

            }
        });
        straight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                straightActivity();

            }
        });


        arrayList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(directionActivity.this,android.R.layout.simple_list_item_1,arrayList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String name = (String) parent.getItemAtPosition(position);
                if(name.contentEquals("Left")){
                   Intent in= new Intent(directionActivity.this,left.class);
                   startActivity(in);
                }
                else if(name.contentEquals("Right")){
                    Intent in= new Intent(directionActivity.this,right.class);
                    startActivity(in);
                }
                else if(name.contentEquals( "U turn")){
                    Intent in= new Intent(directionActivity.this,uturn.class);
                    startActivity(in);
                }
                else if(name.contentEquals("Straight")){
                    Intent in= new Intent(directionActivity.this,straight.class);
                    startActivity(in);
                }
            }
        });
    }

    void gohomeActivity(){

        Intent intent5 = new Intent(directionActivity.this, HomeActivity.class);
        startActivity(intent5);
    }

    void goinfoActivity(){

        Intent intent=new Intent(directionActivity.this, infoActivity.class);
        startActivity(intent);

    }

    void cancelprogram(){

        finish();
        moveTaskToBack(true);
    }

    void leftActivity(){
        String result= "Left";
        arrayList.add(result);
        adapter.notifyDataSetChanged();

    }

    void rightActivity(){
        String result= "Right";
        arrayList.add(result);
        adapter.notifyDataSetChanged();

    }

    void uturnActivity(){
        String result= "U turn";
        arrayList.add(result);
        adapter.notifyDataSetChanged();

    }

    void straightActivity(){
        String result= "Straight";
        arrayList.add(result);
        adapter.notifyDataSetChanged();

    }
}
