package com.android.myapplication.dp_world.screen.pages.dp.adapter;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.pages.dp.components.DPItemViewMvc;
import com.android.myapplication.dp_world.screen.vo.ViewMvcFactory;

import java.util.ArrayList;
import java.util.List;

public class DPRecyclerAdapter extends RecyclerView.Adapter<DPRecyclerAdapter.MyViewHolder> {

    public static class Props {
        public interface Listener {
            void onDesignPatternClicked(DesignPattern designPattern);
        }

        private final List<DesignPattern> designPatterns = new ArrayList<>();
        private final Listener listener;

        public Props(List<DesignPattern> designPatterns, Listener listener) {
            this.designPatterns.addAll(designPatterns);
            this.listener = listener;
        }
    }


    private Props mProps;
    private final ViewMvcFactory mViewMvcFactory;

    public DPRecyclerAdapter(ViewMvcFactory viewMvcFactory, Props props) {
        mProps = props;
        mViewMvcFactory = viewMvcFactory;
    }

    static final class MyViewHolder extends RecyclerView.ViewHolder {

        private final DPItemViewMvc mViewMvc;

        public MyViewHolder(DPItemViewMvc viewMvc) {
            super(viewMvc.getRootView());
            mViewMvc = viewMvc;
        }
    }

    public void setProps(Props props) {
        mProps = props;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DPRecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DPItemViewMvc viewMvc = mViewMvcFactory.getViewMvc(DPItemViewMvc.class, parent);
        return new MyViewHolder(viewMvc);
    }

    @Override
    public void onBindViewHolder(@NonNull DPRecyclerAdapter.MyViewHolder holder, int position) {
        holder.mViewMvc.setProps(new DPItemViewMvc.Props(mProps.designPatterns.get(position), designPattern -> {
            mProps.listener.onDesignPatternClicked(designPattern);
        }));
    }

    @Override
    public int getItemCount() {
        return mProps.designPatterns.size();
    }
}
