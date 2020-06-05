package com.android.myapplication.dp_world.screen.common.controllers;

import androidx.appcompat.app.AppCompatActivity;

import com.android.myapplication.dp_world.common.MyApplication;
import com.android.myapplication.dp_world.common.dependencyinjection.application.ApplicationComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.activity.ActivityComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.activity.ActivityModule;


public abstract class BaseActivity extends AppCompatActivity {
    private ActivityComponent mActivityComponent;

    protected ActivityComponent getActivityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = getApplicationComponent().newActivityComponent(new ActivityModule(this));
        }
        return mActivityComponent;
    }

    private ApplicationComponent getApplicationComponent() {
        return ((MyApplication) getApplication()).getApplicationComponent();
    }


}
