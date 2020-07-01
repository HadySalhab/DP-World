package com.android.myapplication.dp_world.screen.pages.dp.components;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

import java.util.List;

public abstract class DPViewMvc extends BaseObservableViewMvc<DPViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }

    public static class Props {
        protected final List<DesignPattern> designPatterns;
        protected final DPViewMvc.Listener listener;

        public Props(List<DesignPattern> designPatterns, DPViewMvc.Listener listener) {
            this.designPatterns = designPatterns;
            this.listener = listener;
        }
    }

    protected Props mProps;

    abstract public void setProps(Props props);
}
