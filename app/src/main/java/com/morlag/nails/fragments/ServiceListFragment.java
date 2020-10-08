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
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.morlag.nails.R;

import org.w3c.dom.Text;

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
        final TextView[] prices;

        checkBoxes = new CheckBox[5];
        prices = new TextView[5];
        for(int i = 0; i < 5; i++){
            View service = inflater.inflate(R.layout.item_service_price,null,false);
            checkBoxes[i] = service.findViewById(R.id.cb_name);
            final int ii = i;
            service.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    checkBoxes[ii].setChecked(!checkBoxes[ii].isChecked());
                }
            });
            checkBoxes[i].setClickable(false);
            prices[i] = service.findViewById(R.id.price);

            list.addView(service);
        }

        final Button nextButton = v.findViewById(R.id.btn_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "";
                double price = 0;
                for (int i = 0; i<checkBoxes.length;i++) {
                    if(checkBoxes[i].isChecked()) {
                        s += checkBoxes[i].getText() + " ";
                        String temp_price = prices[i].getText().toString();
                        price += Double.parseDouble(temp_price.substring(0,temp_price.length()-1));
                    }
                }

                final Intent returnIntent = new Intent();
                returnIntent.putExtra("services", s);
                returnIntent.putExtra("price", price);
                getActivity().setResult(Activity.RESULT_OK,returnIntent);
                getActivity().finish();
            }
        });

        return v;
    }
}
