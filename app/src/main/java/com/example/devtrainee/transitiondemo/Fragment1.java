package com.example.devtrainee.transitiondemo;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.transition.Fade;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment1 extends Fragment implements View.OnClickListener {

    @BindView(R.id.bt_frag1)
    Button button1;

    @BindView(R.id.bt_frag_second)
    Button buttonSecondFrag;


    FragmentManager fragmentManager;
    public static final int EXIT_FADE_DURATION=1000;
    public static final int ENTER_FADE_DURATION=1000;
    ViewGroup viewGroup;

    public Fragment1() {
    }

    public static Fragment1 getInstance() {
        return new Fragment1();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(" Fragment 1 OnCreateView called");
        View view = inflater.inflate(R.layout.frag_first, container, false);
        fragmentManager= getFragmentManager();
        if (view != null) {
            ButterKnife.bind(this, view);
            viewGroup= container;
            buttonSecondFrag.setOnClickListener(this);
            button1.setOnClickListener(this);
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println(" Fragment 1 OnStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Fragment 1 OnResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Fragment 1 OnPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Fragment 1 OnStop called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Fragment 1 OnDestroy called");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_frag1:
                showTransition();
                break;

            case R.id.bt_frag_second:

                Intent intent= new Intent(getContext(), SecondActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
                break;
        }
    }
    private void showTransition() {

        Fragment2 nextFragment= Fragment2.getInstance();
       FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

//        TransitionUtils.performTransition(fragmentManager, nextFragment);

            fragmentTransaction.add(R.id.fragment_container, nextFragment,"SecondFragment");
            fragmentTransaction.commit();
        }
    }
