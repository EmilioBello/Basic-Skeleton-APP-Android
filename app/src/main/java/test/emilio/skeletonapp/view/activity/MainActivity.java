package test.emilio.skeletonapp.view.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import test.emilio.skeletonapp.R;
import test.emilio.skeletonapp.view.fragment.BaseFragment;
import test.emilio.skeletonapp.view.fragment.SeriesFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment currentFragment = null;
    private int posCurrentFragment = 1;

    public static final int FRAGMENT_SERIES     = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showFragment(1);

    }

    private void showFragment(int position) {
        Fragment frag = null;
        BaseFragment baseFragment = null;

        switch (position) {
            case 0:
            case FRAGMENT_SERIES: {
                baseFragment = new SeriesFragment();
                posCurrentFragment = position;
                break;
            }
        }

        if (baseFragment != null) {
            baseFragment.setActivity(this);
            frag = baseFragment;
            loadFragment(frag);
        }
    }

    private void loadFragment(Fragment fragment) {
        currentFragment = fragment;

        // update the activity_game content by replacing fragments
        if (currentFragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            if (!isFinishing()) {
                FragmentTransaction ft = fragmentManager.beginTransaction();
                ft.replace(R.id.flContent, currentFragment).commitAllowingStateLoss();
            }
        } else {
            Log.e("Error", "loadFragment: " + posCurrentFragment);
        }
    }
}
