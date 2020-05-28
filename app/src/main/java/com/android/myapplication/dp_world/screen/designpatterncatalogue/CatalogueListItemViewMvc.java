package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import com.android.myapplication.dp_world.screen.common.BaseObservableViewMvc;

public abstract class CatalogueListItemViewMvc extends BaseObservableViewMvc<CatalogueListItemViewMvc.Listener> {
    interface Listener {
        void onCatalogueItemClicked(CatalogueItem catalogueItem);
    }
    protected abstract void bindCatalogueItem(CatalogueItem catalogueItem);
}
