package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.navdrawer.NavDrawerViewMvcImpl;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

import java.util.List;

public abstract class DesignPatternViewMvc extends BaseObservableViewMvc<DesignPatternViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    abstract void bindDesignPatterns(List<DesignPattern> designPatterns);
}
