package com.kaungkhantthu.padcattraction.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kaungkhantthu.padcattraction.R;
import com.kaungkhantthu.padcattraction.data.CitiesVo;

import java.util.ArrayList;

/**
 * Created by kaungkhantthu on 7/9/16.
 */
public class RVadapter extends RecyclerView.Adapter<CitiesViewHolder> {
    private final onCityClickListener mcityclickLister;
    private  ArrayList<CitiesVo> cityList;
    public RVadapter(ArrayList<CitiesVo> citiesVos,onCityClickListener clickListener) {
        this.mcityclickLister = clickListener;
        this.cityList = citiesVos;


    }

    @Override
    public CitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.cityitem,parent,false);
      return   new CitiesViewHolder(v,mcityclickLister);

    }

    @Override
    public void onBindViewHolder(CitiesViewHolder holder, int position) {
        holder.bindDatatoView(cityList.get(position));
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public interface onCityClickListener {
        void onCityClick(CitiesVo city, ImageView ivAttraction);
    }
}
