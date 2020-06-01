package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.navdrawer.BaseNavDrawerViewMvc;
import com.android.myapplication.dp_world.screen.common.navdrawer.DrawerItems;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;
import com.android.myapplication.dp_world.screen.common.views.ObservableViewMvc;

import java.util.List;

public abstract class DesignPatternViewMvc extends BaseNavDrawerViewMvc<DesignPatternViewMvc.Listener> {
    public DesignPatternViewMvc(LayoutInflater inflater, @Nullable ViewGroup parent) {
        super(inflater, parent);
    }
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
        void onStructrualDrawerItemClicked();
    }

    abstract void bindDesignPatterns(List<DesignPattern> designPatterns);
}
