package com.attentive.activeeducation.ui.coaching_module.fragment.coaching_backend;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attentive.activeeducation.R;

/**
 * Created by vinod on 28/3/18.
 */

public class CoachingDashboardFragment extends Fragment {
    private View view;


    public static CoachingDashboardFragment newInstance(Bundle b) {
        CoachingDashboardFragment fragment = new CoachingDashboardFragment();
        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_school_dashboard, container, false);

        return view;
    }

}

