package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.View;

import com.android.myapplication.dp_world.dp.DesignPattern;
import com.android.myapplication.dp_world.screen.common.ObservableViewMvc;
import com.android.myapplication.dp_world.screen.common.ViewMvc;

abstract class DesignPatternListItemViewMvc implements ObservableViewMvc <DesignPatternListItemViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    abstract void bindDesignPattern(DesignPattern designPattern);
}
