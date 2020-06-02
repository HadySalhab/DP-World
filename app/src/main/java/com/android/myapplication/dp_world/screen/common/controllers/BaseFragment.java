package com.android.myapplication.dp_world.screen.common.controllers;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.myapplication.dp_world.common.dependencyinjection.presentation.activity.ActivityComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment.FragmentComponent;
import com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment.FragmentModule;

public class BaseFragment extends Fragment {
    private FragmentComponent mFragmentComponent;

    protected FragmentComponent getFragmentComponent() {
        if (mFragmentComponent == null) {
            mFragmentComponent = getActivityComponent().newFragmentComponent(new FragmentModule(this));
        }
        return mFragmentComponent;
    }

    private ActivityComponent getActivityComponent() {
        return ((BaseActivity) requireActivity()).getActivityComponent();
    }
}
