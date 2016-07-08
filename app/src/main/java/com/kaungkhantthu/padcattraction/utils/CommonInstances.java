package com.kaungkhantthu.padcattraction.utils;

import com.google.gson.Gson;

/**
 * Created by kaung on 12/12/15.
 */
public class CommonInstances {

    private static Gson gson = new Gson();

    public static Gson getGsonInstance() {
        return gson;
    }
}
