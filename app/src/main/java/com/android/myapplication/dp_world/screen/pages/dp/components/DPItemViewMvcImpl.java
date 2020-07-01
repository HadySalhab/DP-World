package com.android.myapplication.dp_world.screen.pages.dp.components;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.designpattern.DesignPattern;

public class DPItemViewMvcImpl extends DPItemViewMvc {

    private final TextView mTextView;
    private DesignPattern mDesignPattern;

    public DPItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_design_pattern_list_item, parent, false));
        mTextView = findViewById(R.id.text_dp_title);
        getRootView().setOnClickListener((v -> {
            for (Listener listener : getListeners()) {
                listener.onDesignPatternClicked(mDesignPattern);
            }
        }));
    }

    @Override
    public void bindDesignPattern(DesignPattern designPattern) {
        mDesignPattern = designPattern;
        mTextView.setText(designPattern.getTitle());
    }
}
