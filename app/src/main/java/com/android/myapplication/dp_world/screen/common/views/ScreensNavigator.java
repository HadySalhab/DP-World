package com.android.myapplication.dp_world.screen.common.views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.android.myapplication.dp_world.designpattern.FileNameDispatcher;
import com.android.myapplication.dp_world.screen.common.controllers.FragmentFrameWrapper;
import com.android.myapplication.dp_world.screen.common.navdrawer.DrawerItems;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListFragment;
import com.android.myapplication.dp_world.screen.designpatternlist.BaseDesignPatternsFragment;
import com.ncapdevi.fragnav.FragNavController;


public class ScreensNavigator {
    private final FragmentManager mFragmentManager;
    private final FragmentFrameWrapper mFragmentFrameWrapper;
    private FragNavController mFragNavController;
    private final FileNameDispatcher mFileNameDispatcher;

    public ScreensNavigator(FragmentManager fragmentManager, FragmentFrameWrapper fragmentFrameWrapper, FileNameDispatcher fileNameDispatcher) {
        mFragmentManager = fragmentManager;
        mFragmentFrameWrapper = fragmentFrameWrapper;
        mFileNameDispatcher = fileNameDispatcher;
    }


    private final FragNavController.RootFragmentListener mRootFragmentListener = new FragNavController.RootFragmentListener() {
        @Override
        public int getNumberOfRootFragments() {
            return 3;
        }

        @NonNull
        @Override
        public Fragment getRootFragment(int index) {
            switch (index) {
                case FragNavController.TAB1:
                    return BaseDesignPatternsFragment.newInstance(mFileNameDispatcher.getFileNameFor(DrawerItems.CREATIONAL));
                case FragNavController.TAB2:
                    return BaseDesignPatternsFragment.newInstance(mFileNameDispatcher.getFileNameFor(DrawerItems.BEHAVIORAL));
                case FragNavController.TAB3:
                    return BaseDesignPatternsFragment.newInstance(mFileNameDispatcher.getFileNameFor(DrawerItems.STRUCTURAL));
                default:
                    throw new IllegalStateException("unsupported tab index: " + index);
            }
        }
    };

    public void switchTab(DrawerItems item) {
        switch (item) {
            case CREATIONAL:
                mFragNavController.switchTab(0);
                break;
            case BEHAVIORAL:
                mFragNavController.switchTab(1);
                break;
            case STRUCTURAL:
                mFragNavController.switchTab(2);
                break;
        }
    }

    public void init(Bundle savedInstanceState) {
        mFragNavController = new FragNavController(mFragmentManager, mFragmentFrameWrapper.getFragmentPlaceHolderId());
        mFragNavController.setRootFragmentListener(mRootFragmentListener);
        mFragNavController.initialize(FragNavController.TAB1, savedInstanceState);
    }

    public void onSaveInstanceState(Bundle saveInstanceState) {
        mFragNavController.onSaveInstanceState(saveInstanceState);
    }

    public void toCatalogueList(int designPatternId) {
        mFragNavController.pushFragment(CatalogueListFragment.newInstance(designPatternId));
    }

    public void navigateUp() {
        mFragNavController.popFragment();
    }

    public boolean canScreensNavigatorHandleBackPress() {
        return !mFragNavController.isRootFragment();
    }

    public void handleBackPress() {
        mFragNavController.popFragment();
    }
}
