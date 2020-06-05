package com.android.myapplication.dp_world.screen.designpatternlist;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.designpattern.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.common.views.ScreensNavigator;
import com.android.myapplication.dp_world.screen.common.views.ToastHelper;

import java.util.List;

public class BaseDesignPatternsController implements DesignPatternViewMvc.Listener,
        FetchDesignPatternsUseCase.Listener {

    private String mFileName;
    private DesignPatternViewMvc mViewMvc;
    private final FetchDesignPatternsUseCase mFetchDesignPatternsUseCase;
    private final ToastHelper mToastHelper;
    private final ScreensNavigator mScreensNavigator;

    public BaseDesignPatternsController(FetchDesignPatternsUseCase fetchDesignPatternsUseCase,
                                        ToastHelper toastHelper,
                                        ScreensNavigator screensNavigator) {
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
        mFetchDesignPatternsUseCase.fetchDesignPatternsAndNotify(mFileName);
    }


    public void onStop() {
        mViewMvc.unregisterListener(this);
        mFetchDesignPatternsUseCase.unregisterListener(this);
    }

    @Override
    public void onDesignPatternClicked(DesignPattern designPattern) {
        mScreensNavigator.toCatalogueList(designPattern);
    }


    @Override
    public void onDesignPatternsFetched(List<DesignPattern> designPatterns) {
        mViewMvc.bindToolbarTitle(designPatterns.get(0).getCategory());
        mViewMvc.bindDesignPatterns(designPatterns);
    }

    @Override
    public void onDesignPatternsFetchFailed(String errorMessage) {
        mToastHelper.showUseCaseError();
    }


    public void bindDesignPatternFileName(String fileName) {
        mFileName = fileName;
    }
}
