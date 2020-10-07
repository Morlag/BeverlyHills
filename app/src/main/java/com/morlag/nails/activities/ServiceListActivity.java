package com.morlag.nails.activities;

import androidx.fragment.app.Fragment;

import com.morlag.nails.FormedFragmentActivity;
import com.morlag.nails.fragments.ServiceListFragment;

public class ServiceListActivity extends FormedFragmentActivity {

    @Override
    protected Fragment getFragment() {
        return ServiceListFragment.newInstance();
    }
}
