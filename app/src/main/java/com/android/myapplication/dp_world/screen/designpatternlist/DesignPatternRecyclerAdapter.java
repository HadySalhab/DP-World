package com.android.myapplication.dp_world.screen.designpatternlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myapplication.dp_world.dp.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DesignPatternRecyclerAdapter extends RecyclerView.Adapter<DesignPatternRecyclerAdapter.MyViewHolder>
    implements DesignPatternListItemViewMvcImpl.Listener
{
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    private  List<DesignPattern> mDesignPatterns = new ArrayList<>();
    private final Listener mListener;
    private final LayoutInflater mLayoutInflater;

    public DesignPatternRecyclerAdapter(Listener listener, LayoutInflater layoutInflater) {
        mListener = listener;
        mLayoutInflater = layoutInflater;
    }

    static final class MyViewHolder extends RecyclerView.ViewHolder {

        private final DesignPatternListItemViewMvc mViewMvc;

        public MyViewHolder(DesignPatternListItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    public void bindDesignPatterns(List<DesignPattern> designPatterns){
        mDesignPatterns = new ArrayList<>(designPatterns);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DesignPatternRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DesignPatternListItemViewMvc viewMvc = new DesignPatternListItemViewMvcImpl(mLayoutInflater,parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull DesignPatternRecyclerAdapter.MyViewHolder holder, int position) {
       holder.mViewMvc.bindDesignPattern(mDesignPatterns.get(position));
    }

    @Override
    public int getItemCount() {
        return mDesignPatterns.size();
    }

    @Override
    public void onDesignPatternClicked(DesignPattern designPattern) {
        mListener.onDesignPatternClicked(designPattern);
    }

}
