package com.android.myapplication.dp_world.common.dependencyinjection.application;

import com.android.myapplication.dp_world.common.dependencyinjection.presentation.activity.ActivityComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.activity.ActivityModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    ActivityComponent newActivityComponent(ActivityModule activityModule);
}
