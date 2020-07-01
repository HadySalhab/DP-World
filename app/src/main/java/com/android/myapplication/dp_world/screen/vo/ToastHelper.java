package com.android.myapplication.dp_world.screen.vo;

import android.content.Context;
import android.widget.Toast;

import com.android.myapplication.dp_world.R;

public class ToastHelper {

    private final Context mContext;

    public ToastHelper(Context context) {
        mContext = context;
    }

    public void showUseCaseError() {
        Toast.makeText(mContext, R.string.error_asset_read_failed, Toast.LENGTH_SHORT).show();
    }
}
