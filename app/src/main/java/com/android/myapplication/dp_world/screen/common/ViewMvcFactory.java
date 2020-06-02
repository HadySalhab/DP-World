package com.android.myapplication.dp_world.screen.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.common.navdrawer.NavDrawerHelper;
import com.android.myapplication.dp_world.screen.common.navdrawer.NavDrawerViewMvc;
import com.android.myapplication.dp_world.screen.common.navdrawer.NavDrawerViewMvcImpl;
import com.android.myapplication.dp_world.screen.common.toolbar.ToolbarViewMvc;
import com.android.myapplication.dp_world.screen.common.views.ViewMvc;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.catalogueitem.CatalogueListItemViewMvc;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.catalogueitem.CatalogueListItemViewMvcImpl;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueViewMvc;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueViewMvcImpl;
import com.android.myapplication.dp_world.screen.designpatternlist.designpatternitem.DesignPatternListItemViewMvc;
import com.android.myapplication.dp_world.screen.designpatternlist.designpatternitem.DesignPatternListItemViewMvcImpl;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternViewMvc;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternViewMvcImpl;

public class ViewMvcFactory {
    private final LayoutInflater mLayoutInflater;
    private final NavDrawerHelper mNavDrawerHelper;

    public ViewMvcFactory(LayoutInflater layoutInflater, NavDrawerHelper navDrawerHelper) {
        mLayoutInflater = layoutInflater;
        mNavDrawerHelper = navDrawerHelper;
    }

    public <T extends ViewMvc> T getViewMvc(Class<T> mvcViewClass, @Nullable ViewGroup parent) {

        ViewMvc viewMvc;

        if (mvcViewClass == DesignPatternViewMvc.class) {
            viewMvc = new DesignPatternViewMvcImpl(mLayoutInflater, parent, mNavDrawerHelper, this);
        } else if (mvcViewClass == DesignPatternListItemViewMvc.class) {
            viewMvc = new DesignPatternListItemViewMvcImpl(mLayoutInflater, parent);
        } else if (mvcViewClass == CatalogueViewMvc.class) {
            viewMvc = new CatalogueViewMvcImpl(mLayoutInflater, parent, this);
        } else if (mvcViewClass == CatalogueListItemViewMvc.class) {
            viewMvc = new CatalogueListItemViewMvcImpl(mLayoutInflater, parent);
        } else if (mvcViewClass == ToolbarViewMvc.class) {
            viewMvc = new ToolbarViewMvc(mLayoutInflater, parent);
        } else if (mvcViewClass == NavDrawerViewMvc.class) {
            viewMvc = new NavDrawerViewMvcImpl(mLayoutInflater, parent);
        } else {
            throw new IllegalArgumentException("unsupported MVC view class " + mvcViewClass);
        }

        //noinspection unchecked
        return (T) viewMvc;
    }
}
