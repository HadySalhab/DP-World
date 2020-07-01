package com.android.myapplication.dp_world.screen.pages.catalogue.components;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.layout.toolbar.ToolbarViewMvc;
import com.android.myapplication.dp_world.screen.pages.catalogue.adapter.CatalogueArrayAdapter;
import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;

public class CatalogueViewMvcImpl extends CatalogueViewMvc {
    private final CatalogueArrayAdapter mAdapter;
    private final Toolbar mToolbar;
    private final ToolbarViewMvc mToolbarViewMvc;
    private final CatalogueListHeaderViewMvc mListHeaderViewMvc;
    private final ToolbarViewMvc.Props.NavigateUpClickListener mNavigateUpClickListener = () -> {
        mProps.listener.onNavigateUpClicked();
    };

    public CatalogueViewMvcImpl(LayoutInflater layoutInflater, @Nullable ViewGroup parent, ViewMvcFactory viewMvcFactory) {
        setRootView(layoutInflater.inflate(R.layout.layout_catalogue_list, parent, false));
        ListView listView = findViewById(R.id.list_catalogue);
        mToolbar = findViewById(R.id.toolbar);
        mAdapter = new CatalogueArrayAdapter(getContext(), viewMvcFactory);
        listView.setAdapter(mAdapter);
        mToolbarViewMvc = viewMvcFactory.getViewMvc(ToolbarViewMvc.class, mToolbar);
        mListHeaderViewMvc = viewMvcFactory.getViewMvc(CatalogueListHeaderViewMvc.class, listView);
        listView.addHeaderView(mListHeaderViewMvc.getRootView());
        initToolbar();
    }

    private void initToolbar() {
        mToolbar.addView(mToolbarViewMvc.getRootView());
        mToolbarViewMvc.setProps(new ToolbarViewMvc.Props("", mNavigateUpClickListener, null));
    }

    @Override
    public void setProps(Props props) {
        mProps = props;
        render();
    }

    private void render() {
        if (mProps.designPatternCatalogueList != null) {
            mAdapter.setProps(new CatalogueArrayAdapter.Props(mProps.designPatternCatalogueList, catalogueItem -> {
                mProps.listener.onCatalogueItemClicked(catalogueItem);
            }));
        }

        if (mProps.designPattern != null) {
            mToolbarViewMvc.setProps(new ToolbarViewMvc.Props(mProps.designPattern.getTitle(), mNavigateUpClickListener, null));
            mListHeaderViewMvc.setProps(new CatalogueListHeaderViewMvc.Props(mProps.designPattern.getDescription()));
        }
    }
}
