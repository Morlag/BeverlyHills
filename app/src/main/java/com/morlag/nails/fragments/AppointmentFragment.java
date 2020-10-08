package com.morlag.nails.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.morlag.nails.R;
import com.morlag.nails.activities.CalendarActivity;
import com.morlag.nails.activities.ConfirmAppointmentActivity;
import com.morlag.nails.activities.MasterlistActivity;
import com.morlag.nails.activities.ServiceListActivity;

import static android.app.Activity.RESULT_OK;

public class AppointmentFragment extends Fragment {
    private final int EMP_REQUEST_CODE = 0;
    private final int SERVICE_REQUEST_CODE = 1;
    private final int DATETIME_REQUEST_CODE = 2;
    private final int CONFIRM_APPOINTMENT_REQUEST_CODE = 3;

    ConstraintLayout constrEmp;
    ConstraintLayout constrService;
    ConstraintLayout constrDatetime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_appointment,container,false);

        constrEmp = v.findViewById(R.id.whole_items);
        constrEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MasterlistActivity.class);
                startActivityForResult(intent,EMP_REQUEST_CODE);
            }
        });

        constrService = v.findViewById(R.id.item_service);
        constrService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ServiceListActivity.class);
                startActivityForResult(intent,SERVICE_REQUEST_CODE);
            }
        });

        constrDatetime = v.findViewById(R.id.item_datetime);
        constrDatetime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), CalendarActivity.class);
                startActivityForResult(intent,DATETIME_REQUEST_CODE);
            }
        });

        Button makeVisit = v.findViewById(R.id.btn_make_visit);
        makeVisit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(),ConfirmAppointmentActivity.class);
                startActivityForResult(i,CONFIRM_APPOINTMENT_REQUEST_CODE);
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        //super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == EMP_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                TextView txt = constrEmp.findViewById(R.id.emp_name);
                String name = data.getStringExtra("name");
                txt.setText(name);
            }
        }
        else if(requestCode == SERVICE_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                TextView txt = constrEmp.findViewById(R.id.service_name);
                String list = data.getStringExtra("services");
                txt.setText(list);
            }
        }
        else if(requestCode == DATETIME_REQUEST_CODE){
            if(resultCode == RESULT_OK){
                TextView txt = constrEmp.findViewById(R.id.datetime_name);
                String date = data.getStringExtra("datetime");
                txt.setText(date);
            }
        }
        else if(requestCode == CONFIRM_APPOINTMENT_REQUEST_CODE && resultCode == RESULT_OK)
            getActivity().finish();
    }
}
