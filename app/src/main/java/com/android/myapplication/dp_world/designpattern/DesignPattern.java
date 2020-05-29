package com.android.myapplication.dp_world.designpattern;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DesignPattern that = (DesignPattern) o;
        return mId == that.mId &&
                Objects.equals(mTitle, that.mTitle) &&
                Objects.equals(mCategory, that.mCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mTitle, mCategory);
    }
}
