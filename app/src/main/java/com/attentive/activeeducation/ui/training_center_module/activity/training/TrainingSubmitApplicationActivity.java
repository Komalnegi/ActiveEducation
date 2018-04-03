package com.attentive.activeeducation.ui.coaching_module.activity.coaching;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.attentive.activeeducation.R;
import com.attentive.activeeducation.adapter.TabAdapter;
import com.attentive.activeeducation.ui.coaching_module.fragment.apply.CoachingEducationalDetailFragment;
import com.attentive.activeeducation.ui.coaching_module.fragment.apply.CoachingMakePaymentFragment;
import com.attentive.activeeducation.ui.coaching_module.fragment.apply.CoachingPersonalDetailFragment;
import com.attentive.activeeducation.ui.university_module.fragment.apply.UniEducationalDetailFragment;
import com.attentive.activeeducation.ui.university_module.fragment.apply.UniMakePaymentFragment;
import com.attentive.activeeducation.ui.university_module.fragment.apply.UniPersonalDetailFragment;


public class CoachingSubmitApplicationActivity extends AppCompatActivity {

    private TabLayout tablayoutApply;
    private ViewPager viewpagerApply;
    private int[] tabIcons = {
            R.drawable.ic_new_edt_profile,
            R.drawable.ic_educational,
            R.drawable.ic_card_pay
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit_application);

        getIds();
    }

    private void getIds() {
        viewpagerApply = (ViewPager) findViewById(R.id.viewpagerApply);
        tablayoutApply = (TabLayout) findViewById(R.id.tablayoutApply);

        tablayoutApply.setupWithViewPager(viewpagerApply);
        setUpPager(viewpagerApply);
        setupTabIcons();
    }

    private void setUpPager(ViewPager viewpager) {
        Bundle bundle1 = new Bundle();

        TabAdapter adapter = new TabAdapter(getSupportFragmentManager());
        CoachingPersonalDetailFragment fragobj1 = CoachingPersonalDetailFragment.newInstance(bundle1);
        fragobj1.setArguments(bundle1);
        adapter.addFragment(fragobj1, "Personal Detail");

        CoachingEducationalDetailFragment fragment1 = CoachingEducationalDetailFragment.newInstance(bundle1);
        fragment1.setArguments(bundle1);
        adapter.addFragment(fragment1, "Educational Detail");

        CoachingMakePaymentFragment fragment = CoachingMakePaymentFragment.newInstance(bundle1);
        fragment.setArguments(bundle1);
        adapter.addFragment(fragment, "Make Payment");


        viewpager.setAdapter(adapter);
    }

    private void setupTabIcons() {
        tablayoutApply.getTabAt(0).setIcon(tabIcons[0]);
        tablayoutApply.getTabAt(1).setIcon(tabIcons[1]);
        tablayoutApply.getTabAt(2).setIcon(tabIcons[2]);
    }
}
