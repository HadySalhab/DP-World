package com.android.myapplication.dp_world.screen.common;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.common.navdrawer.NavDrawerController;
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
    private final NavDrawerController mNavDrawerController;

    public ViewMvcFactory(LayoutInflater layoutInflater, NavDrawerController navDrawerHelper) {
        mLayoutInflater = layoutInflater;
        mNavDrawerController = navDrawerHelper;
    }

    public <T extends ViewMvc> T getViewMvc(Class<T> mvcViewClass, @Nullable ViewGroup parent) {

        ViewMvc viewMvc;
        if (DesignPatternViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new DesignPatternViewMvcImpl(mLayoutInflater, parent, mNavDrawerController, this);
        } else if (DesignPatternListItemViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new DesignPatternListItemViewMvcImpl(mLayoutInflater, parent);
        } else if (CatalogueViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new CatalogueViewMvcImpl(mLayoutInflater, parent, this);
        } else if (CatalogueListItemViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new CatalogueListItemViewMvcImpl(mLayoutInflater, parent);
        } else if (ToolbarViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new ToolbarViewMvc(mLayoutInflater, parent);
        } else if (NavDrawerViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new NavDrawerViewMvcImpl(mLayoutInflater, parent);
        } else {
            throw new IllegalArgumentException("unsupported MVC view class " + mvcViewClass);
        }
        return (T) viewMvc;
    }
}
