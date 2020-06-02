package com.android.myapplication.dp_world.screen.common.controllers;

import android.widget.FrameLayout;

import androidx.annotation.IdRes;

public interface FragmentFrameWrapper {
    //FrameLayout getFragmentPlaceHolder();
    @IdRes int getFragmentPlaceHolderId();
}
