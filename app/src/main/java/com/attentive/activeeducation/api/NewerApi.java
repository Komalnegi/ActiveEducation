package com.attentive.activeeducation.api;

import android.util.Log;

import com.attentive.activeeducation.constant.AppConstant;
import com.attentive.activeeducation.model.NewOfferModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by user on 12-01-2017.
 */

public class NewerApi extends BaseApi {

    private static final String TAG = "NewOfferApi";
    private OnNewOfferListner onNewOfferListner;
    private ArrayList<NewOfferModel> newOfferList = new ArrayList<>();

    public interface OnNewOfferListner {
        void newOfferSuccess(ArrayList<NewOfferModel> newOfferList);
        void newOfferFailed(String msg);
    }

    public NewerApi(final OnNewOfferListner onNewOfferListner) {
        this.onNewOfferListner = onNewOfferListner;
        BaseApi();
        /**/
    }

    @Override
    public void onApiResponse(String response) throws JSONException {
        try {
            Log.d(TAG, response);
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.optJSONArray("data");
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonData = jsonArray.getJSONObject(i);
                String id = jsonData.getString("id");
                String ins_id = jsonData.getString("ins_id");
                String category = jsonData.getString("category");
                String images = jsonData.getString("images");
                String is_active = jsonData.getString("is_active");
               // String is_active = jsonData.getString("is_active");

                newOfferList.add(new NewOfferModel(id, ins_id, category, images, is_active));
            }
            onNewOfferListner.newOfferSuccess(newOfferList);
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
        return AppConstant.NEW_OFFER_URL;
    }

    @Override
    public boolean isAuthRequired() {
        return false;
    }
}
