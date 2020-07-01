package com.android.myapplication.dp_world.actions;

import com.google.gson.Gson;

public class JsonToGsonConverter {
    private static final String TAG = "JsonToGsonConverter";
    private final Gson mGson;

    public JsonToGsonConverter(Gson gson) {
        mGson = gson;
    }

    public <T> T convertToGson(Class<T> targetClass, String jsonSource) {
        return mGson.fromJson(jsonSource, targetClass);
    }
}
