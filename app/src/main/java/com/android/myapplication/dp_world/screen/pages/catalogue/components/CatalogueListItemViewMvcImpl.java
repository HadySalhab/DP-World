package com.android.myapplication.dp_world.screen.pages.catalogue.components;

        import android.view.LayoutInflater;
        import android.view.ViewGroup;
        import android.widget.TextView;

        import androidx.annotation.Nullable;

        import com.android.myapplication.dp_world.R;

public class CatalogueListItemViewMvcImpl extends CatalogueListItemViewMvc {
    private final TextView mTextView;

    public CatalogueListItemViewMvcImpl(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.layout_catalogue_list_item, parent, false));
        mTextView = findViewById(R.id.text_catalogue_name);
        getRootView().setOnClickListener(v -> {
            mProps.listener.onCatalogueItemClicked();
        });
    }

    private void render(){
        mTextView.setText(mProps.catalogueItem.getName());
    }

    @Override
    public void setProps(Props props) {
        mProps = props;
        render();
    }
}
