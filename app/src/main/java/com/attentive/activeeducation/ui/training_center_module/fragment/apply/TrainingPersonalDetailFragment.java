package com.attentive.activeeducation.ui.coaching_module.fragment.apply;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.constant.Constant;
import com.attentive.activeeducation.helper.Helper;

import java.util.Calendar;

/**
 * Created by vinod on 27/3/18.
 */

public class CoachingPersonalDetailFragment extends Fragment implements View.OnClickListener{
    private View view;
    private EditText mFirstName,mLastName,mFatherName,mMobile,mEmail,mCategory,mDOB,mAddress,mPinCode,mReferral;
    private TextView mState,mCity;
    private LinearLayout mParentLay;
    private RadioGroup mGender;
    private Button mSubmit;
    private Calendar calendar;
    private int mYear, mMonth, mDay;


    public static CoachingPersonalDetailFragment newInstance(Bundle b) {
        CoachingPersonalDetailFragment fragment = new CoachingPersonalDetailFragment();
        fragment.setArguments(b);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.peronal_detail_fragment, container, false);

        getIds();

        return view;
    }

    private void getIds() {
        mFirstName = (EditText) view.findViewById(R.id.edt_first_name);
        mLastName = (EditText) view.findViewById(R.id.edt_last_name);
        mFatherName = (EditText) view.findViewById(R.id.edt_fth_name);
        mMobile = (EditText) view.findViewById(R.id.edt_mobile);
        mEmail = (EditText) view.findViewById(R.id.edt_email);
        mCategory = (EditText) view.findViewById(R.id.edt_category);
        mDOB = (EditText) view.findViewById(R.id.edt_dob);
        mDOB.setOnClickListener(this);
        mAddress = (EditText) view.findViewById(R.id.edt_add);
        mState = (TextView) view.findViewById(R.id.txt_state);
        mState.setOnClickListener(this);
        mCity = (TextView) view.findViewById(R.id.txt_city);
        mCity.setOnClickListener(this);
        mPinCode = (EditText) view.findViewById(R.id.edt_pincode);

        mParentLay = (LinearLayout) view.findViewById(R.id.parent_lay);

        mGender = (RadioGroup) view.findViewById(R.id.radio_group_gender);

        mSubmit = (Button) view.findViewById(R.id.btn_submit);
        mSubmit.setOnClickListener(this);
    }



    private boolean checkValidation() {
        if (mFirstName.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_valid_first_name), mParentLay);
            return false;
        } else if (mLastName.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_valid_last_name), mParentLay);
            return false;
        }else if (mFatherName.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_valid_father_name), mParentLay);
            return false;
        }else if (mGender.getCheckedRadioButtonId() == -1) {
            Helper.showSnakBar(getString(R.string.fill_gender), mParentLay);
            return false;
        }else if (mMobile.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_mobile), mParentLay);
            return false;
        }else if (mEmail.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_email), mParentLay);
            return false;
        }else if (!mEmail.getText().toString().matches(Constant.EMAIL_PATTERN_REGEX)) {
            Helper.showSnakBar(getString(R.string.fill_valid_email), mParentLay);
            return false;
        }else if (mCategory.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_cat), mParentLay);
            return false;
        }else if (mDOB.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_dob), mParentLay);
            return false;
        }else if (mAddress.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_add), mParentLay);
            return false;
        }else if (mState.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_state), mParentLay);
            return false;
        }else if (mCity.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_city), mParentLay);
            return false;
        }else if (mPinCode.getText().toString().length() == 0) {
            Helper.showSnakBar(getString(R.string.fill_pincode), mParentLay);
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id){
            case R.id.edt_dob:
                calendar = Calendar.getInstance();
                mYear = calendar.get(Calendar.YEAR);
                mMonth = calendar.get(Calendar.MONTH);
                mDay = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                /*Log.d(TAG, "Current Year ->" + mYear + "   Selected year" + year);*/
                                mDOB.setText(year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);
                                mDOB.setTextColor(getResources().getColor(R.color.black));
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
                break;

            case R.id.txt_state:
                break;

            case R.id.btn_submit:
                if (checkValidation()){

                }
                break;
        }

    }
}