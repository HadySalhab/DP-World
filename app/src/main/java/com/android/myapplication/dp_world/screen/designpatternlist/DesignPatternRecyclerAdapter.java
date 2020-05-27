package com.android.myapplication.dp_world.screen.designpatternlist;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.dp.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternRecyclerAdapter extends RecyclerView.Adapter<DesignPatternRecyclerAdapter.MyViewHolder> {

    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    private final Listener mListener;
    private final LayoutInflater mLayoutInflater;
    private  List<DesignPattern> mDesignPatterns = new ArrayList<>();

    public DesignPatternRecyclerAdapter(Listener listener, LayoutInflater layoutInflater) {
        mListener = listener;
        mLayoutInflater = layoutInflater;
    }

    static final class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void addAll(List<DesignPattern> designPatterns){
        Log.d("addAll","items: " +designPatterns);
        mDesignPatterns = new ArrayList<>(designPatterns);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DesignPatternRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.layout_design_pattern_list_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DesignPatternRecyclerAdapter.MyViewHolder holder, int position) {
        DesignPattern designPattern = mDesignPatterns.get(position);
        View view = holder.itemView;
        view.setOnClickListener(v -> {
            onDesignPatternClicked(designPattern);
        });
        TextView textView = view.findViewById(R.id.text_dp_title);
        textView.setText(designPattern.getTitle());
    }

    @Override
    public int getItemCount() {
        Log.d("Adapter","size: "+mDesignPatterns.size());
        return mDesignPatterns.size();
    }


    private void onDesignPatternClicked(DesignPattern designPattern) {
        mListener.onDesignPatternClicked(designPattern);
    }
}
