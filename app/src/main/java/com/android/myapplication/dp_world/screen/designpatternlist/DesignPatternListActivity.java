package com.android.myapplication.dp_world.screen.designpatternlist;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.Toast;

import com.android.myapplication.dp_world.R;
import com.android.myapplication.dp_world.common.Constants;
import com.android.myapplication.dp_world.data.DesignPatternSchema;
import com.android.myapplication.dp_world.data.DesignPatternsResponseSchema;
import com.android.myapplication.dp_world.dp.DesignPattern;
import com.android.myapplication.dp_world.screen.common.BaseActivity;
import com.android.myapplication.dp_world.screen.common.ViewMvcFactory;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class DesignPatternListActivity extends BaseActivity implements DesignPatternListViewMvcImpl.Listener {

    private DesignPatternListViewMvc mViewMvc;

    @Inject
    Gson mGson;
    @Inject
    AssetManager mAssetManager;
    @Inject
    ViewMvcFactory mViewMvcFactory;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPresentationComponent().inject(this);
        mViewMvc = mViewMvcFactory.getViewMvc(DesignPatternListViewMvc.class, null);
        mViewMvc.registerListener(this);
        setContentView(mViewMvc.getRootView());
    }

    @Override
    protected void onStart() {
        super.onStart();
        loadJsonFromAsset();
    }

    private void loadJsonFromAsset() {
        String json = "";
        try {
            InputStream inputStream = mAssetManager.open(Constants.ASSET_FILE_NAME);
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
            DesignPatternsResponseSchema designPatternsResponseSchema = mGson.fromJson(json, DesignPatternsResponseSchema.class);
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
        mViewMvc.bindDesignPatterns(designPatterns);
    }

    private void assetReadFailed() {
        Toast.makeText(this, R.string.error_asset_read_failed, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDesignPatternClicked(DesignPattern designPattern) {
        Toast.makeText(this, designPattern.getTitle(), Toast.LENGTH_SHORT).show();
    }
}
