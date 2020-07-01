package com.android.myapplication.dp_world.screen.pages.catalogue.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.controllers.BaseFragment;
import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueViewMvc;
import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;

import javax.inject.Inject;

public class CatalogueListFragment extends BaseFragment {
    private static final String DESIGN_PATTERN_OBJECT = "DESIGN_PATTERN_OBJECT";

    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    CatalogueListController mCatalogueListController;

    public static CatalogueListFragment newInstance(DesignPattern designPatternObj) {
        Bundle args = new Bundle();
        args.putParcelable(DESIGN_PATTERN_OBJECT, designPatternObj);
        CatalogueListFragment catalogueListFragment = new CatalogueListFragment();
        catalogueListFragment.setArguments(args);
        return catalogueListFragment;
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
        CatalogueViewMvc mViewMvc = mViewMvcFactory.getViewMvc(CatalogueViewMvc.class, container);
        mCatalogueListController.setViewMvc(mViewMvc);
        mCatalogueListController.setDP(getDesignPatternObj());
        return mViewMvc.getRootView();
    }

    private DesignPattern getDesignPatternObj() {
        return getArguments().getParcelable(DESIGN_PATTERN_OBJECT);
    }


    @Override
    public void onStart() {
        super.onStart();
        mCatalogueListController.onStart();
    }


    @Override
    public void onStop() {
        super.onStop();
        mCatalogueListController.onStop();
    }
}
