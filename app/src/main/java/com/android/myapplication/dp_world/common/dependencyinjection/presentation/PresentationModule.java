package com.android.myapplication.dp_world.common.dependencyinjection.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;

import com.android.myapplication.dp_world.data.AssetStreamReader;
import com.android.myapplication.dp_world.data.JsonToGsonConverter;
import com.android.myapplication.dp_world.designpattern.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.views.ScreensNavigator;
import com.android.myapplication.dp_world.screen.common.views.ToastHelper;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListController;
import com.google.gson.Gson;
import com.techyourchance.threadposter.BackgroundThreadPoster;
import com.techyourchance.threadposter.UiThreadPoster;

import dagger.Module;
import dagger.Provides;

@Module
public class PresentationModule {
    private final FragmentActivity mActivity;

    public PresentationModule(FragmentActivity activity) {
        mActivity = activity;
    }

    @Provides
    LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    @Provides
    Activity getActivity() {
        return mActivity;
    }

    @Provides
    Context getContext(Activity activity) {
        return activity;
    }

    @Provides
    AssetManager getAssetManager(Activity activity) {
        return activity.getAssets();
    }

    @Provides
    ViewMvcFactory getViewMvcFactory(LayoutInflater layoutInflater) {
        return new ViewMvcFactory(layoutInflater);
    }

    @Provides
    AssetStreamReader getAssetStreamReader(AssetManager assetManager,
                                           BackgroundThreadPoster backgroundThreadPoster,
                                           UiThreadPoster uiThreadPoster) {
        return new AssetStreamReader(assetManager, backgroundThreadPoster, uiThreadPoster);
    }

    @Provides
    JsonToGsonConverter getJsonToGsonConverter(Gson gson) {
        return new JsonToGsonConverter(gson);
    }

    @Provides
    FetchDesignPatternsUseCase getFetchDesignPatternsUseCase(AssetStreamReader assetStreamReader,
                                                             JsonToGsonConverter jsonToGsonConverter) {
        return new FetchDesignPatternsUseCase(assetStreamReader, jsonToGsonConverter);
    }

    @Provides
    ToastHelper getToastHelper(Context context) {
        return new ToastHelper(context);
    }

    @Provides
    ScreensNavigator getScreensNavigator(Context context) {
        return new ScreensNavigator(context);
    }

    @Provides
    DesignPatternListController getDesignPatternListController(FetchDesignPatternsUseCase fetchDesignPatternsUseCase,
                                                               ToastHelper toastHelper,
                                                               ScreensNavigator screensNavigator
    ) {
        return new DesignPatternListController(fetchDesignPatternsUseCase, toastHelper, screensNavigator);
    }

}
