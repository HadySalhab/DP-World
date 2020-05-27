package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.View;

import com.android.myapplication.dp_world.dp.DesignPattern;

import java.util.List;

interface DesignPatternListViewMvc {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
     View getRootView();

    void registerListener(Listener listener);

    void unregisterListener(Listener listener);

    void bindDesignPatterns(List<DesignPattern> designPatterns);

}
