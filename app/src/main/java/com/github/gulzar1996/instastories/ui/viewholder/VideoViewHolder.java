package com.github.gulzar1996.instastories.ui.viewholder;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.github.gulzar1996.instastories.R;
import com.google.android.exoplayer2.ui.SimpleExoPlayerView;

import im.ene.toro.ToroPlayer;
import im.ene.toro.ToroUtil;
import im.ene.toro.exoplayer.SimpleExoPlayerViewHelper;
import im.ene.toro.media.PlaybackInfo;
import im.ene.toro.widget.Container;

/**
 * Created by gulza on 11/1/2017.
 */

public class VideoViewHolder extends RecyclerView.ViewHolder implements ToroPlayer {


    SimpleExoPlayerViewHelper helper;
    Uri mediaUri;
    SimpleExoPlayerView playerView;
    public VideoViewHolder(View itemView) {
        super(itemView);
        playerView=itemView.findViewById(R.id.player);
    }

    @NonNull @Override public View getPlayerView() {
        return playerView;
    }

    @NonNull @Override public PlaybackInfo getCurrentPlaybackInfo() {
        return helper != null ? helper.getLatestPlaybackInfo() : new PlaybackInfo();
    }

    @Override
    public void initialize(@NonNull Container container, @Nullable PlaybackInfo playbackInfo) {
        if (helper == null) {
            helper = new SimpleExoPlayerViewHelper(container, this, mediaUri);
        }
        helper.initialize(playbackInfo);
    }

    @Override public void play() {
        if (helper != null) helper.play();
    }

    @Override public void pause() {
        if (helper != null) helper.pause();
    }

    @Override public boolean isPlaying() {
        return helper != null && helper.isPlaying();
    }

    @Override public void release() {
        if (helper != null) {
            helper.release();
            helper = null;
        }
    }

    @Override public boolean wantsToPlay() {
        return ToroUtil.visibleAreaOffset(this, itemView.getParent()) >= 0.85;
    }

    @Override public void onContainerScrollStateChange(Container container, int newState) {
        // Do nothing
    }

    @Override public int getPlayerOrder() {
        return getAdapterPosition();
    }

    @Override public String toString() {
        return "ExoPlayer{" + hashCode() + " " + getAdapterPosition() + "}";
    }

    public void setVideoStatus(Uri mediaUri) {
        this.mediaUri = mediaUri;
    }
}
