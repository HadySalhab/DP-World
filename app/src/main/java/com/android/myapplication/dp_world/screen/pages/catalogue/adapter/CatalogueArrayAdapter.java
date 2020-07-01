package com.android.myapplication.dp_world.screen.pages.catalogue.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.screen.pages.catalogue.components.CatalogueListItemViewMvc;
import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;

public class CatalogueArrayAdapter extends ArrayAdapter<CatalogueItem> {

    public static class Props {
        public interface Listener {
            void onCatalogueItemClicked(CatalogueItem catalogueItem);
        }

        private final CatalogueItem[] designPatternCatalogueList;
        private final Listener mListener;

        public Props(CatalogueItem[] designPatternCatalogueList, Listener listener) {
            this.designPatternCatalogueList = designPatternCatalogueList;
            mListener = listener;
        }
    }


    private Props mProps;
    private final ViewMvcFactory mViewMvcFactory;

    public CatalogueArrayAdapter(@NonNull Context context, ViewMvcFactory viewMvcFactory) {
        super(context, 0);
        mViewMvcFactory = viewMvcFactory;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            CatalogueListItemViewMvc viewMvc =
                    mViewMvcFactory.getViewMvc(CatalogueListItemViewMvc.class, parent);
            convertView = viewMvc.getRootView();
            convertView.setTag(viewMvc);

        }
        final CatalogueItem catalogueItem = getItem(position);
        CatalogueListItemViewMvc viewMvc = (CatalogueListItemViewMvc) convertView.getTag();
        viewMvc.setProps(new CatalogueListItemViewMvc.Props(catalogueItem, () ->
                mProps.mListener.onCatalogueItemClicked(catalogueItem)));
        return convertView;
    }

    public void setProps(Props props) {
        mProps = props;
        render();
    }

    private void render() {
        clear();
        addAll(mProps.designPatternCatalogueList);
        notifyDataSetChanged();
    }

}
