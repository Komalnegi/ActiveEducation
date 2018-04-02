
package com.example;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CollegeBaseResponse {

    @SerializedName("gallery")
    @Expose
    private List<Gallery> gallery = null;
    @SerializedName("banner")
    @Expose
    private List<Banner> banner = null;
    @SerializedName("certificate")
    @Expose
    private List<Certificate> certificate = null;
    @SerializedName("facility")
    @Expose
    private List<Facility> facility = null;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public List<Gallery> getGallery() {
        return gallery;
    }

    public void setGallery(List<Gallery> gallery) {
        this.gallery = gallery;
    }

    public List<Banner> getBanner() {
        return banner;
    }

    public void setBanner(List<Banner> banner) {
        this.banner = banner;
    }

    public List<Certificate> getCertificate() {
        return certificate;
    }

    public void setCertificate(List<Certificate> certificate) {
        this.certificate = certificate;
    }

    public List<Facility> getFacility() {
        return facility;
    }

    public void setFacility(List<Facility> facility) {
        this.facility = facility;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}
