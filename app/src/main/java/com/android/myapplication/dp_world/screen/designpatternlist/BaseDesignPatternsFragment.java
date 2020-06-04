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

public class BaseDesignPatternsFragment extends BaseFragment  {
    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    BaseDesignPatternsController mBaseDesignPatternsController;
    public static final String DESIGN_PATTERN_FILE_NAME = "DESIGN_PATTERN_FILE_NAME";

    public static Fragment newInstance(String fileName) {
        Bundle bundle = new Bundle();
        bundle.putString(DESIGN_PATTERN_FILE_NAME,fileName);
        BaseDesignPatternsFragment baseDesignPatternsFragment =  new BaseDesignPatternsFragment();
        baseDesignPatternsFragment.setArguments(bundle);
        return baseDesignPatternsFragment;
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
        mBaseDesignPatternsController.bindViewMvc(mViewMvc);
        mBaseDesignPatternsController.bindDesignPatternFileName(getArguments().getString(DESIGN_PATTERN_FILE_NAME));
        return (mViewMvc.getRootView());
    }

    @Override
    public void onStart() {
        super.onStart();
        mBaseDesignPatternsController.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        mBaseDesignPatternsController.onStop();
    }
}
