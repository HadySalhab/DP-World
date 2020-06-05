package com.android.myapplication.dp_world.screen.common.controllers;

public interface BackPressDispatcher {
    void registerListener(BackPressListener listener);

    void unregisterListener(BackPressListener listener);
}
