package com.android.myapplication.dp_world.screen.designpatterncatalogue;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.controllers.BackPressedListener;
import com.android.myapplication.dp_world.screen.common.controllers.BaseActivity;

public class CatalogueListActivity extends BaseActivity {
    private static final String DESIGN_PATTERN_ID = "DESIGN_PATTERN_ID";

    public static void start(Context context, int designPatternId) {
        Intent intent = new Intent(context, CatalogueListActivity.class);
        intent.putExtra(DESIGN_PATTERN_ID, designPatternId);
        context.startActivity(intent);
    }

    private BackPressedListener mBackPressedListener;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_content_frame);
        Log.d("CatalogueListActivity", "onCreate");
        CatalogueListFragment catalogueListFragment;
        if (savedInstanceState == null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            catalogueListFragment = CatalogueListFragment.newInstance(getDesignPatternId());
            ft.add(R.id.frame_placeholder, catalogueListFragment).commit();
        } else {
            catalogueListFragment = (CatalogueListFragment) getSupportFragmentManager().findFragmentById(R.id.frame_placeholder);
        }
        mBackPressedListener = catalogueListFragment;
    }

    private int getDesignPatternId() {
        return getIntent().getIntExtra(DESIGN_PATTERN_ID, 0);
    }

    @Override
    public void onBackPressed() {
        if (!mBackPressedListener.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
