package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.dp.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternListItemViewMvcImpl extends DesignPatternListItemViewMvc {

    private final List<Listener> mListeners = new ArrayList<>(1);

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }
    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }
    private final TextView mTextView;
    private DesignPattern mDesignPattern;

    public DesignPatternListItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_design_pattern_list_item, parent, false));
        mTextView = findViewById(R.id.text_dp_title);
        getRootView().setOnClickListener((v -> {
            for (Listener listener : mListeners) {
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
