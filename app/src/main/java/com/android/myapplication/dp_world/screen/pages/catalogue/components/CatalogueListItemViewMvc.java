package com.android.myapplication.dp_world.screen.pages.catalogue.components;

import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.adapter.CatalogueItem;

public abstract class CatalogueListItemViewMvc extends BaseObservableViewMvc<CatalogueListItemViewMvc.Listener> {
    public interface Listener {
        void onCatalogueItemClicked();
    }

    public static class Props {
        protected final CatalogueItem catalogueItem;
        protected final Listener listener;

        public Props(CatalogueItem catalogueItem, Listener listener) {
            this.catalogueItem = catalogueItem;
            this.listener = listener;
        }
    }

    protected Props mProps;

    public abstract void setProps(Props props);
}
