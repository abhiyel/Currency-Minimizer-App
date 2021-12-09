package com.example.currencyminimizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    TextView[] tvs = new TextView[10];
    TextView residualAmount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        try{
            Intent intent3 = getIntent();
            boolean[] arr = intent3.getBooleanArrayExtra("denominationsAvailable");
            String amt = intent3.getStringExtra("amounts");
            int sum = Integer.parseInt(amt);
            tvs[0] = (TextView) findViewById(R.id.tv1);
            tvs[1] = (TextView) findViewById(R.id.tv2);
            tvs[2] = (TextView) findViewById(R.id.tv5);
            tvs[3] = (TextView) findViewById(R.id.tv10);
            tvs[4] = (TextView) findViewById(R.id.tv20);
            tvs[5] = (TextView) findViewById(R.id.tv50);
            tvs[6] = (TextView) findViewById(R.id.tv100);
            tvs[7] = (TextView) findViewById(R.id.tv200);
            tvs[8] = (TextView) findViewById(R.id.tv500);
            tvs[9] = (TextView) findViewById(R.id.tv2000);

            //Initializing Number of notes/coins of each denominations to 0
            int N1 = 0, N2 = 0, N5 = 0, N10 = 0, N20 = 0;
            int N50 = 0, N100 = 0, N200 = 0, N500 = 0, N2000 = 0;

            //finding max number of 2000 Rs. notes required

            if(arr[9]) {
                while (sum >= 2000) {
                    sum -= 2000;
                    N2000++;
                }
            }


            //finding max number of 500 Rs. notes required

            if(arr[8]) {
                while (sum >= 500) {
                    sum -= 500;
                    N500++;
                }
            }


            //finding max number of 200 Rs. notes required

            if(arr[7]){
                while(sum>=200)
                {
                    sum -= 200;
                    N200++;
                }
            }


            //finding max number of 100 Rs. notes required

            if(arr[6]) {
                while (sum >= 100) {
                    sum -= 100;
                    N100++;
                }
            }


            //finding max number of 50 Rs. notes required

            if(arr[5]) {
                while (sum >= 50) {
                    sum -= 50;
                    N50++;
                }
            }


            //finding max number of 20 Rs. notes required

            if(arr[4]) {
                while (sum >= 20) {
                    sum -= 20;
                    N20++;
                }
            }


            //finding max number of 10 Rs. notes/coins required

            if(arr[3]) {
                while (sum >= 10) {
                    sum -= 10;
                    N10++;
                }
            }


            //finding max number of 5 Rs. coins required

            if(arr[2]) {
                while (sum >= 5) {
                    sum -= 5;
                    N5++;
                }
            }


            //finding max number of 2 Rs. coins required

            if(arr[1]) {
                while (sum >= 2) {
                    sum -= 2;
                    N2++;
                }
            }


            //finding max number of 1 Re. coins required

            if(arr[0]) {
                while (sum >= 1) {
                    sum -= 1;
                    N1++;
                }
            }


            tvs[0].setText(String.valueOf(N1));
            tvs[9].setText(String.valueOf(N2000));
            tvs[8].setText(String.valueOf(N500));
            tvs[1].setText(String.valueOf(N2));
            tvs[2].setText(String.valueOf(N5));
            tvs[3].setText(String.valueOf(N10));
            tvs[4].setText(String.valueOf(N20));
            tvs[5].setText(String.valueOf(N50));
            tvs[6].setText(String.valueOf(N100));
            tvs[7].setText(String.valueOf(N200));

            residualAmount = (TextView) findViewById(R.id.tvr);
            residualAmount.setText(String.valueOf(sum));
        }
        catch(Exception e){
            Log.d("new act", e.getMessage());

        }
    }
    public void creditspage(View view){
        Intent intent = new Intent(this, MainActivity4.class);
        startActivity(intent);
    }
}