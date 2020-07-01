package com.android.myapplication.dp_world.screen.pages.dp.components;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;

public class DPItemViewMvcImpl extends DPItemViewMvc {

    private final TextView mTextView;

    public DPItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_design_pattern_list_item, parent, false));
        mTextView = findViewById(R.id.text_dp_title);
        getRootView().setOnClickListener((v -> {
            mProps.listener.onDesignPatternClicked(mProps.designPattern);
        }));
    }

    @Override
    public void setProps(Props props) {
        mProps = props;
        render();
    }

    private void render() {
        mTextView.setText(mProps.designPattern.getTitle());
    }
}
