package com.github.gulzar1996.instastories.data.model;

/**
 * Created by gulza on 10/31/2017.
 */

public class StoryList {
    public String id;
    public boolean isVideo;
    public boolean seen;
    public int duration;
    public String src;
    public String preview;
    public String link;
    public String linkText;
    public long timestamp;
    //Test Constructor

    public StoryList(boolean isVideo, String src) {
        this.isVideo = isVideo;
        this.src = src;
    }
}
