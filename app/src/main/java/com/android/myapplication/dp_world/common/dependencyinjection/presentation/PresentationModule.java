package com.android.myapplication.dp_world.common.dependencyinjection.presentation;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.view.LayoutInflater;

import androidx.fragment.app.FragmentActivity;

import com.android.myapplication.dp_world.common.Constants;
import com.android.myapplication.dp_world.data.AssetStreamReader;
import com.android.myapplication.dp_world.data.JsonToGsonConverter;
import com.android.myapplication.dp_world.dp.FetchDesignPatternsUseCase;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.google.gson.Gson;
import com.techyourchance.threadposter.BackgroundThreadPoster;
import com.techyourchance.threadposter.UiThreadPoster;

import java.io.InputStream;

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

}
