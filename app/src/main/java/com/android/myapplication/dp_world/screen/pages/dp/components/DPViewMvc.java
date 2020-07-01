package com.android.myapplication.dp_world.screen.pages.dp.components;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

import java.util.List;

public abstract class DPViewMvc extends BaseObservableViewMvc<DPViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    abstract public void bindDesignPatterns(List<DesignPattern> designPatterns);

    abstract public void bindToolbarTitle(String title);
}
