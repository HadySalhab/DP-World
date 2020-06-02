package com.android.myapplication.dp_world.screen.designpatternlist;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.designpattern.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.common.controllers.BackPressDispatcher;
import com.android.myapplication.dp_world.screen.common.controllers.BackPressListener;
import com.android.myapplication.dp_world.screen.common.views.ScreensNavigator;
import com.android.myapplication.dp_world.screen.common.views.ToastHelper;

import java.util.List;

public class DesignPatternListController implements DesignPatternViewMvc.Listener,
        FetchDesignPatternsUseCase.Listener{

    private DesignPatternViewMvc mViewMvc;
    private final FetchDesignPatternsUseCase mFetchDesignPatternsUseCase;
    private final ToastHelper mToastHelper;
    private final ScreensNavigator mScreensNavigator;

    public DesignPatternListController(FetchDesignPatternsUseCase fetchDesignPatternsUseCase,
                                       ToastHelper toastHelper, ScreensNavigator screensNavigator) {
        mFetchDesignPatternsUseCase = fetchDesignPatternsUseCase;
        mToastHelper = toastHelper;
        mScreensNavigator = screensNavigator;
    }

    public void bindViewMvc(DesignPatternViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void onStart() {
        mViewMvc.registerListener(this);
        mFetchDesignPatternsUseCase.registerListener(this);
        mFetchDesignPatternsUseCase.fetchDesignPatternsAndNotify();
    }

    public void onStop() {
        mViewMvc.unregisterListener(this);
        mFetchDesignPatternsUseCase.unregisterListener(this);
    }

    @Override
    public void onDesignPatternClicked(DesignPattern designPattern) {
        mScreensNavigator.toCatalogueList(designPattern.getId());
    }


    @Override
    public void onDesignPatternsFetched(List<DesignPattern> designPatterns) {
        mViewMvc.bindDesignPatterns(designPatterns);
    }

    @Override
    public void onDesignPatternsFetchFailed(String errorMessage) {
        mToastHelper.showUseCaseError();
    }


}
