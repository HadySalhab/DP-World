package com.android.myapplication.dp_world.screen.vo;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.common.controllers.NavDrawerController;
import com.android.myapplication.dp_world.screen.common.views.ViewMvc;
import com.android.myapplication.dp_world.screen.layout.toolbar.ToolbarViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueListHeaderViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueListItemViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueListItemViewMvcImpl;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueViewMvcImpl;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPItemViewMvc;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPItemViewMvcImpl;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPViewMvc;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPViewMvcImpl;
import com.android.myapplication.dp_world.screen.pages.main.components.NavDrawerViewMvc;
import com.android.myapplication.dp_world.screen.pages.main.components.NavDrawerViewMvcImpl;

public class ViewMvcFactory {
    private final LayoutInflater mLayoutInflater;
    private final NavDrawerController mNavDrawerController;

    public ViewMvcFactory(LayoutInflater layoutInflater, NavDrawerController navDrawerHelper) {
        mLayoutInflater = layoutInflater;
        mNavDrawerController = navDrawerHelper;
    }

    public <T extends ViewMvc> T getViewMvc(Class<T> mvcViewClass, @Nullable ViewGroup parent) {

        ViewMvc viewMvc;
        if (DPViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new DPViewMvcImpl(mLayoutInflater, parent, mNavDrawerController, this);
        } else if (DPItemViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new DPItemViewMvcImpl(mLayoutInflater, parent);
        } else if (CatalogueViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new CatalogueViewMvcImpl(mLayoutInflater, parent, this);
        } else if (CatalogueListItemViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new CatalogueListItemViewMvcImpl(mLayoutInflater, parent);
        } else if (ToolbarViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new ToolbarViewMvc(mLayoutInflater, parent);
        } else if (NavDrawerViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new NavDrawerViewMvcImpl(mLayoutInflater, parent);
        } else if (CatalogueListHeaderViewMvc.class.equals(mvcViewClass)) {
            viewMvc = new CatalogueListHeaderViewMvc(mLayoutInflater, parent);
        } else {
            throw new IllegalArgumentException("unsupported MVC view class " + mvcViewClass);
        }
        return (T) viewMvc;
    }
}
