package com.android.myapplication.dp_world.screen.designpatterncatalogue.catalogueitem;

import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueItem;

public abstract class CatalogueListItemViewMvc extends BaseObservableViewMvc<CatalogueListItemViewMvc.Listener> {
    public interface Listener {
        void onCatalogueItemClicked(CatalogueItem catalogueItem);
    }

    public abstract void bindCatalogueItem(CatalogueItem catalogueItem);
}
