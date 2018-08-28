package com.example.devtrainee.transitiondemo;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class NewActivity extends AppCompatActivity {

    ImageView imageView;
    Handler handler;

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        handler = new Handler();

        imageView = (ImageView) findViewById(R.id.testing_ball_iv);
        final Animation animationRight = AnimationUtils.loadAnimation(this, R.anim.move);
        final Animation animationLeft = AnimationUtils.loadAnimation(this, R.anim.move_left);

        animationLeft.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                 imageView.startAnimation(animationRight);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        final Runnable runnable = new Runnable() {
            @Override
            public void run() {

                imageView.startAnimation(animationRight);
                animationRight.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        imageView.startAnimation(animationLeft);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
            }
        };
                handler.postDelayed(runnable, 2000);

            }
        }


