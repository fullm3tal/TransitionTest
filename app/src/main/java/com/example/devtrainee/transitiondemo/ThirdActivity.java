package com.example.devtrainee.transitiondemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener {

    Button button_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        Fade enterFade= new Fade();
        enterFade.setDuration(2000);
        Fade exitFade= new Fade();
        exitFade.setDuration(2000);
        getWindow().setExitTransition(exitFade);
        getWindow().setEnterTransition(enterFade);
        setContentView(R.layout.activity_third);
        button_test= (Button)findViewById(R.id.bt_test);
        button_test.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_test:
                Intent intent= new Intent(this, TestActivity.class);
                startActivity(intent,
                        ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
              overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                              break;
        }

    }
}
