package com.github.gulzar1996.instastories.ui.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.gulzar1996.instastories.R;
import com.github.gulzar1996.instastories.data.model.StoryList;
import com.github.gulzar1996.instastories.ui.StatusActivty;
import com.github.gulzar1996.instastories.ui.viewholder.ImageViewHolder;
import com.github.gulzar1996.instastories.ui.viewholder.VideoViewHolder;

import java.util.List;

/**
 * Created by gulza on 11/1/2017.
 */

public class StoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StoryList> mStories;

    private final int IMAGE_STORY = 0;
    private final int VIDEO_STORY = 1;

    public StoryAdapter(List<StoryList> mStories) {
        this.mStories = mStories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder=null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case IMAGE_STORY:
                viewHolder = new ImageViewHolder(inflater.inflate(R.layout.viewholder_image, parent, false));
                break;
            case VIDEO_STORY:
                viewHolder = new VideoViewHolder(inflater.inflate(R.layout.viewholder_video, parent, false));
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case IMAGE_STORY:
                configureImageViewHolder((ImageViewHolder) holder, position);
                break;
            case VIDEO_STORY:
                configureVideoViewHolder((VideoViewHolder) holder, position);
                break;
        }
    }

    private void configureVideoViewHolder(VideoViewHolder holder, int position) {
        holder.setVideoStatus(Uri.parse(mStories.get(position).src));
    }

    private void configureImageViewHolder(ImageViewHolder holder, int position) {
        Glide.with(holder.getImageStatus().getContext())
                .load(mStories.get(position).src)
                .into(holder.getImageStatus());
    }

    @Override
    public int getItemViewType(int position) {
        if(mStories.get(position).isVideo)
            return VIDEO_STORY;
        else
            return IMAGE_STORY;
    }

    @Override
    public int getItemCount() {
        return this.mStories.size();
    }
}
