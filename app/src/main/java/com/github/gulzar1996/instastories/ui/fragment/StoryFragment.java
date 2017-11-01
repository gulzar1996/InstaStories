package com.github.gulzar1996.instastories.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.gulzar1996.instastories.R;

/**
 * Created by gulza on 11/1/2017.
 */

public class StoryFragment extends Fragment {
    public static final String EXTRA_POSITION = "EXTRA_POSITION";
    private static final int[] COLORS = new int[] { 0xFF33B5E5, 0xFFAA66CC, 0xFF99CC00, 0xFFFFBB33, 0xFFFF4444 };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int position = getArguments().getInt(EXTRA_POSITION);
        View view= inflater.inflate(R.layout.fragment_story, container, false);
        ImageView imageView =view.findViewById(R.id.image);
        imageView.setBackgroundColor(COLORS[position - 1]);
        return view;
    }
}
