package com.android.myapplication.dp_world.common.dependencyinjection.presentation;

import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListActivity;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListFragment;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListActivity;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListFragment;

import dagger.Subcomponent;

@Subcomponent(modules = PresentationModule.class)
public interface PresentationComponent {
    void inject(DesignPatternListFragment designPatternListActivity);
    void inject(CatalogueListFragment designPatternCatalogueListActivity);
}
