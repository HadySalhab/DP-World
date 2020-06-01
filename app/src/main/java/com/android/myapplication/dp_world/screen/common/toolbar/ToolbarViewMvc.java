package com.android.myapplication.dp_world.screen.common.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {
    public interface NavigateUpClickListener {
        void onNavigateUp();
    }

    public interface HamburgerClickListener {
        void onHamburgerClicked();
    }

    private NavigateUpClickListener mNavigateUpClickListener;
    private HamburgerClickListener mHamburgerClickListener;
    private final TextView mTextView;
    private final ImageButton mBtnBack;
    private final ImageButton mBtnHamburger;


    public ToolbarViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_toolbar, parent, false));
        mTextView = findViewById(R.id.txt_toolbar_title);
        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener((view) -> {
            mNavigateUpClickListener.onNavigateUp();
        });
        mBtnHamburger = findViewById(R.id.btn_hamburger);
        mBtnHamburger.setOnClickListener((v) -> {
            mHamburgerClickListener.onHamburgerClicked();
        });
    }

    public void bindToolbarTextTitle(String title) {
        mTextView.setText(title);
    }

    public void enableUpButtonAndListen(NavigateUpClickListener navigateUpClickListener) {
        if (mHamburgerClickListener != null) {
            throw new RuntimeException("hamburger and up shouldn't be shown together");
        }
        mNavigateUpClickListener = navigateUpClickListener;
        mBtnBack.setVisibility(View.VISIBLE);
    }

    public void enableHamburgerButtonAndListen(HamburgerClickListener hamburgerClickListener) {
        if (mNavigateUpClickListener != null) {
            throw new RuntimeException("hamburger and up shouldn't be shown together");
        }
        mHamburgerClickListener = hamburgerClickListener;
        mBtnHamburger.setVisibility(View.VISIBLE);

    }
}
