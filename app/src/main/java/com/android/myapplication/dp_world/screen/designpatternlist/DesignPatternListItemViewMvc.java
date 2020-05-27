package com.android.myapplication.dp_world.screen.designpatternlist;

import com.android.myapplication.dp_world.dp.DesignPattern;
import com.android.myapplication.dp_world.screen.common.BaseObservableViewMvc;

abstract class DesignPatternListItemViewMvc extends BaseObservableViewMvc <DesignPatternListItemViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    abstract void bindDesignPattern(DesignPattern designPattern);
}
