package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.toolbar.ToolbarViewMvc;

public class CatalogueViewMvcImpl extends CatalogueViewMvc implements CatalogueArrayAdapter.Listener {
    private final ListView mListView;
    private final CatalogueArrayAdapter mAdapter;
    private final Toolbar mToolbar;
    private final ToolbarViewMvc mToolbarViewMvc;

    public CatalogueViewMvcImpl(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(layoutInflater.inflate(R.layout.layout_catalogue_list, parent, false));
        mListView = findViewById(R.id.list_catalogue);
        mAdapter = new CatalogueArrayAdapter(getContext(), this, viewMvcFactory);
        mListView.setAdapter(mAdapter);
        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvc(ToolbarViewMvc.class, mToolbar);
        initToolbar();
    }

    private void initToolbar() {
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.bindToolbarTextTitle("Catalogue");
        mToolbarViewMvc.enableUpButtonAndListen(new ToolbarViewMvc.NavigateUpClickListener() {
            @Override
            public void onNavigateUp() {
                for (CatalogueViewMvc.Listener listener : getListeners()) {
                    listener.onNavigateUpClicked();
                }
            }
        });
    }


    @Override
    public void bindCatalogueItem(CatalogueItem[] designPatternCatalogueList) {
        mAdapter.clear();
        mAdapter.addAll(designPatternCatalogueList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem) {
        for (CatalogueViewMvc.Listener listener : getListeners()) {
            listener.onCatalogueItemClicked(designPatternCatalogueListItem);
        }
    }
}
