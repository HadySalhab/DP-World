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

public class DesignPatternListViewMvcImpl extends DesignPatternListViewMvc implements DesignPatternRecyclerAdapter.Listener {

    private RecyclerView mRecyclerDesignPatterns;
    private DesignPatternRecyclerAdapter mRecyclerAdapter;

    public DesignPatternListViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
       setRootView(inflater.inflate(R.layout.layout_design_pattern_list, parent, false));
        mRecyclerDesignPatterns = findViewById(R.id.recyclerView_desing_pattern);
        mRecyclerAdapter = new DesignPatternRecyclerAdapter(this, inflater);
        mRecyclerDesignPatterns.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerDesignPatterns.setAdapter(mRecyclerAdapter);
    }

    @Override
    public void bindDesignPatterns(List<DesignPattern> designPatterns) {
        mRecyclerAdapter.bindDesignPatterns(designPatterns);
        mRecyclerAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDesignPatternClicked(DesignPattern designPattern) {
        for (Listener listener : getListeners()) {
            listener.onDesignPatternClicked(designPattern);
        }
    }
}
