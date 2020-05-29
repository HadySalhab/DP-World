package com.android.myapplication.dp_world.screen.designpatternlist.designpatternitem;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

public abstract class DesignPatternListItemViewMvc extends BaseObservableViewMvc <DesignPatternListItemViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    public abstract void bindDesignPattern(DesignPattern designPattern);
}
