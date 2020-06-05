package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

public abstract class CatalogueViewMvc extends BaseObservableViewMvc<CatalogueViewMvc.Listener> {


    interface Listener {
        void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem);

        void onNavigateUpClicked();
    }
    public abstract void bindDesignPattern(DesignPattern designPatternObj);
    abstract protected void bindCatalogueItem(CatalogueItem[] designPatternCatalogueList);
}
