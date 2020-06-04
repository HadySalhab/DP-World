package com.android.myapplication.dp_world.designpattern;

import com.android.myapplication.dp_world.common.Constants;
import com.android.myapplication.dp_world.screen.common.navdrawer.DrawerItems;

public class FileNameDispatcher {

    public String getFileNameFor(DrawerItems items) {
        switch (items) {
            case BEHAVIORAL:
                return Constants.BEHAVIORAL_FILE_NAME;
            case CREATIONAL:
                return Constants.CREATIONAL_FILE_NAME;
            case STRUCTURAL:
                return Constants.STRUCTURAL_FILE_NAME;
            default:
                throw new IllegalArgumentException("No File Available For The Current DrawerItem");
        }
    }

}
