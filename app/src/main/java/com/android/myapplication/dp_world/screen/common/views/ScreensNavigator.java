package com.android.myapplication.dp_world.screen.common.views;

import android.content.Context;
import android.util.Log;

import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListActivity;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListActivity;


public class ScreensNavigator {

    private final Context mContext;

    public ScreensNavigator(Context context) {
        mContext = context;
    }

    public void toCatalogueList(int designPatternId) {
        CatalogueListActivity.start(mContext, designPatternId);
    }

    public void navigateToDesignPatternListAndClearTop() {
        DesignPatternListActivity.startClearTop(mContext);
    }
}
