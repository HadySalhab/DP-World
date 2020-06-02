package com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment;

import com.android.myapplication.dp_world.common.dependencyinjection.presentation.activity.ActivityScope;
import com.android.myapplication.dp_world.screen.common.main.MainActivity;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListFragment;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListFragment;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(DesignPatternListFragment designPatternListFragment);
    void inject(CatalogueListFragment catalogueListFragment);
}
