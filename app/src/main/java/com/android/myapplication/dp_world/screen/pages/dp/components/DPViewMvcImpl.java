package com.android.myapplication.dp_world.screen.pages.dp.components;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.NavDrawerController;
import com.android.myapplication.dp_world.screen.layout.toolbar.ToolbarViewMvc;
import com.android.myapplication.dp_world.screen.pages.dp.adapter.DPRecyclerAdapter;

import java.util.List;

public class DPViewMvcImpl extends DPViewMvc implements DPRecyclerAdapter.Listener {

    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar mToolbar;
    private final NavDrawerController mNavDrawerController;
    private RecyclerView mRecyclerDesignPatterns;
    private DPRecyclerAdapter mRecyclerAdapter;

    public DPViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, NavDrawerController navDrawerController, ViewMvcFactory viewMvcFactory) {
        mNavDrawerController = navDrawerController;
        setRootView(inflater.inflate(R.layout.layout_design_pattern_list, parent, false));
        mRecyclerDesignPatterns = findViewById(R.id.recyclerView_desing_pattern);
        mRecyclerAdapter = new DPRecyclerAdapter(this, viewMvcFactory);
        mRecyclerDesignPatterns.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerDesignPatterns.setAdapter(mRecyclerAdapter);

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvc(ToolbarViewMvc.class, mToolbar);
        initToolbar();
    }

    private void initToolbar() {
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.enableHamburgerButtonAndListen(new ToolbarViewMvc.HamburgerClickListener() {
            @Override
            public void onHamburgerClicked() {
                mNavDrawerController.openDrawer();
            }
        });
    }

    public void bindToolbarTitle(String title) {
        mToolbarViewMvc.bindToolbarTextTitle(title);
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
