package com.android.myapplication.dp_world.screen.designpatternlist;

import com.android.myapplication.dp_world.dp.DesignPattern;
import com.android.myapplication.dp_world.screen.common.BaseViewMvc;
import com.android.myapplication.dp_world.screen.common.ObservableViewMvc;
import java.util.List;

abstract class DesignPatternListViewMvc extends BaseViewMvc implements ObservableViewMvc<DesignPatternListViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    abstract void bindDesignPatterns(List<DesignPattern> designPatterns);
}
