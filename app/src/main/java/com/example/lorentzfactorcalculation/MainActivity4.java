package com.example.lorentzfactorcalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Calendar;


public class MainActivity4 extends AppCompatActivity {
private TextView textView4;
    private TextView textView5;
private int hour;
private int minute;
private int second;
private double spi;
private int fact;
    int factorial(int h1)
    {
        int f=1;
        if (h1<12)
        {
            for(int i=1;i<=h1;i++)
                f=f*i;
            return f;
        }
        else
        {
            h1=h1-12;
            for(int i=1;i<=h1;i++)
                f=f*i;
            return f;

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        textView4=findViewById(R.id.textView4);
        textView5=findViewById(R.id.textView5);
        CountDownTimer newtimer = new CountDownTimer(1000000000, 1000) {

            public void onTick(long millisUntilFinished) {
                Calendar c = Calendar.getInstance();
                textView4.setText(c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND));
                hour=c.get(Calendar.HOUR);
                minute=c.get(Calendar.MINUTE);
                second=c.get(Calendar.SECOND);
                fact=factorial(hour);
                spi=fact/((Math.pow(minute,3))+second);
                textView5.setText("The SPI Factor is \n"+spi);
            }
            public void onFinish() {

            }
        };
        newtimer.start();

    }
}