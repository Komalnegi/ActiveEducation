package com.attentive.activeeducation.ui.coaching_module.activity.coaching_admin;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.ui.coaching_module.fragment.coaching_backend.CoachingAccountFragment;
import com.attentive.activeeducation.ui.coaching_module.fragment.coaching_backend.CoachingGalleryFragment;
import com.attentive.activeeducation.ui.coaching_module.fragment.coaching_backend.CoachingProfileFragment;
import com.attentive.activeeducation.ui.coaching_module.fragment.coaching_backend.CoachingDashboardFragment;
import com.attentive.activeeducation.ui.coaching_module.fragment.coaching_backend.CoachingSeatFragment;
import com.attentive.activeeducation.ui.college_module.fragment.school_backend.CollegeAccountFragment;
import com.attentive.activeeducation.ui.college_module.fragment.school_backend.CollegeDashboardFragment;
import com.attentive.activeeducation.ui.college_module.fragment.school_backend.CollegeGalleryFragment;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

public class CoachingDashboardActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout dashBoardLay, profileLay, seatLay, accountLay, galleryLay, logoutLay,
            btnMenu;
    private FrameLayout frameContainer;
    private ExpandableRelativeLayout expandableLayout;
    private TextView txtFragmentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_dashboard);

        getIds();
    }

    private void getIds() {
        dashBoardLay = (LinearLayout) findViewById(R.id.dashBoardLay);
        dashBoardLay.setOnClickListener(this);
        profileLay = (LinearLayout) findViewById(R.id.profileLay);
        profileLay.setOnClickListener(this);
        seatLay = (LinearLayout) findViewById(R.id.seatLay);
        seatLay.setOnClickListener(this);
        accountLay = (LinearLayout) findViewById(R.id.accountLay);
        accountLay.setOnClickListener(this);
        galleryLay = (LinearLayout) findViewById(R.id.galleryLay);
        galleryLay.setOnClickListener(this);
        logoutLay = (LinearLayout) findViewById(R.id.logoutLay);
        logoutLay.setOnClickListener(this);
        btnMenu = (LinearLayout) findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(this);

        txtFragmentTitle = (TextView) findViewById(R.id.txtFragmentTitle);


        frameContainer = (FrameLayout) findViewById(R.id.frameContainer);

        expandableLayout = (ExpandableRelativeLayout) findViewById(R.id.expandableLayout);
        expandableLayout.collapse();

        /*Default Fragment*/
        Fragment fragment = new CollegeDashboardFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameContainer, fragment);
        fragmentTransaction.commit();
        txtFragmentTitle.setText(getResources().getString(R.string.target));


    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);

        switch (v.getId()) {
            case R.id.dashBoardLay:
                expandableLayout.toggle();
                fragment = new CoachingDashboardFragment();
                title = getResources().getString(R.string.target);
                break;

            case R.id.profileLay:
                expandableLayout.toggle();
                title = getResources().getString(R.string.profile);
                fragment = new CoachingProfileFragment();
                break;

            case R.id.seatLay:
                expandableLayout.toggle();
                title = getResources().getString(R.string.submit_seat);
                fragment = new CoachingSeatFragment();
                break;

            case R.id.accountLay:
                expandableLayout.toggle();
                title = getResources().getString(R.string.account);
                fragment = new CoachingAccountFragment();
                break;

            case R.id.galleryLay:
                expandableLayout.toggle();
                title = getResources().getString(R.string.gallery);
                fragment = new CoachingGalleryFragment();
                break;

            case R.id.logoutLay:
                title = getResources().getString(R.string.logout);
                expandableLayout.toggle();
                break;

            case R.id.btnMenu:
                expandableLayout.toggle();
                break;

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frameContainer, fragment);
            fragmentTransaction.commit();

            txtFragmentTitle.setText(title);
        }
    }
}
