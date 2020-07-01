package com.android.myapplication.dp_world.screen.pages.dp.components;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.controllers.NavDrawerController;
import com.android.myapplication.dp_world.screen.layout.toolbar.ToolbarViewMvc;
import com.android.myapplication.dp_world.screen.pages.dp.adapter.DPRecyclerAdapter;
import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;

import java.util.ArrayList;

public class DPViewMvcImpl extends DPViewMvc {

    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar mToolbar;
    private final NavDrawerController mNavDrawerController;
    private RecyclerView mRecyclerView;
    private DPRecyclerAdapter adapter;
    private final ToolbarViewMvc.Props.HamburgerClickListener mHamburgerClickListener = new ToolbarViewMvc.Props.HamburgerClickListener() {
        @Override
        public void onHamburgerClicked() {
            mNavDrawerController.openDrawer();
        }
    };


    public DPViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, NavDrawerController navDrawerController, ViewMvcFactory viewMvcFactory) {
        mNavDrawerController = navDrawerController;
        setRootView(inflater.inflate(R.layout.layout_design_pattern_list, parent, false));
        mRecyclerView = findViewById(R.id.recyclerView_desing_pattern);
        adapter = new DPRecyclerAdapter(viewMvcFactory, new DPRecyclerAdapter.Props(new ArrayList<>(), null));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(adapter);
        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvc(ToolbarViewMvc.class, mToolbar);
        initToolbar();
    }

    private void initToolbar() {
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.setProps(new ToolbarViewMvc.Props("", null, mHamburgerClickListener));
    }

    public void setProps(Props props) {
        mProps = props;
        render();
    }

    private void render() {
        if (mProps.designPatterns != null) {
            if (mProps.designPatterns.size() > 0) {
                mToolbarViewMvc.setProps(new ToolbarViewMvc.Props(mProps.designPatterns.get(0).getCategory(), null, mHamburgerClickListener));

                adapter.setProps(new DPRecyclerAdapter.Props(mProps.designPatterns,
                        designPattern -> mProps.listener.onDesignPatternClicked(designPattern)));
            }
        }

    }

}
