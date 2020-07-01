package com.android.myapplication.dp_world.screen.pages.catalogue.components;

import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.adapter.CatalogueItem;

public abstract class CatalogueListItemViewMvc extends BaseObservableViewMvc<CatalogueListItemViewMvc.Listener> {
    public interface Listener {
        void onCatalogueItemClicked(CatalogueItem catalogueItem);
    }

    public abstract void bindCatalogueItem(CatalogueItem catalogueItem);
}
