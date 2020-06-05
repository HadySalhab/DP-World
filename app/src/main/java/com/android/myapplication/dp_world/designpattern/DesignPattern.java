package com.android.myapplication.dp_world.designpattern;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Objects;

public class DesignPattern implements Parcelable {
    private final int mId;
    private final String mTitle;
    private final String mCategory;
    private final String mDescription;

    public DesignPattern(int id, String title, String category, String description) {
        mId = id;
        mTitle = title;
        mCategory = category;
        mDescription = description;
    }

    protected DesignPattern(Parcel in) {
        mId = in.readInt();
        mTitle = in.readString();
        mCategory = in.readString();
        mDescription = in.readString();
    }

    public static final Creator<DesignPattern> CREATOR = new Creator<DesignPattern>() {
        @Override
        public DesignPattern createFromParcel(Parcel in) {
            return new DesignPattern(in);
        }

        @Override
        public DesignPattern[] newArray(int size) {
            return new DesignPattern[size];
        }
    };

    public int getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getCategory() {
        return mCategory;
    }

    public String getDescription() {
        return mDescription;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mTitle);
        dest.writeString(mCategory);
        dest.writeString(mDescription);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DesignPattern that = (DesignPattern) o;
        return mId == that.mId &&
                mTitle.equals(that.mTitle) &&
                mCategory.equals(that.mCategory) &&
                mDescription.equals(that.mDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mId, mTitle, mCategory, mDescription);
    }
}
