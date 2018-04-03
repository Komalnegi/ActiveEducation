package com.attentive.activeeducation.ui.college_module.fragment.apply;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attentive.activeeducation.R;

/**
 * Created by vinod on 27/3/18.
 */

public class CollegeMakePaymentFragment extends Fragment {
    private View view;


    public static CollegeMakePaymentFragment newInstance(Bundle b) {
        CollegeMakePaymentFragment fragment = new CollegeMakePaymentFragment();
        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_make_payment, container, false);

        return view;
    }

}
