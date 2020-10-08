package com.morlag.nails.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.morlag.nails.FormedFragmentActivity;
import com.morlag.nails.fragments.ChoiseTimeFragment;

public class ChoiseTimeActivity extends FormedFragmentActivity {

    ChoiseTimeFragment mFragment;
    @Override
    protected Fragment getFragment() {
        mFragment = ChoiseTimeFragment.newInstance();
        return mFragment;
    }
    public void onTimeButtonClick(View view) {
        if(mFragment != null)
            mFragment.onTimeButtonClick(view);
    }
}