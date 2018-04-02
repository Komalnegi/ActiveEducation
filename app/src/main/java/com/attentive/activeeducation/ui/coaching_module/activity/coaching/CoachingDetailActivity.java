package com.attentive.activeeducation.ui.university_module.activity.university;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.adapter.SchoolBannerAdapter;
import com.attentive.activeeducation.recycler.RcycleViewHandler;
import com.attentive.activeeducation.recycler.RcycleViewLayoutItem;
import com.attentive.activeeducation.ui.college_module.api.TopCollegeDetailApi;
import com.attentive.activeeducation.ui.college_module.model.CollegeBannerModel;
import com.attentive.activeeducation.ui.college_module.model.CollegeCertificateModel;
import com.attentive.activeeducation.ui.college_module.model.CollegeFacilityModel;
import com.attentive.activeeducation.ui.college_module.model.CollegeGalleryModel;
import com.attentive.activeeducation.ui.college_module.model.TopCollegeDetailModel;
import com.attentive.activeeducation.ui.common_activity.PdfViewActivity;
import com.attentive.activeeducation.ui.school_module.activity.school.SubmitApplicationActivity;
import com.attentive.activeeducation.ui.school_module.activity.school.ViewGalleryActivity;
import com.attentive.activeeducation.ui.university_module.api.TopUniversityDetailApi;
import com.attentive.activeeducation.ui.university_module.model.UniBannerModel;
import com.attentive.activeeducation.ui.university_module.model.UniCertificateModel;
import com.attentive.activeeducation.ui.university_module.model.UniDetailModel;
import com.attentive.activeeducation.ui.university_module.model.UniFacilityModel;
import com.attentive.activeeducation.ui.university_module.model.UniGalleryModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class UniversityDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private String cId, courseId, branchId;
    private TextView txtClass, txtClassName, txtDescription, txtAffiliationBy,
            txtCall, txtAddress, txtWeb, txtEmail, txtToolbar;
    private FrameLayout brochureLay;
    private String broAddress;
    private Button btnApply;
    private LinearLayout callLay, chatLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_detail);

        Intent intent = getIntent();
        cId = intent.getStringExtra("cId");
        courseId = intent.getStringExtra("courseId");
        branchId = intent.getStringExtra("branchId");

        getIds();
    }

    private void getIds() {
        callLay = (LinearLayout) findViewById(R.id.callLay);
        callLay.setOnClickListener(this);
        chatLay = (LinearLayout) findViewById(R.id.chatLay);
        chatLay.setOnClickListener(this);

        txtClass = (TextView) findViewById(R.id.txtClass);
        txtClassName = (TextView) findViewById(R.id.txtClassName);
        txtDescription = (TextView) findViewById(R.id.txtDescription);
        txtAffiliationBy = (TextView) findViewById(R.id.txtAffiliationBy);
        txtCall = (TextView) findViewById(R.id.txtCall);
        txtAddress = (TextView) findViewById(R.id.txtAddress);
        txtWeb = (TextView) findViewById(R.id.txtWeb);
        txtEmail = (TextView) findViewById(R.id.txtEmail);
        brochureLay = (FrameLayout) findViewById(R.id.brochureLay);
        brochureLay.setOnClickListener(this);

        btnApply = (Button) findViewById(R.id.btnApply);
        btnApply.setOnClickListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        txtToolbar = (TextView) findViewById(R.id.txtToolbar);


        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getDetail();
    }

    private void getDetail() {
       /* new TopCollegeDetailApi(cId, courseId, branchId, new TopCollegeDetailApi.OnCollegeDetailListner() {
            @Override
            public void collegeDetailSuccess(List<CollegeGalleryModel> galleryList, List<CollegeBannerModel> bannerList,
                                             List<CollegeCertificateModel> certificateList,
                                             List<CollegeFacilityModel> facilityList, List<TopCollegeDetailModel> schoolDetailList) {

                ArrayList<String> bannerData = new ArrayList<>();
                for (CollegeBannerModel model : bannerList){
                    bannerData.add(model.getName());
                }

                ArrayList<String> gelleryData = new ArrayList<>();
                for (CollegeGalleryModel model : galleryList){
                    gelleryData.add(model.getName());
                }

                ViewPager viewPagerCar = (ViewPager) findViewById(R.id.pagerBanner);
                SchoolBannerAdapter newCarPagerAdapter = new SchoolBannerAdapter(getApplicationContext(), bannerData);
                viewPagerCar.setAdapter(newCarPagerAdapter);

                getCertificateData(certificateList);
                getFacilityData(facilityList);
                getGalleryData(gelleryData);

                for (TopCollegeDetailModel model : schoolDetailList) {
                    txtClass.setText(model.getCName());
                    txtClassName.setText(model.getCourseName());
                    txtDescription.setText(model.getCInfo());
                    txtAffiliationBy.setText(model.getAffiliation());
                    txtCall.setText(model.getCPhone1());
                    txtAddress.setText(model.getCAddress());
                    txtWeb.setText(model.getCWebsite());
                    txtEmail.setText(model.getCEmail());
                    txtToolbar.setText(model.getCName());
                    broAddress = model.getBrochure();

                }

            }

            @Override
            public void collegeDetailFailed(String msg) {

            }
        });*/

        new TopUniversityDetailApi(cId, courseId, branchId, new TopUniversityDetailApi.OnUniversityDetailListner() {
            @Override
            public void UniversityDetailSuccess(List<UniGalleryModel> galleryList,
                                                List<UniBannerModel> bannerList,
                                                List<UniCertificateModel> certificateList,
                                                List<UniFacilityModel> facilityList,
                                                List<UniDetailModel> schoolDetailList) {
                ArrayList<String> bannerData = new ArrayList<>();
                for (UniBannerModel model : bannerList) {
                    bannerData.add(model.getName());
                }

                ArrayList<String> gelleryData = new ArrayList<>();
                for (UniGalleryModel model : galleryList) {
                    gelleryData.add(model.getName());
                }

                ViewPager viewPagerCar = (ViewPager) findViewById(R.id.pagerBanner);
                SchoolBannerAdapter newCarPagerAdapter = new SchoolBannerAdapter(getApplicationContext(), bannerData);
                viewPagerCar.setAdapter(newCarPagerAdapter);

                getCertificateData(certificateList);
                getFacilityData(facilityList);
                getGalleryData(gelleryData);

                for (UniDetailModel model : schoolDetailList) {
                    txtClass.setText(model.getUName());
                    txtClassName.setText(model.getCourseName());
                    txtDescription.setText(model.getUInfo());
                    txtAffiliationBy.setText(model.getAffiliation());
                    txtCall.setText(model.getUPhone1());
                    txtAddress.setText(model.getUAddress());
                    txtWeb.setText(model.getUWebsite());
                    txtEmail.setText(model.getUEmail());
                    txtToolbar.setText(model.getUName());
                    broAddress = model.getBrochure();

                }
            }

            @Override
            public void UniversityDetailFailed(String msg) {

            }
        });
    }

    private void getGalleryData(final List<String> galleryList) {
        RcycleViewLayoutItem imgSch = new RcycleViewLayoutItem<>("carName",
                R.id.id_img_glr,
                new RcycleViewLayoutItem.DisplayLayoutItem<String>() {
                    @Override
                    public void displayLayoutItem(View view, String model) {
                        Log.d("TAGGG", model.toString());
                        try {
                            Picasso.with(getApplicationContext()).load(model.toString())
                                    .into((ImageView) view);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                null);

        RcycleViewLayoutItem image = new RcycleViewLayoutItem<>("onClick",
                R.id.imageLay,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<String>() {
                    @Override
                    public void layoutItemOnClick(View view, String model) {
                        Intent i = new Intent(getApplicationContext(), UniversityGalleryActivity.class);
                        i.putStringArrayListExtra("List", (ArrayList<String>) galleryList);
                        startActivity(i);
                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerGallery,
                R.layout.certificate_single_item,
                galleryList);

        rcView.addLayoutItem(imgSch);
        rcView.addLayoutItem(image);

        rcView.renderHorizontalRecyclerViewAct();
    }

    private void getFacilityData(List<UniFacilityModel> facilityList) {
        RcycleViewLayoutItem imgSch = new RcycleViewLayoutItem<>("carName",
                R.id.img_pfl_pic,
                new RcycleViewLayoutItem.DisplayLayoutItem<UniFacilityModel>() {
                    @Override
                    public void displayLayoutItem(View view, UniFacilityModel model) {
                        Log.d("MODEL", model.getImage());
                        try {
                            Picasso.with(getApplicationContext()).load(model.getImage())
                                    .into((ImageView) view);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                null);

        RcycleViewLayoutItem name = new RcycleViewLayoutItem<>("carName",
                R.id.id_tv,
                new RcycleViewLayoutItem.DisplayLayoutItem<CollegeFacilityModel>() {
                    @Override
                    public void displayLayoutItem(View view, CollegeFacilityModel model) {
                        Log.d("TAGGG", model.toString());
                        ((TextView) view).setText(model.getName());
                    }
                },
                null);

        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerfacility,
                R.layout.school_facility,
                facilityList);

        rcView.addLayoutItem(imgSch);
        rcView.addLayoutItem(name);

        rcView.renderHorizontalRecyclerViewAct();
    }

    private void getCertificateData(List<UniCertificateModel> certificateList) {
        RcycleViewLayoutItem imgSch = new RcycleViewLayoutItem<>("carName",
                R.id.imgSchool,
                new RcycleViewLayoutItem.DisplayLayoutItem<String>() {
                    @Override
                    public void displayLayoutItem(View view, String model) {
                        Log.d("TAGGG", model.toString());
                        try {
                            Picasso.with(getApplicationContext()).load(model.toString())
                                    .into((ImageView) view);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                null);

        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerCertificate,
                R.layout.certificate_single_item,
                certificateList);

        rcView.addLayoutItem(imgSch);

        rcView.renderHorizontalRecyclerViewAct();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.brochureLay:
                Intent intent = new Intent(this, PdfViewActivity.class);
                intent.putExtra("pdfUrl", broAddress);
                startActivity(intent);
                break;

            case R.id.btnApply:
                Intent intent1 = new Intent(this, UniversitySubmitApplicationActivity.class);
                startActivity(intent1);
                break;
            case R.id.callLay:

                break;

            case R.id.chatLay:

                break;

        }
    }
}
