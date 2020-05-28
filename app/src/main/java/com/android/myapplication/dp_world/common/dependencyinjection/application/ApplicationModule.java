package com.android.myapplication.dp_world.common.dependencyinjection.application;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Singleton
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application getApplication() {
        return mApplication;
    }

    @Provides
    Gson getGson() {
        return new Gson();
    }
}
