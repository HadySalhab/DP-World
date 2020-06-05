package com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment;

import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListFragment;
import com.android.myapplication.dp_world.screen.designpatternlist.BaseDesignPatternsFragment;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(BaseDesignPatternsFragment baseDesignPatternsFragment);

    void inject(CatalogueListFragment catalogueListFragment);
}
