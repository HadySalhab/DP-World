package com.android.myapplication.dp_world.screen.designpatternlist;

import android.os.Bundle;

import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.BaseActivity;

import javax.inject.Inject;

public class DesignPatternListActivity extends BaseActivity {

    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    DesignPatternListController mDesignPatternListController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);
        DesignPatternViewMvc mViewMvc = mViewMvcFactory.getViewMvc(DesignPatternViewMvc.class, null);
        mDesignPatternListController.bindViewMvc(mViewMvc);
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDesignPatternListController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mDesignPatternListController.onStop();
    }

    @Override
    public void onBackPressed() {
        if(!mDesignPatternListController.onBackPressed()){
           super.onBackPressed();
        }
    }
}
