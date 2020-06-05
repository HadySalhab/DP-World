package com.android.myapplication.dp_world.screen.common.navdrawer;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.myapplication.dp_world.R;
import com.google.android.material.navigation.NavigationView;

public class NavDrawerViewMvcImpl extends NavDrawerViewMvc {
    private final DrawerLayout mDrawerLayout;
    private final FrameLayout mFrameLayout;
    private final NavigationView mNavigationView;

    public NavDrawerViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_drawer, parent, false));
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mFrameLayout = findViewById(R.id.drawer_frame_placeholder);
        mNavigationView = findViewById(R.id.navView);
        mNavigationView.setCheckedItem(mNavigationView.getMenu().getItem(0));
        mNavigationView.setNavigationItemSelectedListener(item -> {
            mNavigationView.setCheckedItem(item);
            mDrawerLayout.closeDrawers();
            DrawerItems drawerItem = retrieveDrawerItemFromId(item.getItemId());
            notifyListenerOnDrawerItemClicked(drawerItem);
            return false;
        });
    }

    private void notifyListenerOnDrawerItemClicked(DrawerItems drawerItem) {
        for (Listener listener : getListeners()) {
            listener.onDrawerItemClicked(drawerItem);
        }
    }


    @Override
    public void lockDrawer() {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    @Override
    public void unlockDrawer() {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
    }

    @Override
    public boolean isDrawerOpen() {
        return mDrawerLayout.isDrawerOpen(GravityCompat.START);
    }

    @Override
    public void openDrawer() {
        mDrawerLayout.openDrawer(GravityCompat.START);
    }

    @Override
    public void closeDrawer() {
        mDrawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public int getFragmentPlaceHolderId() {
        return R.id.drawer_frame_placeholder;
    }

    private DrawerItems retrieveDrawerItemFromId(@IdRes int id) {
        switch (id) {
            case R.id.drawer_menu_creational:
                return DrawerItems.CREATIONAL;
            case R.id.drawer_menu_behavioral:
                return DrawerItems.BEHAVIORAL;
            case R.id.drawer_menu_structural:
                return DrawerItems.STRUCTURAL;
            default:
                throw new IllegalArgumentException("Can't Retrieve Drawer Item from the current Id");
        }
    }


}
