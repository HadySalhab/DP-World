package com.android.myapplication.dp_world.common.dependencyinjection.presentation.activity;

import com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment.FragmentComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment.FragmentModule;
import com.android.myapplication.dp_world.screen.common.main.MainActivity;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListFragment;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListFragment;

import dagger.Subcomponent;

@ActivityScope
@Subcomponent(modules = ActivityModule.class)
public interface ActivityComponent {
    FragmentComponent newFragmentComponent(FragmentModule fragmentModule);
    void inject(MainActivity mainActivity);
}
