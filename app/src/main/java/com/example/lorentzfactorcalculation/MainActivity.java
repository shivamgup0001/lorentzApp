package com.example.lorentzfactorcalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView;
    private double result;
    private long a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);
        long c = 300000000;


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils. isEmpty(editText. getText(). toString()))
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                else {
                    String s =editText.getText().toString();
                    long a = Long.parseLong(s);
                    if (a < c) {
                        double z = Math.pow((Math.pow(c, 2) - Math.pow(a, 2)), 0.5);
                        result = c / z;
                        textView.setText("The Lorentz factor is " + result);
                    } else {
                        Toast.makeText(MainActivity.this, "The value of velocity entered is invalid.", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }

}