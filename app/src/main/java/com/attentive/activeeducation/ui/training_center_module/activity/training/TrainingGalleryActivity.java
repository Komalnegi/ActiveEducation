package com.attentive.activeeducation.ui.coaching_module.activity.coaching;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.adapter.HomeNewCarPagerAdapter;

import java.util.ArrayList;

public class CoachingGalleryActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private String image, photoId;
    private ImageView mPhoto;
    private ArrayList<String> albumModelArrayList = new ArrayList<>();
    private HomeNewCarPagerAdapter newCarPagerAdapter;
    private int currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_gallery);

        Intent intent = getIntent();
        albumModelArrayList = intent.getStringArrayListExtra("List");


        ViewPager viewPagerCar = (ViewPager) findViewById(R.id.pager);
        newCarPagerAdapter = new HomeNewCarPagerAdapter(getApplicationContext(), albumModelArrayList);
        viewPagerCar.setAdapter(newCarPagerAdapter);

        viewPagerCar.setCurrentItem(currentItem);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        albumModelArrayList.clear();
    }
}