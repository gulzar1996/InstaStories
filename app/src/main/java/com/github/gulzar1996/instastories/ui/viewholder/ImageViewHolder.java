package com.github.gulzar1996.instastories.ui.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.github.gulzar1996.instastories.R;

/**
 * Created by gulza on 11/1/2017.
 */

public class ImageViewHolder extends RecyclerView.ViewHolder {

    ImageView imageStatus;
    public ImageViewHolder(View itemView) {
        super(itemView);
        imageStatus=itemView.findViewById(R.id.imageStatus);
    }
    public  ImageView getImageStatus()
    {
        return imageStatus;
    }

}
