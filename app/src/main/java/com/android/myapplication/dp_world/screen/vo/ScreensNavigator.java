package com.android.myapplication.dp_world.screen.vo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.android.myapplication.dp_world.common.Constants;
import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.controllers.FragmentFrameWrapper;
import com.android.myapplication.dp_world.screen.pages.catalogue.controller.CatalogueListFragment;
import com.android.myapplication.dp_world.screen.pages.dp.contoller.DPFragment;
import com.android.myapplication.dp_world.screen.pages.main.data.DrawerItems;
import com.ncapdevi.fragnav.FragNavController;


public class ScreensNavigator {
    private final FragmentManager mFragmentManager;
    private final FragmentFrameWrapper mFragmentFrameWrapper;
    private FragNavController mFragNavController;

    public ScreensNavigator(FragmentManager fragmentManager, FragmentFrameWrapper fragmentFrameWrapper) {
        mFragmentManager = fragmentManager;
        mFragmentFrameWrapper = fragmentFrameWrapper;
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
                    return DPFragment.newInstance(Constants.CREATIONAL_FILE_NAME);
                case FragNavController.TAB2:
                    return DPFragment.newInstance(Constants.BEHAVIORAL_FILE_NAME);
                case FragNavController.TAB3:
                    return DPFragment.newInstance(Constants.STRUCTURAL_FILE_NAME);
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

    public void toCatalogueList(DesignPattern designPattern) {
        mFragNavController.pushFragment(CatalogueListFragment.newInstance(designPattern));
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
