package com.android.myapplication.dp_world.screen.designpatternlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.dp.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternListViewMvcImpl implements DesignPatternListAdapter.OnDesignPatternClickListener, DesignPatternListViewMvc {
    private View mRootView;
    private ListView mDesignPatternList;
    private DesignPatternListAdapter mDesignPatternListAdapter;
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
        mDesignPatternList = findViewById(R.id.list_dp);
        mDesignPatternListAdapter = new DesignPatternListAdapter(getContext(), this);
        mDesignPatternList.setAdapter(mDesignPatternListAdapter);
    }

    private <T extends View> T findViewById(int id) {
        return mRootView.findViewById(id);
    }

    private Context getContext() {
        return mRootView.getContext();
    }

    @Override
    public void bindDesignPatterns(List<DesignPattern> designPatterns) {
        mDesignPatternListAdapter.clear();
        mDesignPatternListAdapter.addAll(designPatterns);
        mDesignPatternListAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDesignPatternClicked(DesignPattern designPattern) {
        for (Listener listener : mListeners) {
            listener.onDesignPatternClicked(designPattern);
        }
    }
}
