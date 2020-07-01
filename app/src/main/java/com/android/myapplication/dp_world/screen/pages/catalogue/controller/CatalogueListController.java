package com.android.myapplication.dp_world.screen.pages.catalogue.controller;

import android.content.Context;
import android.widget.Toast;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.vo.ScreensNavigator;
import com.android.myapplication.dp_world.screen.pages.catalogue.adapter.CatalogueItem;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueViewMvc;

public class CatalogueListController implements CatalogueViewMvc.Listener {
    private DesignPattern mDesignPatternObj;
    private CatalogueViewMvc mViewMvc;
    private final ScreensNavigator mScreensNavigator;
    private final Context mContext;

    public CatalogueListController(ScreensNavigator screensNavigator, Context context) {
        mScreensNavigator = screensNavigator;
        mContext = context;
    }

    public void onStart() {
        mViewMvc.registerListener(this);
        bindCatalogueItems();
    }

    private void bindCatalogueItems() {
        mViewMvc.bindDesignPattern(mDesignPatternObj);
        mViewMvc.bindCatalogueItem(CatalogueItem.values());
    }


    public void onStop() {
        mViewMvc.unregisterListener(this);
    }

    @Override
    public void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem) {
        Toast.makeText(mContext, "Catalogue for:" + mDesignPatternObj.getTitle(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNavigateUpClicked() {
        mScreensNavigator.navigateUp();
    }

    public void setDesignPatternObj(DesignPattern designPatternObj) {
        mDesignPatternObj = designPatternObj;
    }

    public void bindViewMvc(CatalogueViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }
}
