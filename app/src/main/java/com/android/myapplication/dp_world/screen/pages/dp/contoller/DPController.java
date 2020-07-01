package com.android.myapplication.dp_world.screen.pages.dp.contoller;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.actions.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.vo.ScreensNavigator;
import com.android.myapplication.dp_world.screen.vo.ToastHelper;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPViewMvc;

import java.util.List;

public class DPController implements DPViewMvc.Listener,
        FetchDesignPatternsUseCase.Listener {

    private String mFileName;
    private DPViewMvc mViewMvc;
    private final FetchDesignPatternsUseCase mFetchDesignPatternsUseCase;
    private final ToastHelper mToastHelper;
    private final ScreensNavigator mScreensNavigator;

    public DPController(FetchDesignPatternsUseCase fetchDesignPatternsUseCase,
                        ToastHelper toastHelper,
                        ScreensNavigator screensNavigator) {
        mFetchDesignPatternsUseCase = fetchDesignPatternsUseCase;
        mToastHelper = toastHelper;
        mScreensNavigator = screensNavigator;
    }

    public void bindViewMvc(DPViewMvc viewMvc) {
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
