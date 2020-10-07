package com.morlag.nails.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.morlag.nails.R;

public class ServiceListFragment extends Fragment {
    public static ServiceListFragment newInstance() {
        Bundle args = new Bundle();
        ServiceListFragment fragment = new ServiceListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    LinearLayout list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_services_and_prices,container,false);



        list = v.findViewById(R.id.service_list);
        list.removeAllViews();
        final CheckBox[] checkBoxes;

        checkBoxes = new CheckBox[5];
        for(int i = 0; i < 5; i++){
            View service = inflater.inflate(R.layout.item_service_price,null,false);
            checkBoxes[i] = service.findViewById(R.id.cb_name);

            list.addView(service);
        }

        final Button nextButton = v.findViewById(R.id.btn_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";
                for (CheckBox cb: checkBoxes) {
                    if(cb.isChecked())
                        s+=cb.getText() + " ";
                }

                final Intent returnIntent = new Intent();
                returnIntent.putExtra("services", s);
                getActivity().setResult(Activity.RESULT_OK,returnIntent);
                getActivity().finish();
            }
        });

        return v;
    }
}
