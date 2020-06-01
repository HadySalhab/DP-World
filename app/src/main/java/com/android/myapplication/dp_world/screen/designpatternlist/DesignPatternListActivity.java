package com.android.myapplication.dp_world.screen.designpatternlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.android.myapplication.dp_world.screen.common.controllers.BackPressedListener;
import com.android.myapplication.dp_world.screen.common.controllers.BaseActivity;

import javax.inject.Inject;

public class DesignPatternListActivity extends BaseActivity {

    public static void startClearTop(Context context){
        Intent intent = new Intent(context,DesignPatternListActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
    private BackPressedListener mBackPressedListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_content_frame);
        DesignPatternListFragment designPatternListFragment;
        if(savedInstanceState == null){
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
             designPatternListFragment = new DesignPatternListFragment();
            ft.add(R.id.frame_placeholder,designPatternListFragment).commit();
        }else{
            designPatternListFragment = (DesignPatternListFragment) getSupportFragmentManager().findFragmentById(R.id.frame_placeholder);
        }
        mBackPressedListener = designPatternListFragment;
    }

    @Override
    public void onBackPressed() {
        if(!mBackPressedListener.onBackPressed()){
            super.onBackPressed();
        }
    }
}
