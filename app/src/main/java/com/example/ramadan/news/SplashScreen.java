package com.example.ramadan.news;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private Intent intent;
    private ImageView official_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setsplash();
    }


    public void  setsplash()
    {
        official_logo = (ImageView) findViewById(R.id.images);
        final Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);

        intent = new Intent(getApplicationContext(), MainActivity.class);
        official_logo.startAnimation(animation);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });












//        Handler mymand=new Handler();
//        mymand.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                startActivity(new Intent(SplashScreen.this,MainActivity.class));
//                            }
//        },3000);
    }



}
