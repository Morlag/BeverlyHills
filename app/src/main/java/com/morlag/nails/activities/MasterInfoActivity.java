package com.morlag.nails.activities;

import androidx.fragment.app.Fragment;

import com.morlag.nails.FormedFragmentActivity;
import com.morlag.nails.fragments.MasterInfoFragment;

public class MasterInfoActivity extends FormedFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return MasterInfoFragment.newInstance();
    }
}
