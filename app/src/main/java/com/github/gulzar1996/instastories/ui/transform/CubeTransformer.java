package com.github.gulzar1996.instastories.ui.transform;

import android.support.v4.view.ViewPager;
import android.view.View;

/**
 * Created by gulza on 10/31/2017.
 */

public class CubeTransformer implements ViewPager.PageTransformer{

    @Override
    public void transformPage(View page, float position) {
        onPreTransform(page, position);
        onTransform(page, position);
    }

    private void onPreTransform(View page, float position) {
        page.setRotationX(0);
        page.setRotationY(0);
        page.setRotation(0);
        page.setScaleX(1);
        page.setScaleY(1);
        page.setPivotX(0);
        page.setPivotY(0);
        page.setTranslationY(0);
        page.setTranslationX(0f);
        //Hides Off screen page need to change it later
        page.setAlpha(position <= -1f || position >= 1f ? 0f : 1f);
        page.setEnabled(false);

    }

    private void onTransform(View page, float position) {
        page.setPivotX(position < 0f ? page.getWidth() : 0f);
        page.setPivotY(page.getHeight() * 0.5f);
        page.setRotationY(90f * position);
    }
}
