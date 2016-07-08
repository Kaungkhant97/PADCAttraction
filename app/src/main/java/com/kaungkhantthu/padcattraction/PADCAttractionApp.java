package com.kaungkhantthu.padcattraction;

import android.app.Application;
import android.content.Context;

/**
 * Created by kaungkhantthu on 7/8/16.
 */
public class PADCAttractionApp extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}


