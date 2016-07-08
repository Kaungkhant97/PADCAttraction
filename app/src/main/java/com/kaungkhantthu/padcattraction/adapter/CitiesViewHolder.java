package com.kaungkhantthu.padcattraction.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kaungkhantthu.padcattraction.R;
import com.kaungkhantthu.padcattraction.data.CitiesVo;
import com.kaungkhantthu.padcattraction.utils.CityDictionay;


/**
 * Created by kaungkhantthu on 7/9/16.
 */
public class CitiesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private final RVadapter.onCityClickListener mCityClickListner;
    private Context mContext;
    TextView txt_title;
    ImageView city_imageView;
    private CitiesVo cityvo;


    public CitiesViewHolder(View itemView, final RVadapter.onCityClickListener mcityclickLister) {
        super(itemView);
        this.mContext = itemView.getContext();
        txt_title = (TextView) itemView.findViewById(R.id.city_title);
        city_imageView = (ImageView) itemView.findViewById(R.id.city_image);
        this.mCityClickListner = mcityclickLister;
        itemView.setOnClickListener(this);
    }

    public void bindDatatoView(CitiesVo cities) {
        this.cityvo = cities;
        String cityname = cities.getTitle();
        txt_title.setText(cities.getTitle());
        Glide.with(mContext)
                .load(CityDictionay.getDrawable(cityname))
                .placeholder(R.drawable.bagan_02)
                .error(R.drawable.bagan_02)
                .into(city_imageView);
    }

    @Override
    public void onClick(View view) {
        mCityClickListner.onCityClick(cityvo,city_imageView);
    }
}
