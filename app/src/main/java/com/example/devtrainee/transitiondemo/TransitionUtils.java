package com.example.devtrainee.transitiondemo;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.transition.Fade;

public class TransitionUtils {

    public static final int EXIT_FADE_DURATION=1000;
    public static final int ENTER_FADE_DURATION=1000;

    public static void performTransition(FragmentManager fragmentManager, Fragment nextFragment) {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {

            Fragment previousFragment= fragmentManager.findFragmentById(R.id.fragment_container);
            Fade exitFade = new Fade();
            exitFade.setDuration(EXIT_FADE_DURATION);
            previousFragment.setExitTransition(exitFade);

            Fade enterFade= new Fade();
            enterFade.setStartDelay(1000);
            enterFade.setDuration(ENTER_FADE_DURATION);
            nextFragment.setEnterTransition(enterFade);
        }
    }

    public static void performTransition(Fragment fragment) {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP) {

            Fade exitFade = new Fade();
            exitFade.setDuration(EXIT_FADE_DURATION);
            fragment.setExitTransition(exitFade);
        }
    }

}
