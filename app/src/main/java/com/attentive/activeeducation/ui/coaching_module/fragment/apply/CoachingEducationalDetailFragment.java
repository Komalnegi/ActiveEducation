package com.attentive.activeeducation.ui.college_module.fragment.apply;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.attentive.activeeducation.R;

/**
 * Created by vinod on 27/3/18.
 */

public class CollegeEducationalDetailFragment extends Fragment {
    private View view;
    private Spinner spinnerPassingYear;
    private String[] years = {"Passing Year", "1990", "1991", "1992", "1993", "1994", "1995", "1996",
            "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016",
            "2017", "2018"};


    public static CollegeEducationalDetailFragment newInstance(Bundle b) {
        CollegeEducationalDetailFragment fragment = new CollegeEducationalDetailFragment();
        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_educational_detail, container, false);

        getIds();

        return view;
    }

    private void getIds() {
        spinnerPassingYear = (Spinner) view.findViewById(R.id.spinnerPassingYear);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, years);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPassingYear.setAdapter(adapter);

    }

}
