package com.android.myapplication.dp_world.screen.pages.main.components;

import com.android.myapplication.dp_world.screen.pages.main.data.DrawerItems;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

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
