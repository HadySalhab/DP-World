package com.android.myapplication.dp_world.screen.pages.dp.contoller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.BaseFragment;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPViewMvc;

import javax.inject.Inject;

public class DPFragment extends BaseFragment {
    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    DPController mDPController;
    public static final String DESIGN_PATTERN_FILE_NAME = "DESIGN_PATTERN_FILE_NAME";

    public static Fragment newInstance(String fileName) {
        Bundle bundle = new Bundle();
        bundle.putString(DESIGN_PATTERN_FILE_NAME, fileName);
        DPFragment DPFragment = new DPFragment();
        DPFragment.setArguments(bundle);
        return DPFragment;
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
        DPViewMvc mViewMvc = mViewMvcFactory.getViewMvc(DPViewMvc.class, container);
        mDPController.setViewMvc(mViewMvc);
        mDPController.setFileName(getArguments().getString(DESIGN_PATTERN_FILE_NAME));
        return (mViewMvc.getRootView());
    }

    @Override
    public void onStart() {
        super.onStart();
        mDPController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mDPController.onStop();
    }
}
