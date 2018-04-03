package com.attentive.activeeducation.ui.coaching_module.activity.coaching;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.recycler.RcycleViewHandler;
import com.attentive.activeeducation.recycler.RcycleViewLayoutItem;
import com.attentive.activeeducation.ui.coaching_module.api.TopCoachingApi;
import com.attentive.activeeducation.ui.coaching_module.model.CoachingDealModel;
import com.attentive.activeeducation.ui.college_module.activity.college.CollegeDetailActivity;
import com.attentive.activeeducation.ui.college_module.dialog.college.CollegeAvailableCourseDialog;
import com.attentive.activeeducation.ui.common_activity.PdfViewActivity;
import com.attentive.activeeducation.ui.university_module.model.TopUniversityDealModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CoachingDealActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    private ProgressDialog dialog;
    private LinearLayout callLay, chatLay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_deal);

        dialog = new ProgressDialog(this);
        dialog.setMessage(getResources().getString(R.string.please_wait));
        dialog.setCancelable(false);
        dialog.show();

        getIds();
    }

    private void getIds() {
        callLay = (LinearLayout) findViewById(R.id.callLay);
        callLay.setOnClickListener(this);
        chatLay = (LinearLayout) findViewById(R.id.chatLay);
        chatLay.setOnClickListener(this);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        getSchoolData();

    }

    private void getSchoolData() {
        new TopCoachingApi(new TopCoachingApi.OnTopDealListner() {
            @Override
            public void coachingListSuccess(List<CoachingDealModel> dealModels) {
                getRecyclerData(dealModels);
                dialog.dismiss();
            }

            @Override
            public void coachingListCourseFailed(String msg) {
                dialog.dismiss();
            }
        });

    }

    private void getRecyclerData(List<CoachingDealModel> collegeModels) {

        RcycleViewLayoutItem imgSch = new RcycleViewLayoutItem<>("carName",
                R.id.imgSchool,
                new RcycleViewLayoutItem.DisplayLayoutItem<CoachingDealModel>() {
                    @Override
                    public void displayLayoutItem(View view, CoachingDealModel model) {
                        Picasso.with(getApplicationContext()).load(model.getCImage())
                                .into((ImageView) view);
                    }
                },
                null);

        RcycleViewLayoutItem schoolName = new RcycleViewLayoutItem<>("carName",
                R.id.txtSchoolName,
                new RcycleViewLayoutItem.DisplayLayoutItem<CoachingDealModel>() {
                    @Override
                    public void displayLayoutItem(View view, CoachingDealModel model) {
                        ((TextView) view).setText(model.getCName());
                    }
                },
                null);


        RcycleViewLayoutItem schoolBoard = new RcycleViewLayoutItem<>("carName",
                R.id.txtSchooBoard,
                new RcycleViewLayoutItem.DisplayLayoutItem<CoachingDealModel>() {
                    @Override
                    public void displayLayoutItem(View view, CoachingDealModel model) {
                        ((TextView) view).setText(model.getCAddress());
                        //((TextView) view).setVisibility(View.GONE);
                    }
                },
                null);

        RcycleViewLayoutItem schoolYear = new RcycleViewLayoutItem<>("carName",
                R.id.txtAvailableClasses,
                new RcycleViewLayoutItem.DisplayLayoutItem<CoachingDealModel>() {
                    @Override
                    public void displayLayoutItem(View view, CoachingDealModel model) {
                        ((TextView) view).setText("Available Classes : " + model.getClassName());
                    }
                },
                null);

        RcycleViewLayoutItem school = new RcycleViewLayoutItem<>("carName",
                R.id.txtSchoolAddress,
                new RcycleViewLayoutItem.DisplayLayoutItem<CoachingDealModel>() {
                    @Override
                    public void displayLayoutItem(View view, CoachingDealModel model) {
                        ((TextView) view).setVisibility(View.GONE);
                    }
                },
                null);


        RcycleViewLayoutItem schoolclasses = new RcycleViewLayoutItem<>("carName",
                R.id.txtEstablishedYear,
                new RcycleViewLayoutItem.DisplayLayoutItem<CoachingDealModel>() {
                    @Override
                    public void displayLayoutItem(View view, CoachingDealModel model) {
                        ((TextView) view).setVisibility(View.GONE);
                    }
                },
                null);


        RcycleViewLayoutItem schoolRating = new RcycleViewLayoutItem<>("carName",
                R.id.ratingSchool,
                new RcycleViewLayoutItem.DisplayLayoutItem<CoachingDealModel>() {
                    @Override
                    public void displayLayoutItem(View view, CoachingDealModel model) {
                        ((RatingBar) view).setRating(Float.parseFloat(model.getRating()));
                    }
                },
                null);

        RcycleViewLayoutItem schoolDeal = new RcycleViewLayoutItem<>("carName",
                R.id.txtDiscount,
                new RcycleViewLayoutItem.DisplayLayoutItem<CoachingDealModel>() {
                    @Override
                    public void displayLayoutItem(View view, CoachingDealModel model) {
                        ((TextView) view).setText(model.getDisplayOffer() + " %");
                    }
                },
                null);

        RcycleViewLayoutItem schoolLay = new RcycleViewLayoutItem<>("onClick",
                R.id.schoolLay,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<CoachingDealModel>() {
                    @Override
                    public void layoutItemOnClick(View view, CoachingDealModel model) {
                        Intent i = new Intent(getApplicationContext(), CoachingDetailActivity.class);
                        i.putExtra("cId", model.getCId());
                        i.putExtra("classId", model.getClassId());
                        startActivity(i);
                    }
                });


        RcycleViewLayoutItem onWebAddress = new RcycleViewLayoutItem<>("onClick",
                R.id.webAddress,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<CoachingDealModel>() {
                    @Override
                    public void layoutItemOnClick(View view, CoachingDealModel model) {
                        Log.d("BROUCHER", model.getCWebsite());
                        try {
                            Intent i = new Intent(Intent.ACTION_VIEW,
                                    Uri.parse(model.getCWebsite()));
                            startActivity(i);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });

        RcycleViewLayoutItem onCall = new RcycleViewLayoutItem<>("onClick",
                R.id.callAddress,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<CoachingDealModel>() {
                    @Override
                    public void layoutItemOnClick(View view, CoachingDealModel model) {
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:" + model.getCPhone1()));
                        startActivity(intent);
                    }
                });


        RcycleViewLayoutItem onBrochure = new RcycleViewLayoutItem<>("onClick",
                R.id.brochureLay,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<CoachingDealModel>() {
                    @Override
                    public void layoutItemOnClick(View view, CoachingDealModel model) {
                        Log.d("BROUCHER", model.getBrochure());
                        try {
                            Intent intent = new Intent(getApplicationContext(), PdfViewActivity.class);
                            intent.putExtra("pdfUrl", model.getBrochure());
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                });


        RcycleViewLayoutItem course = new RcycleViewLayoutItem<>("onClick",
                R.id.courseLay,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<CoachingDealModel>() {
                    @Override
                    public void layoutItemOnClick(View view, CoachingDealModel model) {
                        Intent i = new Intent(getApplicationContext(), CoachingDetailActivity.class);
                        i.putExtra("cId", model.getCId());
                        i.putExtra("classId", model.getClassId());
                        startActivity(i);

                    }
                });


        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerSchool,
                R.layout.school_deal_item,
                collegeModels);

        rcView.addLayoutItem(imgSch);
        rcView.addLayoutItem(schoolName);
        rcView.addLayoutItem(schoolBoard);
        rcView.addLayoutItem(schoolYear);
        rcView.addLayoutItem(schoolclasses);
        rcView.addLayoutItem(schoolRating);
        rcView.addLayoutItem(onWebAddress);
        rcView.addLayoutItem(onCall);
        rcView.addLayoutItem(onBrochure);
        rcView.addLayoutItem(course);
        rcView.addLayoutItem(schoolLay);
        rcView.addLayoutItem(schoolDeal);
        rcView.addLayoutItem(school);

        rcView.render();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.callLay:

                break;

            case R.id.chatLay:

                break;

        }
    }
}
