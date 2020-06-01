package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.navdrawer.DrawerItems;
import com.android.myapplication.dp_world.screen.common.toolbar.ToolbarViewMvc;

import java.util.List;

public class DesignPatternViewMvcImpl extends DesignPatternViewMvc implements DesignPatternRecyclerAdapter.Listener {

    private final ToolbarViewMvc mToolbarViewMvc;
    private final Toolbar mToolbar;
    private RecyclerView mRecyclerDesignPatterns;
    private DesignPatternRecyclerAdapter mRecyclerAdapter;

    public DesignPatternViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        super(inflater, parent);
        setRootView(inflater.inflate(R.layout.layout_design_pattern_list, parent, false));
        mRecyclerDesignPatterns = findViewById(R.id.recyclerView_desing_pattern);
        mRecyclerAdapter = new DesignPatternRecyclerAdapter(this, viewMvcFactory);
        mRecyclerDesignPatterns.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerDesignPatterns.setAdapter(mRecyclerAdapter);

        mToolbar = findViewById(R.id.toolbar);
        mToolbarViewMvc = viewMvcFactory.getViewMvc(ToolbarViewMvc.class, mToolbar);
        initToolbar();

    }

    private void initToolbar() {
        mToolbarViewMvc.bindToolbarTextTitle("Desing Patterns");
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.enableHamburgerButtonAndListen(new ToolbarViewMvc.HamburgerClickListener() {
            @Override
            public void onHamburgerClicked() {
                openDrawer();
            }
        });
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

    @Override
    protected void onDrawerItemClicked(DrawerItems item) {
        for (Listener listener : getListeners()) {
            switch (item) {
                case STRUCTURAL_LIST:
                    listener.onStructrualDrawerItemClicked();
            }
        }
    }
}
