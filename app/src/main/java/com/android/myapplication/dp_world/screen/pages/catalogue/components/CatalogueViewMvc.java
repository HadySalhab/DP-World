package com.android.myapplication.dp_world.screen.pages.catalogue.components;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.adapter.CatalogueItem;

public abstract class CatalogueViewMvc extends BaseObservableViewMvc<CatalogueViewMvc.Listener> {


   public interface Listener {
        void onCatalogueItemClicked(CatalogueItem designPatternCatalogueListItem);

        void onNavigateUpClicked();
    }
    public abstract void bindDesignPattern(DesignPattern designPatternObj);
    abstract public void bindCatalogueItem(CatalogueItem[] designPatternCatalogueList);
}
