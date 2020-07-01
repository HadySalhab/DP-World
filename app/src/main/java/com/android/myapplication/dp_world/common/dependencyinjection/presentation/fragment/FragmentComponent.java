package com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment;

import com.android.myapplication.dp_world.screen.pages.catalogue.controller.CatalogueListFragment;
import com.android.myapplication.dp_world.screen.pages.dp.contoller.DPFragment;

import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = FragmentModule.class)
public interface FragmentComponent {
    void inject(DPFragment DPFragment);

    void inject(CatalogueListFragment catalogueListFragment);
}
