package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.View;

import com.android.myapplication.dp_world.dp.DesignPattern;

interface DesignPatternListItemViewMvc {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    void registerListener(Listener listener);
    void unregisterListener(Listener listener);
    View getRootView();
    void bindDesignPattern(DesignPattern designPattern);
}
