package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.View;

import com.android.myapplication.dp_world.dp.DesignPattern;

import java.util.List;

abstract class DesignPatternListViewMvc {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    abstract View getRootView();
    abstract void registerListener(Listener listener);
    abstract void unregisterListener(Listener listener);
    abstract void bindDesignPatterns(List<DesignPattern> designPatterns);
}
