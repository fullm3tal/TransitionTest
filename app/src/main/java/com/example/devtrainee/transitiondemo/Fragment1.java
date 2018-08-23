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
import android.widget.Button;

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

        Fade enterFade = new Fade();
        enterFade.setDuration(2000);

        getActivity().getWindow().setEnterTransition(new Fade());

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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_frag1:
                performTransition();
                break;

            case R.id.bt_frag_second:

                TransitionManager.beginDelayedTransition(viewGroup);
                ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(getActivity());
                startActivity(new Intent(getActivity(), SecondActivity.class),options.toBundle());
                break;
        }
    }
    private void performTransition() {
        Fragment previousFragment= fragmentManager.findFragmentById(R.id.fragment_container);
        Fragment nextFragment= Fragment2.getInstance();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

        TransitionUtils.performTransition(previousFragment, nextFragment);

            fragmentTransaction.replace(R.id.fragment_container, nextFragment);
            fragmentTransaction.commitAllowingStateLoss();
        }
    }
