package com.android.myapplication.dp_world.common.dependencyinjection.presentation;

import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListActivity;

import dagger.Subcomponent;

@Subcomponent(modules = PresentationModule.class)
public interface PresentationComponent {
    void inject(DesignPatternListActivity designPatternListActivity);
}
