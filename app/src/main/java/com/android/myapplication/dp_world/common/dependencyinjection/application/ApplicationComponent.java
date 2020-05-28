package com.android.myapplication.dp_world.common.dependencyinjection.application;

import com.android.myapplication.dp_world.common.dependencyinjection.presentation.PresentationComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.PresentationModule;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    PresentationComponent newPresentationComponent(PresentationModule presentationModule);
}
