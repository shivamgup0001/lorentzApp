package com.example.lorentzfactorcalculation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import android.os.Vibrator;


public class MainActivity2 extends AppCompatActivity {
    private Button button2;
    private EditText editText4;
    private EditText editText3;
    private TextView textView2;
    private double result1;
    private long a1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
     //  ViewGroup layout = (ViewGroup) view.findViewById(R.id.widget101);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        editText3 =findViewById(R.id.editText3);
        button2 = findViewById(R.id.button2);
        textView2 = findViewById(R.id.textView2);
        editText4 = findViewById(R.id.editText4);
        long c = 300000000;
        View view = this.getWindow().getDecorView();
        final Handler handler = new Handler();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {

                if (TextUtils. isEmpty(editText3. getText(). toString()))
                    Toast.makeText(MainActivity2.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                else {
                    String s =editText3.getText().toString();
                    String s1 =editText4.getText().toString();

                    if (TextUtils. isEmpty(editText4. getText(). toString()))
                        Toast.makeText(MainActivity2.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                    else {
                        long a1 = Long.parseLong(s);
                        if (a1 < c) {
                            double z = Math.pow((Math.pow(c, 2) - Math.pow(a1, 2)), 0.5);
                            result1 = c / z;

                            double y = Double.parseDouble(s1);
                            // Toast.makeText(MainActivity.this, "result "+y, Toast.LENGTH_SHORT).show();
                            if (y == result1) {
                                Toast.makeText(MainActivity2.this, "Your answer is right", Toast.LENGTH_SHORT).show();
                                textView2.setText("Your answer is correct ");
                                view.setBackgroundResource(R.color.green);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        view.setBackgroundResource(R.color.white);
                                    }
                                }, 2000);

                            } else {
                                Toast.makeText(MainActivity2.this, "Your answer is wrong", Toast.LENGTH_SHORT).show();
                                v.vibrate(400);
                                textView2.setText("Your answer is wrong\nThe correct answer is\n" + result1);
                                view.setBackgroundResource(R.color.red);
                                handler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        view.setBackgroundResource(R.color.white);
                                    }
                                }, 2000);

                            }
                        } else {
                            Toast.makeText(MainActivity2.this, "The value of velocity entered is invalid.", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


    }

}