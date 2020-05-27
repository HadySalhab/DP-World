package com.android.myapplication.dp_world.screen.designpatternlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.dp.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternListViewMvcImpl implements DesignPatternRecyclerAdapter.Listener, DesignPatternListViewMvc {
    private View mRootView;
    private RecyclerView mRecyclerDesignPatterns;
    private DesignPatternRecyclerAdapter mRecyclerAdapter;
    private final List<Listener> mListeners = new ArrayList<>(1);

    @Override
    public void registerListener(Listener listener) {
        mListeners.add(listener);
    }

    @Override
    public void unregisterListener(Listener listener) {
        mListeners.remove(listener);
    }

    @Override
    public View getRootView() {
        return mRootView.getRootView();
    }

    public DesignPatternListViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        mRootView = inflater.inflate(R.layout.layout_design_pattern_list, parent, false);
        mRecyclerDesignPatterns = findViewById(R.id.recyclerView_desing_pattern);
        mRecyclerAdapter = new DesignPatternRecyclerAdapter(this, inflater);
        mRecyclerDesignPatterns.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerDesignPatterns.setAdapter(mRecyclerAdapter);
    }

    private <T extends View> T findViewById(int id) {
        return mRootView.findViewById(id);
    }

    private Context getContext() {
        return mRootView.getContext();
    }

    @Override
    public void bindDesignPatterns(List<DesignPattern> designPatterns) {
        Log.d("Design Pattern","bindDesignPatterns");
        mRecyclerAdapter.addAll(designPatterns);
        mRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDesignPatternClicked(DesignPattern designPattern) {
        for (Listener listener : mListeners) {
            listener.onDesignPatternClicked(designPattern);
        }
    }
}
