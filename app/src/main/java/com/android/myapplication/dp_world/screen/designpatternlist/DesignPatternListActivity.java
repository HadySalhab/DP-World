package com.android.myapplication.dp_world.screen.designpatternlist;

import android.os.Bundle;
import android.widget.Toast;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.designpattern.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.common.controllers.BaseActivity;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListActivity;

import java.util.List;

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
}
