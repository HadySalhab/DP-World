package com.android.myapplication.dp_world.screen.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListItemViewMvc;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListItemViewMvcImpl;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListViewMvc;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListViewMvcImpl;
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
        } else if (mvcViewClass == CatalogueListViewMvc.class) {
            viewMvc = new CatalogueListViewMvcImpl(mLayoutInflater, parent, this);
        } else if (mvcViewClass == CatalogueListItemViewMvc.class) {
            viewMvc = new CatalogueListItemViewMvcImpl(mLayoutInflater, parent);
        } else {
            throw new IllegalArgumentException("unsupported MVC view class " + mvcViewClass);
        }

        //noinspection unchecked
        return (T) viewMvc;
    }
}
