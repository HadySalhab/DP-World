package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.View;

import com.android.myapplication.dp_world.dp.DesignPattern;
import com.android.myapplication.dp_world.screen.common.ViewMvc;

import java.util.List;

abstract class DesignPatternListViewMvc implements ViewMvc {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    abstract void registerListener(Listener listener);
    abstract void unregisterListener(Listener listener);
    abstract void bindDesignPatterns(List<DesignPattern> designPatterns);
}
