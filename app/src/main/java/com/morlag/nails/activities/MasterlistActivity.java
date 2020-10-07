package com.morlag.nails.activities;

import androidx.fragment.app.Fragment;

import com.morlag.nails.FormedFragmentActivity;
import com.morlag.nails.fragments.MasterlistFragment;

public class MasterlistActivity extends FormedFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return MasterlistFragment.newInstance();
    }
}
