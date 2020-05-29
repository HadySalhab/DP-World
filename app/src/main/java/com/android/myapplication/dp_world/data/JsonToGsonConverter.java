package com.android.myapplication.dp_world.data;

import com.google.gson.Gson;

public class JsonToGsonConverter {

    private final Gson mGson;

    public JsonToGsonConverter(Gson gson) {
        mGson = gson;
    }

    public <T> T convertToGson(Class<T> gsonClass, String json) {
        return mGson.fromJson(json, gsonClass);
    }
}
