package com.kaungkhantthu.padcattraction.utils;

import android.support.annotation.DrawableRes;
import android.util.Log;

import com.kaungkhantthu.padcattraction.R;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by kaungkhantthu on 7/9/16.
 */
public  class CityDictionay {
    private static HashMap<String,Integer> imageHashMap;
    static{
        imageHashMap = new HashMap<>();
        imageHashMap.put("Yangon", R.drawable.yangon01);
        imageHashMap.put("Mandalay", R.drawable.mandalay_01);
        imageHashMap.put("Bagan", R.drawable.bagan_02);
        imageHashMap.put("Inle Lake", R.drawable.inlelake_01) ;
        imageHashMap.put("Mrauk U", R.drawable.mrauku_01);
        imageHashMap.put("Pyin O Lwin", R.drawable.pyinolwin_01);
        imageHashMap.put("Kalaw", R.drawable.kalaw_01);
        imageHashMap.put("Kyaing Tong", R.drawable.kyaing_tong_01);
        imageHashMap.put("Monywa", R.drawable.monywa_01);
        imageHashMap.put("The Irrawaddy", R.drawable.theirrawaddy_01);
        imageHashMap.put("Myeik", R.drawable.myeik_01);
        imageHashMap.put("Ngapali Beach", R.drawable.ngapali_beach_01);
        imageHashMap.put("Ngwe Saung Beach", R.drawable.ngwesaung_beach_01);
        imageHashMap.put("Pindaya", R.drawable.pindaya_01);
        imageHashMap.put("KyaikHtiYo",R.drawable.kyaikhtiyo_01);
        imageHashMap.put("Mawlamying",R.drawable.mawlamying_01);
        imageHashMap.put("Mawlamying",R.drawable.mawlamying_01);


    }
    @DrawableRes
    public static int getDrawable(String cityName){
        Log.e( "getDrawable: ",cityName );
        return  imageHashMap.get(cityName);
    }
}
