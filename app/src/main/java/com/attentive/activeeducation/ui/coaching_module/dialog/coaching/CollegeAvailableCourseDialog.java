package com.attentive.activeeducation.ui.college_module.dialog.college;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.recycler.RcycleViewHandler;
import com.attentive.activeeducation.recycler.RcycleViewLayoutItem;
import com.attentive.activeeducation.ui.college_module.api.AllCollegeCourseApi;
import com.attentive.activeeducation.ui.college_module.model.CollegeAllCourseModel;

import java.util.ArrayList;
import java.util.List;

public class CollegeAvailableCourseDialog extends AppCompatActivity {

    private String cId;
    private TextView txtDialogTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avilable_course);

        Intent intent = getIntent();
        cId = intent.getStringExtra("cId");
        txtDialogTitle = (TextView) findViewById(R.id.txtDialogTitle);
        txtDialogTitle.setText("Available Courses");

        getCourseData(cId);

    }

    private void getCourseData(String sId) {
        new AllCollegeCourseApi(sId, new AllCollegeCourseApi.OnCollegeCourseListner() {
            @Override
            public void collegeCourseSuccess(List<CollegeAllCourseModel> schoolModels) {
                recyclerData(schoolModels);
            }

            @Override
            public void collegeCourseFailed(String msg) {

            }
        });
    }

    private void recyclerData(List<CollegeAllCourseModel> schoolModels) {

        RcycleViewLayoutItem className = new RcycleViewLayoutItem<>("activityName",
                R.id.txtClass,
                new RcycleViewLayoutItem.DisplayLayoutItem<CollegeAllCourseModel>() {
                    @Override
                    public void displayLayoutItem(View view, CollegeAllCourseModel model) {
                        ((TextView) view).setText(model.getName());

                    }
                },
                null);


        RcycleViewLayoutItem classFee = new RcycleViewLayoutItem<>("activityName",
                R.id.txtFee,
                new RcycleViewLayoutItem.DisplayLayoutItem<CollegeAllCourseModel>() {
                    @Override
                    public void displayLayoutItem(View view, CollegeAllCourseModel model) {
                        ((TextView) view).setText(model.getFee());

                    }
                },
                null);

        RcycleViewLayoutItem offer = new RcycleViewLayoutItem<>("activityName",
                R.id.txtDiscount,
                new RcycleViewLayoutItem.DisplayLayoutItem<CollegeAllCourseModel>() {
                    @Override
                    public void displayLayoutItem(View view, CollegeAllCourseModel model) {
                        ((TextView) view).setText(model.getDisplayOffer());

                    }
                },
                null);


        RcycleViewHandler rcView = new RcycleViewHandler<>(this,
                R.id.recyclerCourse,
                R.layout.course_single_item,
                schoolModels);

        rcView.addLayoutItem(className);
        rcView.addLayoutItem(classFee);
        rcView.addLayoutItem(offer);

        rcView.render();
    }
}
