package com.morlag.nails.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.morlag.nails.R;
import com.morlag.nails.activities.MasterInfoActivity;
import com.morlag.nails.activities.MasterlistActivity;

import org.w3c.dom.Text;

public class MasterlistFragment extends Fragment {
    public static MasterlistFragment newInstance() {
        Bundle args = new Bundle();
        MasterlistFragment fragment = new MasterlistFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_masterlist,container,false);

        final ConstraintLayout master1 = v.findViewById(R.id.master1);
        master1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name = master1.findViewById(R.id.master_name);
                final Intent returnIntent = new Intent();
                returnIntent.putExtra("name",name.getText());
                getActivity().setResult(Activity.RESULT_OK,returnIntent);
                getActivity().finish();
            }
        });
        ImageView info1 = master1.findViewById(R.id.info_button);
        info1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MasterInfoActivity.class);
                startActivityForResult(intent,1);
            }
        });

        final ConstraintLayout master2 = v.findViewById(R.id.master2);
        ((TextView)master2.findViewById(R.id.master_name)).setText("Аска П.");
        master2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView name = master2.findViewById(R.id.master_name);
                Intent returnIntent = new Intent();
                returnIntent.putExtra("name",name.getText());
                getActivity().setResult(Activity.RESULT_OK,returnIntent);
                getActivity().finish();
            }
        });


        return v;
    }

}
