package com.example.devtrainee.transitiondemo;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment2 extends Fragment implements View.OnClickListener {

    @BindView(R.id.bt_frag2)
    Button button2;

    FragmentManager fragmentManager;

    public static final int EXIT_FADE_DURATION=1000;
    public static final int ENTER_FADE_DURATION=1000;

    public Fragment2() {
    }

    public static Fragment2 getInstance(){
        return new Fragment2();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.frag_second,container,false);
        fragmentManager = getFragmentManager();

        if(view!=null){
            ButterKnife.bind(this,view);
            button2.setOnClickListener(this);
        }

        return view;
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()) {
           case R.id.bt_frag2:
              performTransition();
           break;
       }
    }
    private void performTransition() {
        Fragment previousFragment= fragmentManager.findFragmentById(R.id.fragment_container);
        Fragment nextFragment= Fragment1.getInstance();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {

            Fade exitFade = new Fade();
            exitFade.setDuration(EXIT_FADE_DURATION);
            previousFragment.setExitTransition(exitFade);

            Fade enterFade= new Fade();
            enterFade.setStartDelay(1000);
            enterFade.setDuration(ENTER_FADE_DURATION);
            nextFragment.setEnterTransition(enterFade);

            fragmentTransaction.replace(R.id.fragment_container, nextFragment);
            fragmentTransaction.commitAllowingStateLoss();
        }
    }
}
