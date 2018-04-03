package com.attentive.activeeducation.ui.coaching_module.fragment.coaching_backend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.model.SchoolProfileModel;
import com.attentive.activeeducation.recycler.RcycleViewHandler;
import com.attentive.activeeducation.recycler.RcycleViewLayoutItem;
import com.attentive.activeeducation.ui.school_module.api.AllSchoolFacilityApi;
import com.attentive.activeeducation.ui.school_module.model.school_admin.AllSchoolFacilityModel;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import java.util.ArrayList;

;

/**
 * Created by vinod on 28/3/18.
 */

public class CoachingProfileFragment extends Fragment implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {
    private View view;
    private ArrayList<SchoolProfileModel> schoolProfileModels = new ArrayList<>();
    private ExpandableRelativeLayout expandableLayoutFacilities, expandableLayProfile, expandableLayoutAddress,
            expandableLayoutSocialDetail, expandableLayoutImages, expandableLayoutCertificate, expandableLayoutBrochure;
    private CardView schoolFacilitiesLay, schoolProfileLay, schoolAddressLay, schoolSocialDetailLay,
            schoolImagesLay, schoolCertificateLay, schoolBrochureLay;
    private SwitchCompat switchBtnSchool, switchBtnSchoolAddress, switchBtnSocialDetail, switchBtnImages,
            switchBtnCertificate, switchBtnBrochure, switchBtnFacilities;


    public static CoachingProfileFragment newInstance(Bundle b) {
        CoachingProfileFragment fragment = new CoachingProfileFragment();
        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_school_profile, container, false);

        getIds();

        getPrfileData();

        return view;
    }

    private void getIds() {
        schoolProfileLay = (CardView) view.findViewById(R.id.schoolProfileLay);
        schoolProfileLay.setOnClickListener(this);

        schoolAddressLay = (CardView) view.findViewById(R.id.schoolAddressLay);
        schoolAddressLay.setOnClickListener(this);

        schoolSocialDetailLay = (CardView) view.findViewById(R.id.schoolSocialDetailLay);
        schoolSocialDetailLay.setOnClickListener(this);

        schoolImagesLay = (CardView) view.findViewById(R.id.schoolImagesLay);
        schoolImagesLay.setOnClickListener(this);

        schoolCertificateLay = (CardView) view.findViewById(R.id.schoolCertificateLay);
        schoolCertificateLay.setOnClickListener(this);

        schoolBrochureLay = (CardView) view.findViewById(R.id.schoolBrochureLay);
        schoolBrochureLay.setOnClickListener(this);

        schoolFacilitiesLay = (CardView) view.findViewById(R.id.schoolFacilitiesLay);
        schoolFacilitiesLay.setOnClickListener(this);


        expandableLayProfile = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayProfile);
        expandableLayoutAddress = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayoutAddress);
        expandableLayoutSocialDetail = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayoutSocialDetail);
        expandableLayoutImages = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayoutImages);
        expandableLayoutCertificate = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayoutCertificate);
        expandableLayoutBrochure = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayoutBrochure);
        expandableLayoutFacilities = (ExpandableRelativeLayout) view.findViewById(R.id.expandableLayoutFacilities);

        switchBtnSchool = (SwitchCompat) view.findViewById(R.id.switchBtnSchool);
        switchBtnSchool.setOnCheckedChangeListener(this);

        switchBtnSchoolAddress = (SwitchCompat) view.findViewById(R.id.switchBtnSchoolAddress);
        switchBtnSchoolAddress.setOnCheckedChangeListener(this);

        switchBtnSocialDetail = (SwitchCompat) view.findViewById(R.id.switchBtnSocialDetail);
        switchBtnSocialDetail.setOnCheckedChangeListener(this);

        switchBtnImages = (SwitchCompat) view.findViewById(R.id.switchBtnImages);
        switchBtnImages.setOnCheckedChangeListener(this);

        switchBtnCertificate = (SwitchCompat) view.findViewById(R.id.switchBtnCertificate);
        switchBtnCertificate.setOnCheckedChangeListener(this);

        switchBtnBrochure = (SwitchCompat) view.findViewById(R.id.switchBtnBrochure);
        switchBtnBrochure.setOnCheckedChangeListener(this);

        switchBtnFacilities = (SwitchCompat) view.findViewById(R.id.switchBtnFacilities);
        switchBtnFacilities.setOnCheckedChangeListener(this);


    }

    private void getPrfileData() {
        new AllSchoolFacilityApi("AE", new AllSchoolFacilityApi.OnSchoolFacilityListner() {
            @Override
            public void schoolFacilitySuccess(ArrayList<AllSchoolFacilityModel> schoolModels) {
                setFacilityData(schoolModels);
            }

            @Override
            public void schoolFacilityFailed(String msg) {

            }
        });
    }

    private void setFacilityData(ArrayList<AllSchoolFacilityModel> schoolModels) {
        RcycleViewLayoutItem txtCheck = new RcycleViewLayoutItem<>("activitiesDesc",
                R.id.txtCheck,
                new RcycleViewLayoutItem.DisplayLayoutItem<AllSchoolFacilityModel>() {
                    @Override
                    public void displayLayoutItem(View view, AllSchoolFacilityModel model) {
                        ((CheckedTextView) view).setText(model.getFacilityName());
                    }
                },
                null);

        RcycleViewLayoutItem checkLay = new RcycleViewLayoutItem<>("onClick",
                R.id.txtCheck,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<AllSchoolFacilityModel>() {
                    @Override
                    public void layoutItemOnClick(View view, AllSchoolFacilityModel model) {
                        if (model.isClicked()) {
                            ((CheckedTextView) view).setChecked(false);
                            model.setClicked(false);
                        } else {
                            ((CheckedTextView) view).setChecked(true);
                            model.setClicked(true);
                        }
                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(view,
                R.id.recyclerAddFacility,
                R.layout.facility_check_item,
                schoolModels);


        rcView.addLayoutItem(txtCheck);
        rcView.addLayoutItem(checkLay);
        rcView.render(view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.schoolProfileLay:
                expandableLayProfile.toggle();
                break;

            case R.id.schoolAddressLay:
                expandableLayoutAddress.toggle();
                break;

            case R.id.schoolSocialDetailLay:
                expandableLayoutSocialDetail.toggle();
                break;

            case R.id.schoolImagesLay:
                expandableLayoutImages.toggle();
                break;

            case R.id.schoolCertificateLay:
                expandableLayoutCertificate.toggle();
                break;

            case R.id.schoolBrochureLay:
                expandableLayoutBrochure.toggle();
                break;

            case R.id.schoolFacilitiesLay:
                expandableLayoutFacilities.toggle();
                break;*/

        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switchBtnSchool:
                expandableLayProfile.toggle();
                break;

            case R.id.switchBtnSchoolAddress:
                expandableLayoutAddress.toggle();
                break;

            case R.id.switchBtnSocialDetail:
                expandableLayoutSocialDetail.toggle();
                break;

            case R.id.switchBtnImages:
                expandableLayoutImages.toggle();
                break;

            case R.id.switchBtnCertificate:
                expandableLayoutCertificate.toggle();
                break;

            case R.id.switchBtnBrochure:
                expandableLayoutAddress.toggle();
                break;

            case R.id.switchBtnFacilities:
                expandableLayoutFacilities.toggle();
                break;
        }
    }

}
