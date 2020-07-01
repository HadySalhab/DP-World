package com.android.myapplication.dp_world.screen.pages.dp.components;

import com.android.myapplication.dp_world.designpattern.DesignPattern;
import com.android.myapplication.dp_world.screen.common.views.BaseObservableViewMvc;

public abstract class DPItemViewMvc extends BaseObservableViewMvc<DPItemViewMvc.Listener> {
    public interface Listener {
        void onDesignPatternClicked(DesignPattern designPattern);
    }
    public static class Props{
        protected final DesignPattern designPattern;
        protected final Listener listener;

        public Props(DesignPattern designPattern, Listener listener) {
            this.designPattern = designPattern;
            this.listener = listener;
        }
    }
    protected Props mProps;
    public abstract void setProps(Props props);
}
