package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.myapplication.dp_world.screen.common.controllers.BaseActivity;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;

import javax.inject.Inject;

public class CatalogueListActivity extends BaseActivity{
    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    CatalogueListController mCatalogueListController;
    private static final String DESIGN_PATTERN_ID = "DESIGN_PATTERN_ID";

    public static void start(Context context, int designPatternId) {
        Intent intent = new Intent(context, CatalogueListActivity.class);
        intent.putExtra(DESIGN_PATTERN_ID, designPatternId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);
        CatalogueViewMvc mViewMvc = mViewMvcFactory.getViewMvc(CatalogueViewMvc.class, null);
        mCatalogueListController.bindViewMvc(mViewMvc);
        mCatalogueListController.setDesignPatternId(getIntent().getIntExtra(DESIGN_PATTERN_ID, 0));
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mCatalogueListController.onStart();
    }


    @Override
    protected void onStop() {
        super.onStop();
        mCatalogueListController.onStop();
    }
}
