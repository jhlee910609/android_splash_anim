package com.example.umsun_android.myapplication;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    private TextView tv1;
    private TextView tv2;
    private Handler mHandler;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        setTextAnim(0, 20000, 3000, tv1);
        setTextAnim(0, 1231245, 3000, tv2);
//        setCount();

    }

    private void goToHome(int value) {
        if (value == 20000) {
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    go();
                    Log.e("MainActivity", "=============== goToHome, run");
                }
            }, 1500);
        }
    }

    private void setCount() {
        for (int i = 0; i < 34789473; i++) {
            if (i == 34789472)
                go();
        }
    }

    synchronized private void go() {
        count++;
        if (count > 2) {
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            startActivity(intent);
        }
    }

    private void initView() {
        tv1 = (TextView) findViewById(R.id.textview1);
        tv2 = (TextView) findViewById(R.id.textview2);
    }

    private void setTextAnim(int start, int end, int duration, final TextView tv) {
        ValueAnimator animator = ValueAnimator.ofInt(start, end);
        animator.setDuration(duration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DecimalFormat df = new DecimalFormat("###,###,###");
                tv.setText(df.format((int) valueAnimator.getAnimatedValue()));
                goToHome((int) valueAnimator.getAnimatedValue());

            }
        });
        animator.start();
    }
}
