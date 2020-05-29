package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.catalogueitem.CatalogueListItemViewMvc;

public class CatalogueArrayAdapter extends ArrayAdapter<CatalogueItem> implements CatalogueListItemViewMvc.Listener {


    interface Listener {
        void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem);
    }

    private final Listener mListener;
    private final ViewMvcFactory mViewMvcFactory;

    public CatalogueArrayAdapter(@NonNull Context context, Listener listener, ViewMvcFactory viewMvcFactory) {
        super(context, 0);
        mListener = listener;
        mViewMvcFactory = viewMvcFactory;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            CatalogueListItemViewMvc viewMvc =
                    mViewMvcFactory.getViewMvc(CatalogueListItemViewMvc.class, parent);
            viewMvc.registerListener(this);
            convertView = viewMvc.getRootView();
            convertView.setTag(viewMvc);

        }
        final CatalogueItem catalogueItem = getItem(position);
        CatalogueListItemViewMvc viewMvc = (CatalogueListItemViewMvc) convertView.getTag();
        viewMvc.bindCatalogueItem(catalogueItem);
        return convertView;
    }

    @Override
    public void onCatalogueItemClicked(CatalogueItem catalogueItem) {
        mListener.onCatalogueItemClicked(catalogueItem);
    }
}
