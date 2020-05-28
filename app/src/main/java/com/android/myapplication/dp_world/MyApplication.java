package com.android.myapplication.dp_world;

import android.app.Application;

import com.android.myapplication.dp_world.common.dependencyinjection.application.ApplicationComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.application.ApplicationModule;
import com.android.myapplication.dp_world.common.dependencyinjection.application.DaggerApplicationComponent;

public class MyApplication extends Application {
    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mApplicationComponent;
    }
}
