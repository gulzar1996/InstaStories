package com.github.gulzar1996.instastories.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.github.gulzar1996.instastories.R;
import com.github.gulzar1996.instastories.ui.fragment.StoryFragment;
import com.github.gulzar1996.instastories.ui.transform.CubeTransformer;
import com.github.gulzar1996.instastories.ui.widget.MyViewPager;

import jp.shts.android.storiesprogressview.StoriesProgressView;

/**
 * Created by gulza on 10/31/2017.
 */

public class StatusActivty extends AppCompatActivity  {

    private MyViewPager mViewPager;
    private PageAdapter mAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_status);

        mAdapter = new PageAdapter(getSupportFragmentManager());
        mViewPager=findViewById(R.id.container);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setPageTransformer(false,new CubeTransformer());
        //Has to be dynamic
        mViewPager.setCurrentItem(0);
        mViewPager.setOffscreenPageLimit(1);
    }


    private static final class PageAdapter extends FragmentStatePagerAdapter {

        public PageAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            final Bundle bundle = new Bundle();
            bundle.putInt(StoryFragment.EXTRA_POSITION, position + 1);
            final StoryFragment fragment = new StoryFragment();
            fragment.setArguments(bundle);
            return fragment;
        }

        @Override
        public int getCount() {
            return 5;
        }

    }
}
