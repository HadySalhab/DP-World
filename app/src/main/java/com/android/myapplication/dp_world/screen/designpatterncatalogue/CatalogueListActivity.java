package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.myapplication.dp_world.screen.common.controllers.BaseActivity;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;

import javax.inject.Inject;

public class CatalogueListActivity extends BaseActivity implements CatalogueViewMvc.Listener {
    @Inject
    ViewMvcFactory mViewMvcFactory;
    private CatalogueViewMvc mViewMvc;
    private static final String DESIGN_PATTERN_ID = "DESIGN_PATTERN_ID";
    private int dpId ;
    public static void start(Context context, int designPatternId) {
        Intent intent = new Intent(context, CatalogueListActivity.class);
        intent.putExtra(DESIGN_PATTERN_ID, designPatternId);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);
        mViewMvc = mViewMvcFactory.getViewMvc(CatalogueViewMvc.class, null);

        dpId = getIntent().getIntExtra(DESIGN_PATTERN_ID,0);
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.registerListener(this);
        bindCatalogueItems();
    }
    private void bindCatalogueItems(){
        mViewMvc.bindCatalogueItem(CatalogueItem.values());
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewMvc.unregisterListener(this);
    }

    @Override
    public void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem) {
        Toast.makeText(this, "Catalogue : " + designPatternCatalogueListItem.getName() +", for: "+dpId, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNavigateUpClicked() {
        onBackPressed();
    }
}
