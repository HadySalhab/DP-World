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

public class DesignPatternListActivity extends BaseActivity implements DesignPatternViewMvcImpl.Listener, FetchDesignPatternsUseCase.Listener {

    private DesignPatternViewMvc mViewMvc;
    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    FetchDesignPatternsUseCase mFetchDesignPatternsUseCase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);
        mViewMvc = mViewMvcFactory.getViewMvc(DesignPatternViewMvc.class, null);
        mViewMvc.registerListener(this);
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mFetchDesignPatternsUseCase.registerListener(this);
        mFetchDesignPatternsUseCase.fetchDesignPatternsAndNotify();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mFetchDesignPatternsUseCase.unregisterListener(this);
    }

    @Override
    public void onDesignPatternClicked(DesignPattern designPattern) {
        CatalogueListActivity.start(this, designPattern.getId());
    }

    @Override
    public void onDesignPatternsFetched(List<DesignPattern> designPatterns) {
        mViewMvc.bindDesignPatterns(designPatterns);
    }

    @Override
    public void onDesignPatternsFetchFailed(String errorMessage) {
        Toast.makeText(this, R.string.error_asset_read_failed, Toast.LENGTH_SHORT).show();
    }
}
