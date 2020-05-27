package com.android.myapplication.dp_world.screen.designpatternlist;

import com.android.myapplication.dp_world.dp.DesignPattern;
import com.android.myapplication.dp_world.screen.common.BaseObservableViewMvc;
import java.util.List;

abstract class DesignPatternListViewMvc extends BaseObservableViewMvc<DesignPatternListViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    abstract void bindDesignPatterns(List<DesignPattern> designPatterns);
}
