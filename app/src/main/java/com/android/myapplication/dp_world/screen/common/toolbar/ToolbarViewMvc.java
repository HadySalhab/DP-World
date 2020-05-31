package com.android.myapplication.dp_world.screen.common.toolbar;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {
    private final TextView mTextView;

    public ToolbarViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_toolbar, parent, false));
        mTextView = findViewById(R.id.txt_toolbar_title);
    }

    public void bindToolbarTextTitle(String title) {
        mTextView.setText(title);
    }
}
