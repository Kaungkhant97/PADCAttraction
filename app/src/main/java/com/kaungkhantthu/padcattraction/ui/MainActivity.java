package com.kaungkhantthu.padcattraction.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.kaungkhantthu.padcattraction.R;
import com.kaungkhantthu.padcattraction.adapter.RVadapter;
import com.kaungkhantthu.padcattraction.data.CitiesVo;
import com.kaungkhantthu.padcattraction.model.CitiesModel;
import com.kaungkhantthu.padcattraction.utils.Constants;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RVadapter.onCityClickListener{

    RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mRecyclerView = (RecyclerView) findViewById(R.id.AttractionListRecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        RVadapter rVadapter = new RVadapter((ArrayList<CitiesVo>) CitiesModel.getInstance().getAttractionList(),this);
        mRecyclerView.setAdapter(rVadapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCityClick(CitiesVo city, ImageView ivAttraction) {
        Intent intent = DetailActivity.newIntent(city.getTitle(),city.getDesc(),this);
        Log.e( "onCityClick: ", intent+"");
        ActivityOptionsCompat activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this,
                new Pair(ivAttraction, Constants.IMGTRASITION));
        ActivityCompat.startActivity(this, intent, activityOptions.toBundle());
    }
}
