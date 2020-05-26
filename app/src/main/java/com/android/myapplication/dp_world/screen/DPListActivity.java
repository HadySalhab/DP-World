package com.android.myapplication.dp_world.screen;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.common.Constants;
import com.android.myapplication.dp_world.data.DesignPatternSchema;
import com.android.myapplication.dp_world.data.DesignPatternsResponseSchema;
import com.android.myapplication.dp_world.dp.DesignPattern;
import com.android.myapplication.dp_world.screen.common.BaseActivity;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DPListActivity extends BaseActivity implements DPListAdapter.OnDPClickListener {

    private ListView mListDp;
    private DPListAdapter mDPListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dp_list);
        mListDp = findViewById(R.id.list_dp);
        mDPListAdapter = new DPListAdapter(this, this);
        mListDp.setAdapter(mDPListAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        loadJsonFromAsset();
    }

    private void loadJsonFromAsset() {
        String json = "";
        try {
            InputStream inputStream = this.getAssets().open(Constants.ASSET_FILE_NAME);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            Gson gson = new Gson();
            DesignPatternsResponseSchema designPatternsResponseSchema = gson.fromJson(json, DesignPatternsResponseSchema.class);
            bindDesignPatterns(designPatternsResponseSchema.getDesignPatterns());

        } catch (IOException ioe) {
            ioe.printStackTrace();
            assetReadFailed();
        }
    }

    private void bindDesignPatterns(List<DesignPatternSchema> designPatternSchemas) {
        List<DesignPattern> designPatterns = new ArrayList<>(designPatternSchemas.size());
        for (DesignPatternSchema designPatternSchema : designPatternSchemas) {
            DesignPattern designPattern = new DesignPattern(designPatternSchema.getId(), designPatternSchema.getTitle(), designPatternSchema.getCategory());
            designPatterns.add(designPattern);
        }
        mDPListAdapter.clear();
        mDPListAdapter.addAll(designPatterns);
        mDPListAdapter.notifyDataSetChanged();
    }

    private void assetReadFailed(){
        Toast.makeText(this,R.string.error_asset_read_failed, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDPClicked(DesignPattern designPattern) {
        Toast.makeText(this,designPattern.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
