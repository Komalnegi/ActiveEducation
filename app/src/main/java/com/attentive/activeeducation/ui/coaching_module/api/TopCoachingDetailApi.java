package com.attentive.activeeducation.ui.university_module.api;

import android.util.Log;

import com.attentive.activeeducation.api.BaseApi;
import com.attentive.activeeducation.constant.AppConstant;
import com.attentive.activeeducation.ui.university_module.model.UniBannerModel;
import com.attentive.activeeducation.ui.university_module.model.UniCertificateModel;
import com.attentive.activeeducation.ui.university_module.model.UniDetailModel;
import com.attentive.activeeducation.ui.university_module.model.UniFacilityModel;
import com.attentive.activeeducation.ui.university_module.model.UniGalleryModel;
import com.attentive.activeeducation.ui.university_module.model.UniResponse;
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

public class TopUniversityDetailApi extends BaseApi {

    private static final String TAG = "TopSchoolDetailApi";
    private OnUniversityDetailListner onSchoolCourseListner;
    private String cId, courseId, branchId;

    public interface OnUniversityDetailListner {
        void UniversityDetailSuccess(List<UniGalleryModel> galleryList, List<UniBannerModel> bannerList,
                                     List<UniCertificateModel> certificateList, List<UniFacilityModel> facilityList,
                                     List<UniDetailModel> schoolDetailList);

        void UniversityDetailFailed(String msg);
    }

    public TopUniversityDetailApi(String cId, String courseId, String branchId, final OnUniversityDetailListner onSchoolCourseListner) {
        this.cId = cId;
        this.courseId = courseId;
        this.branchId = branchId;
        this.onSchoolCourseListner = onSchoolCourseListner;
        BaseApi();
    }

    @Override
    public void onApiResponse(String response) throws JSONException {
        try {
            Log.d(TAG, response);
            InputStream in = new ByteArrayInputStream(response.getBytes());
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(in);

            UniResponse baseResponses = gson.fromJson(reader, UniResponse.class);
            onSchoolCourseListner.UniversityDetailSuccess(baseResponses.getGallery(), baseResponses.getBanner(),
                    baseResponses.getCertificate(), baseResponses.getFacility(),
                    baseResponses.getData());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public HashMap<String, String> getApiData() {
        HashMap<String, String> data = new HashMap<>();
        data.put("u_id", cId);
        data.put("course_id", courseId);
        data.put("branch_id", branchId);

        Log.d(TAG, data.toString());
        return data;
    }

    @Override
    public String requestType() {
        return AppConstant.REQUEST_TYPE_STRING;
    }

    @Override
    public String getApiUrl() {
        return AppConstant.TOP_UNIVERSITY_DETAIL_URL;
    }

    @Override
    public boolean isAuthRequired() {
        return false;
    }
}

