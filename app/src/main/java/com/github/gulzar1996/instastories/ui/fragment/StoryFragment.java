package com.github.gulzar1996.instastories.ui.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.gulzar1996.instastories.R;
import com.github.gulzar1996.instastories.data.model.StoryList;
import com.github.gulzar1996.instastories.ui.adapter.StoryAdapter;

import java.util.ArrayList;
import java.util.List;

import im.ene.toro.PlayerSelector;
import im.ene.toro.widget.Container;
import jp.shts.android.storiesprogressview.StoriesProgressView;

/**
 * Created by gulza on 11/1/2017.
 */

public class StoryFragment extends BaseFragment implements StoriesProgressView.StoriesListener {

    private Container storyContainer;
    private LinearLayoutManager layoutManager;
    private StoryAdapter mStoryAdapter;
    private StoriesProgressView storiesProgressView;

    View reverse, skip;
    ViewPager mviewPager;
    int viewPagerPosition;

    private int recyclerPosition=0;


    PlayerSelector selector = PlayerSelector.DEFAULT; // visible to user by default.
    final Handler handler = new Handler(); // post a delay due to the visibility change

    private int STORIES_COUNT=3;
    public static final String EXTRA_POSITION = "EXTRA_POSITION";
    private static final int[] COLORS = new int[] { 0xFF33B5E5, 0xFFAA66CC, 0xFF99CC00, 0xFFFFBB33, 0xFFFF4444 };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        viewPagerPosition = getArguments().getInt(EXTRA_POSITION);
        View view= inflater.inflate(R.layout.fragment_story, container, false);
        storyContainer=view.findViewById(R.id.story_container);
        storiesProgressView=view.findViewById(R.id.stories_progressview);
        reverse = view.findViewById(R.id.reverse);
        skip= view.findViewById(R.id.skip);
        ImageView imageView =view.findViewById(R.id.image);
        imageView.setBackgroundColor(COLORS[viewPagerPosition - 1]);
        return view;
    }

    @Override public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }

            @Override
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        storyContainer.setLayoutManager(layoutManager);
        // bind reverse view
        reverse.setOnClickListener(v -> storiesProgressView.reverse());
        reverse.setOnTouchListener(onTouchListener);

        // bind skip view
        skip.setOnClickListener(v -> storiesProgressView.skip());
        skip.setOnTouchListener(onTouchListener);
        testAdapter();

            storyContainer.setPlayerSelector(null);
            handler.postDelayed(() -> {
                if (storyContainer != null) storyContainer.setPlayerSelector(selector);
            }, 500);

    }

    //Why take risk ?
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        storiesProgressView.setStoriesCount(STORIES_COUNT);
        storiesProgressView.setStoryDuration(3000L);
        storiesProgressView.setStoriesListener(this);


        //If the viewpager viewPagerPosition matches
        int currentPosition = getArguments().getInt(EXTRA_POSITION);
        mviewPager = getActivity().findViewById(R.id.container);




    }

    long pressTime = 0L;
    long limit = 500L;
    //Pause reverse
    private View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pressTime = System.currentTimeMillis();
                    storiesProgressView.pause();
                    return false;
                case MotionEvent.ACTION_UP:
                    long now = System.currentTimeMillis();
                    storiesProgressView.resume();
                    return limit < now - pressTime;
            }
            return false;
        }
    };

    //Temp
    public void testAdapter()
    {
        List<StoryList> mStories=new ArrayList<>();
        mStories.add(new StoryList(false,"https://pbs.twimg.com/media/C8mtrEMXcAA9KKM.jpg:large"));
        mStories.add(new StoryList(true,"https://scontent-gru2-2.cdninstagram.com/t50.2886-16/14965218_193969377722724_482497862983221248_n.mp4"));
        mStories.add(new StoryList(false,"https://images.unsplash.com/photo-1500027014421-46ccc843776a?dpr=1&auto=format&fit=crop&w=1000&q=80&cs=tinysrgb&ixid=dW5zcGxhc2guY29tOzs7Ozs%3D"));
        mStories.add(new StoryList(true,"https://instagram.frao1-1.fna.fbcdn.net/t50.2886-16/17886251_1128605603951544_572796556789415936_n.mp4"));
        mStoryAdapter = new StoryAdapter(mStories);
        storyContainer.setAdapter(mStoryAdapter);
        STORIES_COUNT=mStoryAdapter.getItemCount();
    }

    @Override public void onDestroyView() {
        handler.removeCallbacksAndMessages(null);
        layoutManager = null;
        mStoryAdapter = null;
        selector = null;
        mviewPager.addOnPageChangeListener(null);
        storiesProgressView.destroy();
        super.onDestroyView();
    }

    @Override public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            selector = PlayerSelector.DEFAULT;
        } else {
            selector = PlayerSelector.NONE;
        }
        // Using TabLayout has a downside: once we click to a tab to change page, there will be no animation,
        // which will cause our setup doesn't work well. We need a delay to make things work.
            if (storyContainer != null) storyContainer.setPlayerSelector(selector);

    }


    @Override
    public void onNext() {
        storyContainer.scrollToPosition(++recyclerPosition);
    }

    @Override
    public void onPrev() {
        storyContainer.scrollToPosition(--recyclerPosition);
    }

    @Override
    public void onComplete() {
        mviewPager.setCurrentItem(viewPagerPosition,true);
        Toast.makeText(getContext(), "Completed "+ viewPagerPosition, Toast.LENGTH_SHORT).show();
    }
}
