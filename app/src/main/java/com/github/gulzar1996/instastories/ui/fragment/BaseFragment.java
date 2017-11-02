package com.github.gulzar1996.instastories.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;
import android.support.v4.BuildConfig;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by gulza on 11/2/2017.
 */

public class BaseFragment extends Fragment {

    private static final boolean D = true;


    protected String TAG = "Toro:" + getClass().getSimpleName();

    public static final String RESULT_EXTRA_PLAYER_ORDER = "toro:demo:player:result:order";
    public static final String RESULT_EXTRA_PLAYBACK_INFO = "toro:demo:player:result:playback";

    @Override public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (D) Log.d(TAG, "onCreate() called with: bundle = [" + bundle + "]");
    }

    @Override public void onAttach(Context context) {
        super.onAttach(context);
        if (D) Log.d(TAG, "onAttach() called with: context = [" + context + "]");
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle bundle) {
        if (D) {
            Log.d(TAG, "onCreateView() called with: inflater = ["
                    + inflater
                    + "], container = ["
                    + container
                    + "], bundle = ["
                    + bundle
                    + "]");
        }
        return super.onCreateView(inflater, container, bundle);
    }

    @CallSuper
    @Override public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (D) {
            Log.d(TAG, "onViewCreated() called with: view = [" + view + "], bundle = [" + bundle + "]");
        }

    }

    @Override public void onActivityCreated(@Nullable Bundle bundle) {
        super.onActivityCreated(bundle);
        if (D) Log.d(TAG, "onActivityCreated() called with: bundle = [" + bundle + "]");
    }

    @Override public void onViewStateRestored(@Nullable Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (D) Log.d(TAG, "onViewStateRestored() called with: bundle = [" + bundle + "]");
    }

    @Override public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (D) Log.d(TAG, "onSaveInstanceState() called with: outState = [" + outState + "]");
    }

    @Override public void onStart() {
        super.onStart();
        if (D) Log.d(TAG, "onStart() called");
    }

    @Override public void onResume() {
        super.onResume();
        if (D) Log.d(TAG, "onResume() called");
    }

    @Override public void onPause() {
        super.onPause();
        if (D) Log.d(TAG, "onPause() called");
    }

    @Override public void onStop() {
        super.onStop();
        if (D) Log.d(TAG, "onStop() called");
    }

    @Override public void onDestroyView() {
        super.onDestroyView();
        if (D) Log.d(TAG, "onDestroyView() called");
    }

    @Override public void onDetach() {
        super.onDetach();
        if (D) Log.d(TAG, "onDetach() called");
    }

    @Override public void onDestroy() {
        super.onDestroy();
        if (D) Log.d(TAG, "onDestroy() called");
    }

    @Override public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        if (D) {
            Log.d(TAG, "onMultiWindowModeChanged() called with: isInMultiWindowMode = ["
                    + isInMultiWindowMode
                    + "]");
        }
    }

    @Override public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode) {
        super.onPictureInPictureModeChanged(isInPictureInPictureMode);
        if (D) {
            Log.d(TAG, "onPictureInPictureModeChanged() called with: isInPictureInPictureMode = ["
                    + isInPictureInPictureMode
                    + "]");
        }
    }

    @Override public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (D) {
            Log.d(TAG, "onActivityResult() called with: requestCode = ["
                    + requestCode
                    + "], resultCode = ["
                    + resultCode
                    + "], data = ["
                    + data
                    + "]");
        }
    }

    @Override public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        if (D) Log.d(TAG, "onAttachFragment() called with: childFragment = [" + childFragment + "]");
    }

    @Override public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (D) {
            Log.d(TAG, "setUserVisibleHint() called with: isVisibleToUser = [" + isVisibleToUser + "]");
        }
    }
}

