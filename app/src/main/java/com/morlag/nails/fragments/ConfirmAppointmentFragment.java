package com.morlag.nails.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.morlag.nails.R;

public class ConfirmAppointmentFragment extends Fragment {
    public static ConfirmAppointmentFragment newInstance() {
        Bundle args = new Bundle();
        ConfirmAppointmentFragment fragment = new ConfirmAppointmentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_confirm_appointment,container,false);

        final TextView ctxt = v.findViewById(R.id.comment_label);
        final EditText com = v.findViewById(R.id.comment_edit);
        com.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ctxt.setText("Комментарий к записи, "+com.getText().toString().length()+"/150");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        return v;
    }
}
