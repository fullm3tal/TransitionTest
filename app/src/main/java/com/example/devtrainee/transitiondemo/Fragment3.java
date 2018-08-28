package com.example.devtrainee.transitiondemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment3 extends Fragment implements View.OnClickListener {

    @BindView(R.id.bt_frag2)
    Button button2;
    public static final String TAG="NextFragment";

    FragmentManager fragmentManager;

    public static final int EXIT_FADE_DURATION=1000;
    public static final int ENTER_FADE_DURATION=1000;

    public Fragment3() {
    }

    public static Fragment3 getInstance(){
        return new Fragment3();
    }

    @Override
    public void onStart() {
        super.onStart();
        System.out.println("Fragment 2 OnStart called");
    }

    @Override
    public void onResume() {
        super.onResume();
        System.out.println("Fragment 2 OnResume called");
    }

    @Override
    public void onPause() {
        super.onPause();
        System.out.println("Fragment 2 OnPause called");
    }

    @Override
    public void onStop() {
        super.onStop();
        System.out.println("Fragment 2 OnStop called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("Fragment 2 OnDestroy called");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        System.out.println(" Fragment 2 OnCreateView called");
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
              showTransition();
           break;
       }
    }
    private void showTransition() {
        Fragment nextFragment= Fragment1.getInstance();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.fragment_container, nextFragment,"FirstFragment");
            fragmentTransaction.commit();
        }
}
