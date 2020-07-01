package com.android.myapplication.dp_world.screen.pages.catalogue.components;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.adapter.CatalogueItem;

public abstract class CatalogueViewMvc extends BaseObservableViewMvc<CatalogueViewMvc.Listener> {


    public interface Listener {
        void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem);
        void onNavigateUpClicked();
    }
    public static class Props {
        protected final CatalogueItem[] designPatternCatalogueList;
        protected final DesignPattern designPattern;
        protected final CatalogueViewMvc.Listener listener;

        public Props(CatalogueItem[] designPatternCatalogueList,
                     DesignPattern designPattern,
                     CatalogueViewMvc.Listener listener) {
            this.designPatternCatalogueList = designPatternCatalogueList;
            this.designPattern = designPattern;
            this.listener = listener;
        }
    }
    protected Props mProps;
    public abstract void setProps(CatalogueViewMvcImpl.Props props);
}
