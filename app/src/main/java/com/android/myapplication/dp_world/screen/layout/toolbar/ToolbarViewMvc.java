package com.android.myapplication.dp_world.screen.layout.toolbar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.views.BaseViewMvc;

public class ToolbarViewMvc extends BaseViewMvc {


    private final TextView mTextView;
    private final ImageButton mBtnBack;
    private final ImageButton mBtnHamburger;
    private Props mProps;

    public static class Props {

        public interface NavigateUpClickListener {
            void onNavigateUp();
        }

        public interface HamburgerClickListener {
            void onHamburgerClicked();
        }

        private final String title;
        private final NavigateUpClickListener mNavigateUpClickListener;
        private final HamburgerClickListener mHamburgerClickListener;

        public Props(String title,
                     NavigateUpClickListener navigateUpClickListener,
                     HamburgerClickListener hamburgerClickListener
        ) {
            this.title = title;
            mNavigateUpClickListener = navigateUpClickListener;
            mHamburgerClickListener = hamburgerClickListener;
        }
    }


    public ToolbarViewMvc(LayoutInflater layoutInflater, @Nullable ViewGroup parent) {
        setRootView(layoutInflater.inflate(R.layout.layout_toolbar, parent, false));
        mTextView = findViewById(R.id.txt_toolbar_title);
        mBtnBack = findViewById(R.id.btn_back);
        mBtnBack.setOnClickListener((view) -> {
            mProps.mNavigateUpClickListener.onNavigateUp();
        });
        mBtnHamburger = findViewById(R.id.btn_hamburger);
        mBtnHamburger.setOnClickListener((view) -> {
            mProps.mHamburgerClickListener.onHamburgerClicked();
        });
    }

    public void setProps(Props props) {
        mProps = props;
        setTitle();
        showIcon();
    }

    private void setTitle() {
        mTextView.setText(mProps.title);
    }

    private void showIcon() {
        if (mProps.mHamburgerClickListener != null && mProps.mNavigateUpClickListener != null) {
            throw new RuntimeException("hamburger and up shouldn't be shown together");
        } else if (mProps.mNavigateUpClickListener != null) {
            mBtnBack.setVisibility(View.VISIBLE);
        } else if (mProps.mHamburgerClickListener != null) {
            mBtnHamburger.setVisibility(View.VISIBLE);
        }
    }
}
