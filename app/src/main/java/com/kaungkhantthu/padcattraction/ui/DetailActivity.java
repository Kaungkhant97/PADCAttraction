package com.kaungkhantthu.padcattraction.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.kaungkhantthu.padcattraction.R;
import com.kaungkhantthu.padcattraction.utils.CityDictionay;
import com.kaungkhantthu.padcattraction.utils.Constants;



public class DetailActivity extends AppCompatActivity {


    ImageView cityImage;
    Toolbar toolbar;
    CollapsingToolbarLayout collapsingToolbar;
    TextView tvCityDesc;

    FloatingActionButton fab;
    private String title;
    private String description;

    public static Intent newIntent(String cityname,String description,Context context) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(Constants.CITYNAME, cityname);
        intent.putExtra(Constants.CITYDESCRIPTION, description);

        return intent;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        title = getIntent().getExtras().getString(Constants.CITYNAME);
        description =  getIntent().getExtras().getString(Constants.CITYDESCRIPTION);

        //getSupportActionBar().setTitle(title);
        cityImage = (ImageView) findViewById(R.id.img_city);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        tvCityDesc = (TextView) findViewById(R.id.tv_attraction_desc);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvCityDesc.setText(description);
        collapsingToolbar.setTitle(title);
        Glide.with(this)
                .load(CityDictionay.getDrawable(title))
                .placeholder(R.drawable.bagan_02)
                .error(R.drawable.bagan_02)
                .into(cityImage);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            cityImage.setTransitionName(Constants.IMGTRASITION);
        }
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                Uri imguri = Uri.parse("android.resource://com.kaungkhantthu.padcattraction/drawable/" + CityDictionay.getDrawable(title));
                Drawable drawable = getResources().getDrawable(CityDictionay.getDrawable(title));

                sharingIntent.setType("image/jpeg");
                sharingIntent.putExtra(Intent.EXTRA_STREAM, imguri);
                startActivity(Intent.createChooser(sharingIntent, "Share image using"));
            }
        });
    }


}
