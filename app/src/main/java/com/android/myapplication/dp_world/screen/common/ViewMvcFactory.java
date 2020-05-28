package com.android.myapplication.dp_world.screen.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListItemViewMvc;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListItemViewMvcImpl;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListViewMvc;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListViewMvcImpl;

public class ViewMvcFactory {
    private final LayoutInflater mLayoutInflater;

    public ViewMvcFactory(LayoutInflater layoutInflater) {
        mLayoutInflater = layoutInflater;
    }

    public <T extends ViewMvc> T getViewMvc(Class<T> mvcViewClass, @Nullable ViewGroup parent) {

        ViewMvc viewMvc;

        if (mvcViewClass == DesignPatternListViewMvc.class) {
            viewMvc = new DesignPatternListViewMvcImpl(mLayoutInflater, parent, this);
        } else if (mvcViewClass == DesignPatternListItemViewMvc.class) {
            viewMvc = new DesignPatternListItemViewMvcImpl(mLayoutInflater, parent);
        } else {
            throw new IllegalArgumentException("unsupported MVC view class " + mvcViewClass);
        }

        //noinspection unchecked
        return (T) viewMvc;
    }
}
