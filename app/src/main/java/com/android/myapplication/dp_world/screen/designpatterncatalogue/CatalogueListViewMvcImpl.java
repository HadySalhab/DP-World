package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;

public class CatalogueListViewMvcImpl extends CatalogueListViewMvc implements CatalogueArrayAdapter.Listener {
    private final ListView mListView;
    private final CatalogueArrayAdapter mAdapter;

    public CatalogueListViewMvcImpl(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(layoutInflater.inflate(R.layout.layout_catalogue_list, parent, false));
        mListView = findViewById(R.id.list_catalogue);
        mAdapter = new CatalogueArrayAdapter(getContext(), this, viewMvcFactory);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void bindCatalogueItem(CatalogueItem[] designPatternCatalogueList) {
        mAdapter.clear();
        mAdapter.addAll(designPatternCatalogueList);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem) {
        for (CatalogueListViewMvc.Listener listener : getListeners()) {
            listener.onCatalogueItemClicked(designPatternCatalogueListItem);
        }
    }
}
