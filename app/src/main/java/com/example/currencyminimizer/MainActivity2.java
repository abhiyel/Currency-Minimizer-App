package com.example.currencyminimizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    CheckBox[] arrcb = new CheckBox[10];
    CheckBox selectAll;
    TextView tv;
    String tvValue;
    String amount;
    Button minimize;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        CheckBox selectAll = (CheckBox) findViewById(R.id.cball);
        et = (EditText) findViewById(R.id.editTextNumber);
        tv = (TextView) findViewById(R.id.tvamount);
        minimize  =(Button) findViewById(R.id.btnAmount);
        arrcb[0] = findViewById(R.id.cb1);
        arrcb[1] = findViewById(R.id.cb2);
        arrcb[2] = findViewById(R.id.cb5);
        arrcb[3] = findViewById(R.id.cb10);
        arrcb[4] = findViewById(R.id.cb20);
        arrcb[5] = findViewById(R.id.cb50);
        arrcb[6] = findViewById(R.id.cb100);
        arrcb[7] = findViewById(R.id.cb200);
        arrcb[8] = findViewById(R.id.cb500);
        arrcb[9] = findViewById(R.id.cb2000);


        selectAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( selectAll.isChecked()){
                    for(CheckBox cb:arrcb){
                        if (!cb.isChecked()){
                            cb.setChecked(true);
                        }
                    }
                }
            }
        });
    }

    public void beginMinimization(View view) {

        boolean[] arrAvailable = new boolean[10];
        for(int i=0;i<arrcb.length;i++){
            if(arrcb[i].isChecked()){
            arrAvailable[i] = true;
            }else{
                arrAvailable[i] = false;
            }
        }
        Intent intent = new Intent(this, MainActivity3.class);
        try{
            amount = et.getText().toString();

            intent.putExtra("denominationsAvailable", arrAvailable);
            intent.putExtra("amounts", amount);
            startActivity(intent);
        }
        catch(Exception e){
            startActivity(intent);
        }

    }
}