package com.android.myapplication.dp_world.screen.designpatternlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.dp.DesignPattern;

public class DesignPatternListAdapter extends ArrayAdapter<DesignPattern> {

    private final OnDesignPatternClickListener mOnDesignPatternClickListener;

    public interface OnDesignPatternClickListener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    public DesignPatternListAdapter(Context context, OnDesignPatternClickListener onDesignPatternClickListener) {
        super(context, 0);
        mOnDesignPatternClickListener = onDesignPatternClickListener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_design_pattern_list_item, parent, false);
        }
        final DesignPattern designPattern = getItem(position);

        TextView txtTitle = convertView.findViewById(R.id.text_dp_title);
        txtTitle.setText(designPattern.getTitle());

        convertView.setOnClickListener((view)->{
            onDesignPatternClicked(designPattern);
        });
        return convertView;
    }

    private void onDesignPatternClicked(DesignPattern designPattern){
        mOnDesignPatternClickListener.onDesignPatternClicked(designPattern);
    }
}
