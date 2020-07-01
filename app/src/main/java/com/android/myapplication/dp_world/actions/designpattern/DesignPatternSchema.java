package com.android.myapplication.dp_world.actions.designpattern;

import com.google.gson.annotations.SerializedName;

public class DesignPatternSchema {

    @SerializedName("id")
    private final int mId;
    @SerializedName("title")
    private final String mTitle;
    @SerializedName("description")
    private final String mDescription;
    @SerializedName("category")
    private final String mCategory;

    public DesignPatternSchema(int id, String title, String description, String category) {
        mId = id;
        mTitle = title;
        mDescription = description;
        mCategory = category;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getCategory() {
        return mCategory;
    }
}
