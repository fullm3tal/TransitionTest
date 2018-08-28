package com.example.devtrainee.transitiondemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_third;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button_third = (Button) findViewById(R.id.bt_third);
        button_third.setOnClickListener(this);
        setWindowAnimations();
    }

    private void setWindowAnimations() {
//        Slide enterSlide= new Slide();
//        enterSlide.setDuration(2000);
        Fade enterFade = new Fade();
        enterFade.setDuration(2000);
//        enterFade.excludeTarget(android.R.id.statusBarBackground, true);
//        enterFade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setEnterTransition(enterFade);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_third:
                Intent intent = new Intent(this, ThirdActivity.class);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
                break;
        }
    }
}
