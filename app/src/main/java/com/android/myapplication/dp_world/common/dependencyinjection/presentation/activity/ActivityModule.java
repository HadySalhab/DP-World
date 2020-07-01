package com.android.myapplication.dp_world.common.dependencyinjection.presentation.activity;

import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.android.myapplication.dp_world.actions.AssetStreamReader;
import com.android.myapplication.dp_world.actions.JsonToGsonConverter;
import com.android.myapplication.dp_world.actions.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.FragmentFrameWrapper;
import com.android.myapplication.dp_world.screen.common.controllers.NavDrawerController;
import com.android.myapplication.dp_world.screen.vo.ScreensNavigator;
import com.android.myapplication.dp_world.screen.vo.ToastHelper;
import com.google.gson.Gson;
import com.techyourchance.threadposter.BackgroundThreadPoster;
import com.techyourchance.threadposter.UiThreadPoster;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {
    private final FragmentActivity mActivity;

    public ActivityModule(FragmentActivity activity) {
        mActivity = activity;
    }

    @Provides
    LayoutInflater getLayoutInflater() {
        return LayoutInflater.from(mActivity);
    }

    @Provides
    FragmentActivity getActivity() {
        return mActivity;
    }

    @Provides
    FragmentManager getSupportFragmentManager(FragmentActivity activity) {
        return activity.getSupportFragmentManager();
    }

    @Provides
    FragmentFrameWrapper getFragmentFrameWrapper(FragmentActivity activity) {
        return (FragmentFrameWrapper) activity;
    }

    @Provides
    Context getContext(FragmentActivity activity) {
        return activity;
    }

    @Provides
    AssetManager getAssetManager(FragmentActivity activity) {
        return activity.getAssets();
    }

    @Provides
    NavDrawerController getNavDrawerHelper(FragmentActivity activity) {
        return (NavDrawerController) activity;
    }

    @Provides
    ViewMvcFactory getViewMvcFactory(LayoutInflater layoutInflater, NavDrawerController navDrawerHelper) {
        return new ViewMvcFactory(layoutInflater, navDrawerHelper);
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
    @ActivityScope
    ScreensNavigator getScreensNavigator(FragmentManager fragmentManager, FragmentFrameWrapper fragmentFrameWrapper) {
        return new ScreensNavigator(fragmentManager, fragmentFrameWrapper);
    }


}
