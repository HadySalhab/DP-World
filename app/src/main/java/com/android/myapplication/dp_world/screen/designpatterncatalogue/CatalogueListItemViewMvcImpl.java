package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;

public class CatalogueListItemViewMvcImpl extends CatalogueListItemViewMvc {
    private CatalogueItem mCatalogueItem;
    private final TextView mTextView;

    public CatalogueListItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_catalogue_list_item, parent, false));
        mTextView = findViewById(R.id.text_catalogue_name);
        getRootView().setOnClickListener((v -> {
            for (Listener listener : getListeners()) {
                listener.onCatalogueItemClicked(mCatalogueItem);
            }
        }));
    }

    @Override
    protected void bindCatalogueItem(CatalogueItem catalogueItem) {
        mCatalogueItem = catalogueItem;
        mTextView.setText(mCatalogueItem.getName());
    }
}
