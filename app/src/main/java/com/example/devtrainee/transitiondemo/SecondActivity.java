package com.example.devtrainee.transitiondemo;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.bt_second)
    Button btSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_second);

        Fade enterFade = new Fade();
        enterFade.setDuration(1000);

        Fade exitFade = new Fade();
        enterFade.setDuration(3000);

        getWindow().setEnterTransition(enterFade);
        getWindow().setExitTransition(exitFade);

        ButterKnife.bind(this);
        btSecond.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_second:
                ViewGroup viewGroup= findViewById(R.id.transition_container);
                TransitionManager.beginDelayedTransition(viewGroup);
                ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(this);
                startActivity(new Intent(this, MainActivity.class), options.toBundle());
                break;
        }
    }
}
