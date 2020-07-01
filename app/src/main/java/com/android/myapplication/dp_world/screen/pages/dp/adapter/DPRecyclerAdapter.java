package com.android.myapplication.dp_world.screen.pages.dp.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPItemViewMvc;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPItemViewMvcImpl;

import java.util.ArrayList;
import java.util.List;

public class DPRecyclerAdapter extends RecyclerView.Adapter<DPRecyclerAdapter.MyViewHolder>
        implements DPItemViewMvcImpl.Listener {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    private List<DesignPattern> mDesignPatterns = new ArrayList<>();
    private final Listener mListener;
    private final ViewMvcFactory mViewMvcFactory;

    public DPRecyclerAdapter(Listener listener, ViewMvcFactory viewMvcFactory) {
        mListener = listener;
        mViewMvcFactory = viewMvcFactory;
    }

    static final class MyViewHolder extends RecyclerView.ViewHolder {

        private final DPItemViewMvc mViewMvc;

        public MyViewHolder(DPItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    public void bindDesignPatterns(List<DesignPattern> designPatterns) {
        mDesignPatterns = new ArrayList<>(designPatterns);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DPRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DPItemViewMvc viewMvc = mViewMvcFactory.getViewMvc(DPItemViewMvc.class, parent);
        viewMvc.registerListener(this);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull DPRecyclerAdapter.MyViewHolder holder, int position) {
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
