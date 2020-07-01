package com.android.myapplication.dp_world.screen.pages.dp.contoller;

import com.android.myapplication.dp_world.actions.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPViewMvc;
import com.android.myapplication.dp_world.screen.vo.ScreensNavigator;
import com.android.myapplication.dp_world.screen.vo.ToastHelper;

import java.util.ArrayList;
import java.util.List;

public class DPController implements
        FetchDesignPatternsUseCase.Listener {

    private String mFileName;
    private DPViewMvc mViewMvc;
    private final FetchDesignPatternsUseCase mFetchDesignPatternsUseCase;
    private final ToastHelper mToastHelper;
    private final ScreensNavigator mScreensNavigator;
    private final DPViewMvc.Listener callback = new DPViewMvc.Listener() {
        @Override
        public void onDesignPatternClicked(DesignPattern designPattern) {
            mScreensNavigator.toCatalogueList(designPattern);
        }
    };

    private final List<DesignPattern> designPatterns = new ArrayList<>();

    public DPController(FetchDesignPatternsUseCase fetchDesignPatternsUseCase,
                        ToastHelper toastHelper,
                        ScreensNavigator screensNavigator) {
        mFetchDesignPatternsUseCase = fetchDesignPatternsUseCase;
        mToastHelper = toastHelper;
        mScreensNavigator = screensNavigator;

    }

    public void setViewMvc(DPViewMvc viewMvc) {
        mViewMvc = viewMvc;
    }

    public void setFileName(String fileName) {
        mFileName = fileName;
    }

    public void onStart() {
        mViewMvc.setProps(new DPViewMvc.Props(designPatterns, callback));
        mFetchDesignPatternsUseCase.registerListener(this);
        mFetchDesignPatternsUseCase.fetchDesignPatternsAndNotify(mFileName);
    }


    public void onStop() {
        mViewMvc.setProps(new DPViewMvc.Props(designPatterns, null));
        mFetchDesignPatternsUseCase.unregisterListener(this);
    }

    @Override
    public void onDesignPatternsFetched(List<DesignPattern> designPatterns) {
        mViewMvc.setProps(new DPViewMvc.Props(designPatterns, callback));
    }

    @Override
    public void onDesignPatternsFetchFailed(String errorMessage) {
        mToastHelper.showUseCaseError();
    }


}
