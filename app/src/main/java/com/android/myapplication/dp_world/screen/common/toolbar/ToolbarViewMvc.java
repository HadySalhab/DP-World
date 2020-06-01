package com.android.myapplication.dp_world.screen.common.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {
    public interface NavigateUpClickListener{
        void onNavigateUp();
    }
    private NavigateUpClickListener mNavigateUpClickListener;
    private final TextView mTextView;
    private final ImageView mBtnBack;

    public ToolbarViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_toolbar, parent, false));
        mTextView = findViewById(R.id.txt_toolbar_title);
        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener((view)->{
            mNavigateUpClickListener.onNavigateUp();
        });
    }

    public void bindToolbarTextTitle(String title) {
        mTextView.setText(title);
    }
    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener){
        mNavigateUpClickListener = navigateUpClickListener;
        mBtnBack.setVisibility(View.VISIBLE);
    }
}
