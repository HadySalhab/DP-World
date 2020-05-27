package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.View;

import com.android.myapplication.dp_world.dp.DesignPattern;
import com.android.myapplication.dp_world.screen.common.ViewMvc;

abstract class DesignPatternListItemViewMvc implements ViewMvc {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    abstract void registerListener(Listener listener);
    abstract void unregisterListener(Listener listener);
    abstract void bindDesignPattern(DesignPattern designPattern);
}
