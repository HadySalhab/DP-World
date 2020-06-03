package com.android.myapplication.dp_world.screen.common.views;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.android.myapplication.dp_world.screen.common.controllers.FragmentFrameWrapper;
import com.android.myapplication.dp_world.screen.designpatterncatalogue.CatalogueListFragment;
import com.android.myapplication.dp_world.screen.designpatternlist.DesignPatternListFragment;
import com.ncapdevi.fragnav.FragNavController;

import java.util.ArrayList;
import java.util.List;


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
            return 1;
        }

        @NonNull
        @Override
        public Fragment getRootFragment(int index) {
            switch (index) {
                case FragNavController.TAB1:
                    return DesignPatternListFragment.newInstance();
                default:
                    throw new IllegalStateException("unsupported tab index: " + index);
            }
        }
    };

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

    public void toDesignPatternList() {
        mFragNavController.pushFragment(DesignPatternListFragment.newInstance());
    }

    public void navigateUp() {
        mFragNavController.popFragment();
    }

    public void toHome() {
        mFragNavController.clearStack();
        mFragNavController.pushFragment(DesignPatternListFragment.newInstance());
    }

    public boolean canScreensNavigatorHandleBackPress() {
        if (mFragNavController.isRootFragment()) {
            return false;
        } else {
            return true;
        }
    }

    public void handleBackPress() {
        mFragNavController.popFragment();
    }
}
