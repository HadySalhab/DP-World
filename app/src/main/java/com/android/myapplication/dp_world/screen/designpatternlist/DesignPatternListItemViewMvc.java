package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.View;

import com.android.myapplication.dp_world.dp.DesignPattern;

abstract class DesignPatternListItemViewMvc {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    abstract void registerListener(Listener listener);
    abstract void unregisterListener(Listener listener);
    abstract View getRootView();
    abstract void bindDesignPattern(DesignPattern designPattern);
}
