package com.android.myapplication.dp_world.screen.designpatternlist;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

import java.util.List;

public abstract class DesignPatternViewMvc extends BaseObservableViewMvc<DesignPatternViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    abstract public void bindDesignPatterns(List<DesignPattern> designPatterns);
}
