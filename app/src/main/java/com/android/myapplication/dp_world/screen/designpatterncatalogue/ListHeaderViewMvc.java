package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.views.BaseViewMvc;

public class ListHeaderViewMvc extends BaseViewMvc {

    private final AppCompatImageView mAppCompatImageView;
    private final AppCompatTextView mAppCompatTextView;

    public ListHeaderViewMvc(LayoutInflater inflater, @Nullable ViewGroup parent) {
        setRootView(inflater.inflate(R.layout.element_list_header,parent,false));
        mAppCompatImageView = findViewById(R.id.list_dp_image);
        mAppCompatTextView = findViewById(R.id.list_dp_name);
    }

    public void bindTitle(String title){
        mAppCompatTextView.setText(title);
    }

}
