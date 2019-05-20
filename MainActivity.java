//written by Myungsik Kim 05/20/2019

package com.example.testingsample;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText num1, num2;
    Button add, sub, mult, divi;
    int resultNum;
    int num01, num02;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.textView);
        num1 = findViewById(R.id.num01);
        num2 = findViewById(R.id.num02);
        add = findViewById(R.id.button);
        sub = findViewById(R.id.button2);
        mult = findViewById(R.id.button3);
        divi = findViewById(R.id.button4);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num01 = Integer.parseInt(num1.getText().toString());
                num02 = Integer.parseInt(num2.getText().toString());
                resultNum = add(num01, num02);
                result.setText(String.valueOf(resultNum));
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num01 = Integer.parseInt(num1.getText().toString());
                num02 = Integer.parseInt(num2.getText().toString());
                resultNum = sub(num01, num02);
                result.setText(String.valueOf(resultNum));
            }
        });

        divi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num01 = Integer.parseInt(num1.getText().toString());
                num02 = Integer.parseInt(num2.getText().toString());
                resultNum = divi(num01, num02);
                result.setText(String.valueOf(resultNum));
            }
        });

        mult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num01 = Integer.parseInt(num1.getText().toString());
                num02 = Integer.parseInt(num2.getText().toString());
                resultNum = mult(num01, num02);
                result.setText(String.valueOf(resultNum));
            }
        });
    }

    public int add(int num1, int num2){ // -9999 is false value

        if(num1 > 100 || num2 > 99){
            return -9999;
        }

        if(num1 < 1 || num2 < 1){
            return -9999;
        }

        return num1+num2;
    }

    public int sub(int num1, int num2){

        if(num2 > num1){
            return -9999;
        }

        if(num1 > 200 && num2 > 199){
            return -9999;
        }

        if(num1 <= 0 && num2 <= 0){
            return -9999;
        }

        return num1-num2;
    }

    public int mult(int num1, int num2){

        if(num1 == num2){
            return -9999;
        }

        if(num1 == 0 || num2 == 0){
            return -9999;
        }

        if(num1 < 0 && num2 < 0){
            return -9999;
        }

        return num1*num2;
    }

    public int divi(int num1, int num2){

        if(num1 > 100 || num2 > 100){
            return -9999;
        }

        if(num2 > num1){
            return -9999;
        }

        if(num1 <= 0 || num2 <= 0){
            return -9999;
        }

        return num1/num2;
    }
}