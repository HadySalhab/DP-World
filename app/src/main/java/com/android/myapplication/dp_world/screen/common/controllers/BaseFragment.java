package com.android.myapplication.dp_world.screen.common.controllers;

import androidx.fragment.app.Fragment;

import com.android.myapplication.dp_world.common.MyApplication;
import com.android.myapplication.dp_world.common.dependencyinjection.application.ApplicationComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.PresentationComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.PresentationModule;

public class BaseFragment extends Fragment {
    private boolean mIsInjectorUsed;

    protected PresentationComponent getPresentationComponent() {
        if (mIsInjectorUsed) {
            throw new RuntimeException("there is no need to use injector more than once");
        }
        mIsInjectorUsed = true;
        return getApplicationComponent().newPresentationComponent(new PresentationModule(requireActivity()));
    }

    private ApplicationComponent getApplicationComponent() {
        return ((MyApplication) requireActivity().getApplication()).getApplicationComponent();
    }
}
