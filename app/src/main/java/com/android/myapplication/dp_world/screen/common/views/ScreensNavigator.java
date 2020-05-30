package com.android.myapplication.dp_world.screen.common.views;

import android.content.Context;

import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListActivity;


public class ScreensNavigator {

    private final Context mContext;

    public ScreensNavigator(Context context) {
        mContext = context;
    }

    public void toCatalogueList(int designPatternId) {
        CatalogueListActivity.start(mContext, designPatternId);
    }
}
