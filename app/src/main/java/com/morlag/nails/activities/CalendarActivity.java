package com.morlag.nails.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.morlag.nails.FormedFragmentActivity;
import com.morlag.nails.fragments.CalendarFragment;

public class CalendarActivity extends FormedFragmentActivity {
    @Override
    protected Fragment getFragment() {
        return CalendarFragment.newInstance();
    }
}