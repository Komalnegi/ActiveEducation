package com.attentive.activeeducation.ui.coaching_module.fragment.coaching_backend;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.recycler.RcycleViewHandler;
import com.attentive.activeeducation.recycler.RcycleViewLayoutItem;
import com.attentive.activeeducation.ui.school_module.dialog.schoolProfile.SchoolAccountDetailDialog;
import com.attentive.activeeducation.ui.school_module.model.school_admin.AccountModel;

import java.util.ArrayList;

/**
 * Created by vinod on 28/3/18.
 */

public class CoachingAccountFragment extends Fragment {
    private View view;
    private ArrayList<AccountModel> accountModels = new ArrayList<>();


    public static CoachingAccountFragment newInstance(Bundle b) {
        CoachingAccountFragment fragment = new CoachingAccountFragment();
        fragment.setArguments(b);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_school_account, container, false);

        getAccountData();

        return view;
    }

    private void getAccountData() {
        AccountModel model = new AccountModel("Class 1");
        accountModels.add(model);

        model = new AccountModel("Class 1");
        accountModels.add(model);

        model = new AccountModel("Class 1");
        accountModels.add(model);

        RcycleViewLayoutItem txtCheck = new RcycleViewLayoutItem<>("activitiesDesc",
                R.id.txtAccountClass,
                new RcycleViewLayoutItem.DisplayLayoutItem<AccountModel>() {
                    @Override
                    public void displayLayoutItem(View view, AccountModel model) {
                        ((CheckedTextView) view).setText(model.getClassName());
                    }
                },
                null);

        RcycleViewLayoutItem checkLay = new RcycleViewLayoutItem<>("onClick",
                R.id.btnMoreInfo,
                null,
                new RcycleViewLayoutItem.LayoutItemClickListner<AccountModel>() {
                    @Override
                    public void layoutItemOnClick(View view, AccountModel model) {
                        Intent intent = new Intent(getActivity(), SchoolAccountDetailDialog.class);
                        startActivity(intent);

                    }
                });

        RcycleViewHandler rcView = new RcycleViewHandler<>(view,
                R.id.recyclerSchoolAccount,
                R.layout.school_account_single_item,
                accountModels);


        rcView.addLayoutItem(txtCheck);
        rcView.addLayoutItem(checkLay);
        rcView.render(view);
    }

}

