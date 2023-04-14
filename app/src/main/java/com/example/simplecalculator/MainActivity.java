package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button add,sub,calculate;
    EditText num1,num2;
    TextView res;

    String operation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add  = findViewById(R.id.add);
        sub = findViewById(R.id.sub);
        calculate = findViewById(R.id.cal);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        res = findViewById(R.id.result);
        add.setOnClickListener(V -> {
            operation = "+";
        });
        sub.setOnClickListener(V -> {
            operation = "-";
        });
        calculate.setOnClickListener(V -> {
            String input1 = num1.getText().toString().trim();
            String input2 = num2.getText().toString().trim();
            if(TextUtils.isEmpty(input1)) {
                Toast.makeText(MainActivity.this, "Input Field Number 1 is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            if(TextUtils.isEmpty(input2)) {
                Toast.makeText(MainActivity.this, "Input Field Number 2 is empty", Toast.LENGTH_SHORT).show();
                return;
            }
            int number1 = Integer.parseInt(input1);
            int number2 = Integer.parseInt(input2);
            if(operation == "+") {
                add.setBackgroundResource(android.R.color.holo_green_light);
                sub.setBackgroundResource(android.R.color.white);
                res.setText(number1 + " " + operation + " " + number2 + " = " + (number1+number2));
            }else if(operation == "-") {
                add.setBackgroundResource(android.R.color.white);
                sub.setBackgroundResource(android.R.color.holo_green_light);
                res.setText(number1 + " " + operation + " " + number2 + " = " + (number1-number2));
            } else {
                Toast.makeText(MainActivity.this, "Please Select an Operation.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}