package com.attentive.activeeducation.ui.college_module.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by vinod on 29/3/18.
 */

public class CollegeBaseResponse {
    @SerializedName("data")
    @Expose
    private List<CollegeAllCourseModel> data = null;

    public List<CollegeAllCourseModel> getData() {
        return data;
    }

    public void setData(List<CollegeAllCourseModel> data) {
        this.data = data;
    }
}
