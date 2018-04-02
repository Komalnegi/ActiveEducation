package com.attentive.activeeducation.ui.college_module.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by vinod on 29/3/18.
 */

public class CollegeAllCourseModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fee")
    @Expose
    private String fee;
    @SerializedName("display_offer")
    @Expose
    private String displayOffer;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getDisplayOffer() {
        return displayOffer;
    }

    public void setDisplayOffer(String displayOffer) {
        this.displayOffer = displayOffer;
    }
}
