package com.android.myapplication.dp_world.screen.designpatternlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.BaseFragment;

import javax.inject.Inject;

public class DesignPatternListFragment  extends BaseFragment  {
    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    DesignPatternListController mDesignPatternListController;

    public static Fragment newInstance() {
        return new DesignPatternListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getFragmentComponent().inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

        DesignPatternViewMvc mViewMvc = mViewMvcFactory.getViewMvc(DesignPatternViewMvc.class, container);
        mDesignPatternListController.bindViewMvc(mViewMvc);
        return (mViewMvc.getRootView());
    }

    @Override
    public void onStart() {
        super.onStart();
        mDesignPatternListController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mDesignPatternListController.onStop();
    }
}
