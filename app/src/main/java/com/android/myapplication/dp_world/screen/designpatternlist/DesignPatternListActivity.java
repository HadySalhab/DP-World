package com.android.myapplication.dp_world.screen.designpatternlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.BaseActivity;

import javax.inject.Inject;

public class DesignPatternListActivity extends BaseActivity {

    @Inject
    ViewMvcFactory mViewMvcFactory;
    @Inject
    DesignPatternListController mDesignPatternListController;

    public static void start(Context context){
        Intent intent = new Intent(context,DesignPatternListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);
        DesignPatternViewMvc mViewMvc = mViewMvcFactory.getViewMvc(DesignPatternViewMvc.class, null);
        mDesignPatternListController.bindViewMvc(mViewMvc);
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mDesignPatternListController.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mDesignPatternListController.onStop();
    }

    @Override
    public void onBackPressed() {
        if(!mDesignPatternListController.onBackPressed()){
           super.onBackPressed();
        }
    }
}
