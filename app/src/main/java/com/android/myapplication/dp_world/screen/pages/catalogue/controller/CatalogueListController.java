package com.android.myapplication.dp_world.screen.pages.catalogue.controller;

import android.content.Context;
import android.widget.Toast;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.pages.catalogue.adapter.CatalogueItem;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueViewMvcImpl;
import com.android.myapplication.dp_world.screen.vo.ScreensNavigator;

public class CatalogueListController {
    private DesignPattern mDesignPatternObj;
    private CatalogueViewMvc mViewMvc;
    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;
    private final CatalogueViewMvc.Listener callback = new CatalogueViewMvc.Listener() {
        @Override
        public void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem) {
            Toast.makeText(mContext, "Catalogue for:" + mDesignPatternObj.getTitle(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onNavigateUpClicked() {
            mScreensNavigator.navigateUp();
        }
    };

    public CatalogueListController(ScreensNavigator screensNavigator, Context context) {
        mScreensNavigator = screensNavigator;
        mContext = context;
    }

    public void onStart() {
        mViewMvc.setProps(new CatalogueViewMvcImpl.Props(CatalogueItem.values(), mDesignPatternObj, callback));
    }

    public void onStop() {
        mViewMvc.setProps(new CatalogueViewMvcImpl.Props(CatalogueItem.values(), mDesignPatternObj, null));
    }

    public void setDP(DesignPattern designPattern) {
        mDesignPatternObj = designPattern;
    }

    public void setViewMvc(CatalogueViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }
}
