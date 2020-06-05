package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.BaseFragment;

import javax.inject.Inject;

public class CatalogueListFragment extends BaseFragment {
    private static final String DESIGN_PATTERN_ID = "DESIGN_PATTERN_ID";

    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    CatalogueListController mCatalogueListController;

    public static CatalogueListFragment newInstance(int designPatternId) {
        Bundle args = new Bundle();
        args.putInt(DESIGN_PATTERN_ID, designPatternId);
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
        mCatalogueListController.bindViewMvc(mViewMvc);
        mCatalogueListController.setDesignPatternId(getDesignPatternId());
        return mViewMvc.getRootView();
    }

    private int getDesignPatternId() {
        return getArguments().getInt(DESIGN_PATTERN_ID);
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
