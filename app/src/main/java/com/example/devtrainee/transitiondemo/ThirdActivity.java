package com.example.devtrainee.transitiondemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        button_test = (Button) findViewById(R.id.bt_test);
        button_test.setOnClickListener(this);
//        setWindowAnimations();
    }

    private void setWindowAnimations() {

        Fade exitFade = new Fade();
        exitFade.setDuration(2000);
//        exitFade.excludeTarget(android.R.id.statusBarBackground, true);
//        exitFade.excludeTarget(android.R.id.navigationBarBackground, true);
        getWindow().setExitTransition(exitFade);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_test:
                Intent intent = new Intent(this, TestActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                break;
        }

    }
}
