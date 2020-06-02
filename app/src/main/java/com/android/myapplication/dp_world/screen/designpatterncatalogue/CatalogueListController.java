package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.content.Context;
import android.widget.Toast;

import com.android.myapplication.dp_world.screen.common.views.ScreensNavigator;

public class CatalogueListController implements CatalogueViewMvc.Listener {
    private int mDesignPatternId;
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
        mViewMvc.bindCatalogueItem(CatalogueItem.values());
    }


    public void onStop() {
        mViewMvc.unregisterListener(this);
    }

    @Override
    public void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem) {
        Toast.makeText(mContext,"Catalogue for:"+mDesignPatternId,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNavigateUpClicked() {
        mScreensNavigator.navigateUp();
    }

    public void setDesignPatternId(int designPatternId) {
        mDesignPatternId = designPatternId;
    }

    public void bindViewMvc(CatalogueViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }
}
