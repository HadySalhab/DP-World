package com.android.myapplication.dp_world.dp;

public class DesignPattern {
    private final int mId;
    private final String mTitle;
    private final String mCategory;

    public DesignPattern(int id, String title, String category) {
        mId = id;
        mTitle = title;
        mCategory = category;
    }

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCategory() {
        return mCategory;
    }
}
