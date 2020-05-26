package com.android.myapplication.dp_world.screen;

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

public class DPListAdapter extends ArrayAdapter<DesignPattern> {

    private final OnDPClickListener mOnDPClickListener;

    public interface OnDPClickListener {
        void onDPClicked(DesignPattern designPattern);
    }

    public DPListAdapter(Context context, OnDPClickListener onDPClickListener) {
        super(context, 0);
        mOnDPClickListener = onDPClickListener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.layout_dp_list_item, parent, false);
        }
        final DesignPattern designPattern = getItem(position);

        TextView txtTitle = convertView.findViewById(R.id.text_dp_title);
        txtTitle.setText(designPattern.getTitle());

        convertView.setOnClickListener((view)->{
           onDPClicked(designPattern);
        });
        return convertView;
    }

    private void onDPClicked(DesignPattern designPattern){
        mOnDPClickListener.onDPClicked(designPattern);
    }
}
