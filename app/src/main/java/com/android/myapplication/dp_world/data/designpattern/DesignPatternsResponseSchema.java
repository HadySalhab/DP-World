package com.android.myapplication.dp_world.data.designpattern;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DesignPatternsResponseSchema {

    @SerializedName("design_patterns")
    private final List<DesignPatternSchema> mDesignPatterns;

    public DesignPatternsResponseSchema(List<DesignPatternSchema> designPatternSchemas) {
        mDesignPatterns = designPatternSchemas;
    }

    public List<DesignPatternSchema> getDesignPatterns() {
        return mDesignPatterns;
    }
}
