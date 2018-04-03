package com.attentive.activeeducation.ui.coaching_module.api;

import android.util.Log;

import com.attentive.activeeducation.api.BaseApi;
import com.attentive.activeeducation.constant.AppConstant;
import com.attentive.activeeducation.ui.coaching_module.model.CoachingBaseResponse;
import com.attentive.activeeducation.ui.coaching_module.model.CoachingDealModel;
import com.google.gson.Gson;

import org.json.JSONException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

/**
 * Created by vinod on 28/3/18.
 */

public class TopCoachingApi extends BaseApi {

    private static final String TAG = "TopSchoolApi";
    private OnTopDealListner onTopDealListner;

    public interface OnTopDealListner {
        void coachingListSuccess(List<CoachingDealModel> schoolModels);

        void coachingListCourseFailed(String msg);
    }

    public TopCoachingApi(final OnTopDealListner onTopDealListner) {
        this.onTopDealListner = onTopDealListner;
        BaseApi();
    }

    @Override
    public void onApiResponse(String response) throws JSONException {
        try {
            Log.d(TAG, response);
            InputStream in = new ByteArrayInputStream(response.getBytes());
            Gson gson = new Gson();
            Reader reader = new InputStreamReader(in);

            CoachingBaseResponse baseResponses = gson.fromJson(reader, CoachingBaseResponse.class);
            onTopDealListner.coachingListSuccess(baseResponses.getData());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public HashMap<String, String> getApiData() {
        HashMap<String, String> data = new HashMap<>();
        return data;
    }

    @Override
    public String requestType() {
        return AppConstant.REQUEST_TYPE_STRING;
    }

    @Override
    public String getApiUrl() {
        return AppConstant.TOP_COACHING_DEAL_URL;
    }

    @Override
    public boolean isAuthRequired() {
        return false;
    }
}
