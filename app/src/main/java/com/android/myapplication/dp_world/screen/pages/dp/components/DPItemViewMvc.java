package com.android.myapplication.dp_world.screen.pages.dp.components;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

public abstract class DPItemViewMvc extends BaseObservableViewMvc<DPItemViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    public abstract void bindDesignPattern(DesignPattern designPattern);
}
