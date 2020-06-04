package com.android.myapplication.dp_world.common.dependencyinjection.presentation.fragment;

import android.content.Context;

import androidx.fragment.app.Fragment;

import com.android.myapplication.dp_world.designpattern.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.common.views.ScreensNavigator;
import com.android.myapplication.dp_world.screen.common.views.ToastHelper;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListController;
import com.android.myapplication.dp_world.screen.designpatternlist.BaseDesignPatternsController;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {
    private final Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    BaseDesignPatternsController getDesignPatternListController(FetchDesignPatternsUseCase fetchDesignPatternsUseCase,
                                                                ToastHelper toastHelper,
                                                                ScreensNavigator screensNavigator
    ) {
        return new BaseDesignPatternsController(fetchDesignPatternsUseCase, toastHelper, screensNavigator);
    }

    @Provides
    CatalogueListController getCatalogueListController(ScreensNavigator screensNavigator, Context context) {
        return new CatalogueListController(screensNavigator, context);
    }

}
