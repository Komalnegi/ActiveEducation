package com.attentive.activeeducation.ui.coaching_module.api;

import android.util.Log;

import com.attentive.activeeducation.api.BaseApi;
import com.attentive.activeeducation.constant.AppConstant;
import com.attentive.activeeducation.ui.coaching_module.model.coachin_detail.CoachinCertificateModel;
import com.attentive.activeeducation.ui.coaching_module.model.coachin_detail.CoachingBannerModel;
import com.attentive.activeeducation.ui.coaching_module.model.coachin_detail.CoachingDetailModel;
import com.attentive.activeeducation.ui.coaching_module.model.coachin_detail.CoachingDetailResponse;

import com.attentive.activeeducation.ui.coaching_module.model.coachin_detail.CoachingFacilityModel;
import com.attentive.activeeducation.ui.coaching_module.model.coachin_detail.CoachingGalleryModel;
import com.attentive.activeeducation.ui.university_module.model.UniBannerModel;
import com.attentive.activeeducation.ui.university_module.model.UniCertificateModel;
import com.attentive.activeeducation.ui.university_module.model.UniDetailModel;
import com.attentive.activeeducation.ui.university_module.model.UniFacilityModel;
import com.attentive.activeeducation.ui.university_module.model.UniGalleryModel;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vinod on 29/3/18.
 */

public class TopCoachingDetailApi extends BaseApi {

    private static final String TAG = "TopCoachingDetailApi";
    private OnResponseListner responseListner;
    private String cId, classId;

    public interface OnResponseListner {
        void resultSuccess(List<CoachingGalleryModel> galleryList, List<CoachingBannerModel> bannerList,
                           List<CoachinCertificateModel> certificateList, List<CoachingFacilityModel> facilityList,
                           List<CoachingDetailModel> schoolDetailList);

        void resultFailed(String msg);
    }

    public TopCoachingDetailApi(String cId, String classId, final OnResponseListner responseListner) {
        this.cId = cId;
        this.classId = classId;
        this.responseListner = responseListner;
        BaseApi();
    }

    @Override
    public void onApiResponse(String response) throws JSONException {
        try {
            Log.d(TAG, response);
            InputStream in = new ByteArrayInputStream(response.getBytes());
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(in);

            CoachingDetailResponse baseResponses = gson.fromJson(reader, CoachingDetailResponse.class);
            responseListner.resultSuccess(baseResponses.getGallery(), baseResponses.getBanner(),
                    baseResponses.getCertificate(), baseResponses.getFacility(),
                    baseResponses.getData());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public HashMap<String, String> getApiData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("c_id", cId);
        data.put("class_id", classId);
        Log.d(TAG, data.toString());
        return data;
    }

    @Override
    public String requestType() {
        return AppConstant.REQUEST_TYPE_STRING;
    }

    @Override
    public String getApiUrl() {
        return AppConstant.TOP_COACHING_DETAIL_URL;
    }

    @Override
    public boolean isAuthRequired() {
        return false;
    }
}

