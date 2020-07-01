package com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.android.myapplication.dp_world.actions.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.pages.catalogue.controller.CatalogueListController;
import com.android.myapplication.dp_world.screen.pages.dp.contoller.DPController;
import com.android.myapplication.dp_world.screen.vo.ScreensNavigator;
import com.android.myapplication.dp_world.screen.vo.ToastHelper;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private final Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    DPController getDesignPatternListController(FetchDesignPatternsUseCase fetchDesignPatternsUseCase,
                                                ToastHelper toastHelper,
                                                ScreensNavigator screensNavigator
    ) {
        return new DPController(fetchDesignPatternsUseCase, toastHelper, screensNavigator);
    }

    @Provides
    CatalogueListController getCatalogueListController(ScreensNavigator screensNavigator, Context context) {
        return new CatalogueListController(screensNavigator, context);
    }

}
