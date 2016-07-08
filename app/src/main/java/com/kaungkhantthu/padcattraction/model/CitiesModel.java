package com.kaungkhantthu.padcattraction.model;

import com.google.gson.reflect.TypeToken;
import com.kaungkhantthu.padcattraction.data.CitiesVo;
import com.kaungkhantthu.padcattraction.utils.CommonInstances;
import com.kaungkhantthu.padcattraction.utils.JsonUtils;

import org.json.JSONException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kaungkhantthu on 7/9/16.
 */
public class CitiesModel {

    private static final String CITY_LIST = "myanmar_attractions.json";

    private static CitiesModel Instance;

    private List<CitiesVo> CitiesList;

    private CitiesModel() {
        CitiesList = initializeAttractions();
    }

    public static CitiesModel getInstance() {
        if (Instance == null) {
            Instance = new CitiesModel();
        }
        return Instance;
    }

    private List<CitiesVo> initializeAttractions() {
        List<CitiesVo> attractionList = new ArrayList<>();

        try {
            String attractions = JsonUtils.getInstance().loadDummyData(CITY_LIST);
            Type listType = new TypeToken<List<CitiesVo>>() {
            }.getType();
            attractionList = CommonInstances.getGsonInstance().fromJson(attractions, listType);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return attractionList;
    }

    public List<CitiesVo> getAttractionList() {
        return CitiesList;
    }

    public CitiesVo getAttractionByName(String CityName) {
        for(CitiesVo city : CitiesList) {
            if(city.getTitle().equals(CityName))
                return city;
        }

        return null;
    }
}