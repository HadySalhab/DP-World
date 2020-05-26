package com.android.myapplication.dp_world.screen;

import android.os.Bundle;
import android.widget.ListView;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.screen.common.BaseActivity;

public class DPListActivity extends BaseActivity {
    private ListView mListDp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dp_list);
        mListDp = findViewById(R.id.list_dp);
    }
}
