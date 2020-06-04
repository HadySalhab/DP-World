package com.android.myapplication.dp_world.screen.common.navdrawer;

import androidx.annotation.IdRes;
import androidx.fragment.app.Fragment;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;
import com.ncapdevi.fragnav.FragNavController;

import java.util.ArrayList;
import java.util.Map;

public abstract class NavDrawerViewMvc extends BaseObservableViewMvc<NavDrawerViewMvc.Listener> {

    public interface Listener {
        void onDrawerItemClicked(DrawerItems item);
    }

    public abstract boolean isDrawerOpen();

    public abstract void openDrawer();

    public abstract void closeDrawer();

    public abstract void lockDrawer();

    public abstract void unlockDrawer();

    public abstract int getFragmentPlaceHolderId();
}
