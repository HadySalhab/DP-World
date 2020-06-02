package com.android.myapplication.dp_world.screen.designpatternlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.BackPressedListener;
import com.android.myapplication.dp_world.screen.common.controllers.BaseFragment;

import javax.inject.Inject;

public class DesignPatternListFragment  extends BaseFragment implements BackPressedListener {
    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    DesignPatternListController mDesignPatternListController;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        getPresentationComponent().inject(this);
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

    @Override
    public boolean onBackPressed() {
      return mDesignPatternListController.onBackPressed();
    }
}
