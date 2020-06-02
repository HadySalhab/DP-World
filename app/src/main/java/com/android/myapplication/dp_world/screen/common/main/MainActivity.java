package com.android.myapplication.dp_world.screen.common.main;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.BackPressListener;
import com.android.myapplication.dp_world.screen.common.controllers.BaseActivity;
import com.android.myapplication.dp_world.screen.common.controllers.FragmentFrameWrapper;
import com.android.myapplication.dp_world.screen.common.navdrawer.NavDrawerHelper;
import com.android.myapplication.dp_world.screen.common.navdrawer.NavDrawerViewMvc;
import com.android.myapplication.dp_world.screen.common.views.ScreensNavigator;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

public class MainActivity extends BaseActivity implements
        FragmentFrameWrapper,
        NavDrawerHelper,
        NavDrawerViewMvc.Listener {

    private final Set<BackPressListener> mBackPressedListeners = new HashSet<>();
    private NavDrawerViewMvc mViewMvc;

    @Inject
    ScreensNavigator mScreensNavigator;
    @Inject
    ViewMvcFactory mViewMvcFactory;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivityComponent().inject(this);
        mViewMvc = mViewMvcFactory.getViewMvc(NavDrawerViewMvc.class, null);
        setContentView(mViewMvc.getRootView());
        mScreensNavigator.init(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        mScreensNavigator.onSaveInstanceState(saveInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mViewMvc.registerListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mViewMvc.unregisterListener(this);
    }

    @Override
    public void onBackPressed() {
        if (isDrawerOpen()) {
            closeDrawer();
        } else if (!mScreensNavigator.navigateBack()) {
            super.onBackPressed();
        }
    }

    @Override
    public int getFragmentPlaceHolderId() {
        return mViewMvc.getFragmentPlaceHoldeId();
    }

    @Override
    public void onStructuralItemClicked() {

    }

    @Override
    public void openDrawer() {
        mViewMvc.openDrawer();
    }

    @Override
    public void closeDrawer() {
        mViewMvc.closeDrawer();
    }

    @Override
    public boolean isDrawerOpen() {
        return mViewMvc.isDrawerOpen();
    }
}
