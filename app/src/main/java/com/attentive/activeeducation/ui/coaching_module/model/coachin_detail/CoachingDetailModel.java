
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("c_id")
    @Expose
    private String cId;
    @SerializedName("coaching_code")
    @Expose
    private Object coachingCode;
    @SerializedName("c_name")
    @Expose
    private String cName;
    @SerializedName("c_address")
    @Expose
    private String cAddress;
    @SerializedName("c_landmark")
    @Expose
    private String cLandmark;
    @SerializedName("c_city")
    @Expose
    private String cCity;
    @SerializedName("c_state")
    @Expose
    private String cState;
    @SerializedName("c_country")
    @Expose
    private String cCountry;
    @SerializedName("c_pin")
    @Expose
    private Object cPin;
    @SerializedName("c_type")
    @Expose
    private String cType;
    @SerializedName("c_email")
    @Expose
    private String cEmail;
    @SerializedName("c_phone1")
    @Expose
    private String cPhone1;
    @SerializedName("c_phone2")
    @Expose
    private Object cPhone2;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("pwd")
    @Expose
    private String pwd;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("c_website")
    @Expose
    private String cWebsite;
    @SerializedName("c_established")
    @Expose
    private String cEstablished;
    @SerializedName("c_info")
    @Expose
    private String cInfo;
    @SerializedName("c_facility")
    @Expose
    private String cFacility;
    @SerializedName("c_image")
    @Expose
    private String cImage;
    @SerializedName("c_video")
    @Expose
    private String cVideo;
    @SerializedName("c_banner")
    @Expose
    private String cBanner;
    @SerializedName("c_certificate")
    @Expose
    private String cCertificate;
    @SerializedName("c_brochure")
    @Expose
    private Object cBrochure;
    @SerializedName("faculties")
    @Expose
    private String faculties;
    @SerializedName("speciality")
    @Expose
    private String speciality;
    @SerializedName("rating")
    @Expose
    private String rating;
    @SerializedName("terms")
    @Expose
    private String terms;
    @SerializedName("c_google")
    @Expose
    private Object cGoogle;
    @SerializedName("c_facebook")
    @Expose
    private Object cFacebook;
    @SerializedName("c_whatsapp")
    @Expose
    private Object cWhatsapp;
    @SerializedName("c_twitter")
    @Expose
    private Object cTwitter;
    @SerializedName("c_linkedin")
    @Expose
    private Object cLinkedin;
    @SerializedName("c_skype")
    @Expose
    private Object cSkype;
    @SerializedName("c_insta")
    @Expose
    private Object cInsta;
    @SerializedName("c_tumblr")
    @Expose
    private Object cTumblr;
    @SerializedName("added_date")
    @Expose
    private String addedDate;
    @SerializedName("edit_date")
    @Expose
    private String editDate;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("is_active")
    @Expose
    private String isActive;
    @SerializedName("coaching")
    @Expose
    private String coaching;
    @SerializedName("number_of_batches")
    @Expose
    private String numberOfBatches;
    @SerializedName("start_time")
    @Expose
    private String startTime;
    @SerializedName("end_time")
    @Expose
    private String endTime;
    @SerializedName("batch_strength")
    @Expose
    private String batchStrength;
    @SerializedName("class")
    @Expose
    private String _class;
    @SerializedName("subject")
    @Expose
    private String subject;
    @SerializedName("total_seats")
    @Expose
    private String totalSeats;
    @SerializedName("remaining_seats")
    @Expose
    private String remainingSeats;
    @SerializedName("subject_fee")
    @Expose
    private String subjectFee;
    @SerializedName("actual_offer")
    @Expose
    private String actualOffer;
    @SerializedName("display_offer")
    @Expose
    private String displayOffer;
    @SerializedName("top_deal")
    @Expose
    private String topDeal;
    @SerializedName("agent_id")
    @Expose
    private String agentId;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("coaching_flag")
    @Expose
    private String coachingFlag;
    @SerializedName("agent_flag")
    @Expose
    private String agentFlag;
    @SerializedName("edited_date")
    @Expose
    private String editedDate;
    @SerializedName("parent_id")
    @Expose
    private String parentId;
    @SerializedName("stream_flag")
    @Expose
    private String streamFlag;
    @SerializedName("brochure")
    @Expose
    private String brochure;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCId() {
        return cId;
    }

    public void setCId(String cId) {
        this.cId = cId;
    }

    public Object getCoachingCode() {
        return coachingCode;
    }

    public void setCoachingCode(Object coachingCode) {
        this.coachingCode = coachingCode;
    }

    public String getCName() {
        return cName;
    }

    public void setCName(String cName) {
        this.cName = cName;
    }

    public String getCAddress() {
        return cAddress;
    }

    public void setCAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getCLandmark() {
        return cLandmark;
    }

    public void setCLandmark(String cLandmark) {
        this.cLandmark = cLandmark;
    }

    public String getCCity() {
        return cCity;
    }

    public void setCCity(String cCity) {
        this.cCity = cCity;
    }

    public String getCState() {
        return cState;
    }

    public void setCState(String cState) {
        this.cState = cState;
    }

    public String getCCountry() {
        return cCountry;
    }

    public void setCCountry(String cCountry) {
        this.cCountry = cCountry;
    }

    public Object getCPin() {
        return cPin;
    }

    public void setCPin(Object cPin) {
        this.cPin = cPin;
    }

    public String getCType() {
        return cType;
    }

    public void setCType(String cType) {
        this.cType = cType;
    }

    public String getCEmail() {
        return cEmail;
    }

    public void setCEmail(String cEmail) {
        this.cEmail = cEmail;
    }

    public String getCPhone1() {
        return cPhone1;
    }

    public void setCPhone1(String cPhone1) {
        this.cPhone1 = cPhone1;
    }

    public Object getCPhone2() {
        return cPhone2;
    }

    public void setCPhone2(Object cPhone2) {
        this.cPhone2 = cPhone2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getCWebsite() {
        return cWebsite;
    }

    public void setCWebsite(String cWebsite) {
        this.cWebsite = cWebsite;
    }

    public String getCEstablished() {
        return cEstablished;
    }

    public void setCEstablished(String cEstablished) {
        this.cEstablished = cEstablished;
    }

    public String getCInfo() {
        return cInfo;
    }

    public void setCInfo(String cInfo) {
        this.cInfo = cInfo;
    }

    public String getCFacility() {
        return cFacility;
    }

    public void setCFacility(String cFacility) {
        this.cFacility = cFacility;
    }

    public String getCImage() {
        return cImage;
    }

    public void setCImage(String cImage) {
        this.cImage = cImage;
    }

    public String getCVideo() {
        return cVideo;
    }

    public void setCVideo(String cVideo) {
        this.cVideo = cVideo;
    }

    public String getCBanner() {
        return cBanner;
    }

    public void setCBanner(String cBanner) {
        this.cBanner = cBanner;
    }

    public String getCCertificate() {
        return cCertificate;
    }

    public void setCCertificate(String cCertificate) {
        this.cCertificate = cCertificate;
    }

    public Object getCBrochure() {
        return cBrochure;
    }

    public void setCBrochure(Object cBrochure) {
        this.cBrochure = cBrochure;
    }

    public String getFaculties() {
        return faculties;
    }

    public void setFaculties(String faculties) {
        this.faculties = faculties;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getTerms() {
        return terms;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public Object getCGoogle() {
        return cGoogle;
    }

    public void setCGoogle(Object cGoogle) {
        this.cGoogle = cGoogle;
    }

    public Object getCFacebook() {
        return cFacebook;
    }

    public void setCFacebook(Object cFacebook) {
        this.cFacebook = cFacebook;
    }

    public Object getCWhatsapp() {
        return cWhatsapp;
    }

    public void setCWhatsapp(Object cWhatsapp) {
        this.cWhatsapp = cWhatsapp;
    }

    public Object getCTwitter() {
        return cTwitter;
    }

    public void setCTwitter(Object cTwitter) {
        this.cTwitter = cTwitter;
    }

    public Object getCLinkedin() {
        return cLinkedin;
    }

    public void setCLinkedin(Object cLinkedin) {
        this.cLinkedin = cLinkedin;
    }

    public Object getCSkype() {
        return cSkype;
    }

    public void setCSkype(Object cSkype) {
        this.cSkype = cSkype;
    }

    public Object getCInsta() {
        return cInsta;
    }

    public void setCInsta(Object cInsta) {
        this.cInsta = cInsta;
    }

    public Object getCTumblr() {
        return cTumblr;
    }

    public void setCTumblr(Object cTumblr) {
        this.cTumblr = cTumblr;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }

    public String getEditDate() {
        return editDate;
    }

    public void setEditDate(String editDate) {
        this.editDate = editDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getCoaching() {
        return coaching;
    }

    public void setCoaching(String coaching) {
        this.coaching = coaching;
    }

    public String getNumberOfBatches() {
        return numberOfBatches;
    }

    public void setNumberOfBatches(String numberOfBatches) {
        this.numberOfBatches = numberOfBatches;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getBatchStrength() {
        return batchStrength;
    }

    public void setBatchStrength(String batchStrength) {
        this.batchStrength = batchStrength;
    }

    public String getClass_() {
        return _class;
    }

    public void setClass_(String _class) {
        this._class = _class;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(String totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getRemainingSeats() {
        return remainingSeats;
    }

    public void setRemainingSeats(String remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public String getSubjectFee() {
        return subjectFee;
    }

    public void setSubjectFee(String subjectFee) {
        this.subjectFee = subjectFee;
    }

    public String getActualOffer() {
        return actualOffer;
    }

    public void setActualOffer(String actualOffer) {
        this.actualOffer = actualOffer;
    }

    public String getDisplayOffer() {
        return displayOffer;
    }

    public void setDisplayOffer(String displayOffer) {
        this.displayOffer = displayOffer;
    }

    public String getTopDeal() {
        return topDeal;
    }

    public void setTopDeal(String topDeal) {
        this.topDeal = topDeal;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCoachingFlag() {
        return coachingFlag;
    }

    public void setCoachingFlag(String coachingFlag) {
        this.coachingFlag = coachingFlag;
    }

    public String getAgentFlag() {
        return agentFlag;
    }

    public void setAgentFlag(String agentFlag) {
        this.agentFlag = agentFlag;
    }

    public String getEditedDate() {
        return editedDate;
    }

    public void setEditedDate(String editedDate) {
        this.editedDate = editedDate;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getStreamFlag() {
        return streamFlag;
    }

    public void setStreamFlag(String streamFlag) {
        this.streamFlag = streamFlag;
    }

    public String getBrochure() {
        return brochure;
    }

    public void setBrochure(String brochure) {
        this.brochure = brochure;
    }

}
