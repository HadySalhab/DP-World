package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.android.myapplication.dp_world.screen.common.BaseActivity;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;

import javax.inject.Inject;

public class CatalogueListActivity extends BaseActivity implements CatalogueListViewMvc.Listener {
    @Inject
    ViewMvcFactory mViewMvcFactory;
    private CatalogueListViewMvc mViewMvc;
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
        mViewMvc = mViewMvcFactory.getViewMvc(CatalogueListViewMvc.class, null);
        mViewMvc.registerListener(this);
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        bindCatalogueItems();
    }
    private void bindCatalogueItems(){
        mViewMvc.bindCatalogueItem(CatalogueItem.values());
    }

    @Override
    public void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem) {
        Toast.makeText(this, "Catalogue Item Clicked: " + designPatternCatalogueListItem.getName(), Toast.LENGTH_SHORT).show();
    }
}
