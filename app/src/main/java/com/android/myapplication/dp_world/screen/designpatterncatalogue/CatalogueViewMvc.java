package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import com.android.myapplication.dp_world.screen.common.BaseObservableViewMvc;

public abstract class CatalogueViewMvc extends BaseObservableViewMvc<CatalogueViewMvc.Listener> {
    interface Listener {
        void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem);
    }

    abstract protected void bindCatalogueItem(CatalogueItem[] designPatternCatalogueList);
}