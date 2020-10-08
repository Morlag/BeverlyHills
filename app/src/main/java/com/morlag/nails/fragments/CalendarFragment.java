package com.morlag.nails.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.morlag.nails.R;
import com.morlag.nails.activities.ChoiseTimeActivity;

import java.util.Date;

import static android.app.Activity.RESULT_OK;

public class CalendarFragment extends Fragment {
    public static CalendarFragment newInstance() {
        Bundle args = new Bundle();
        CalendarFragment fragment = new CalendarFragment();
        fragment.setArguments(args);
        return fragment;
    }

    long currentDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calendar,container,false);

        final CalendarView cal = v.findViewById(R.id.calendarView);
        cal.setMinDate(Calendar.getInstance().getTimeInMillis());
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String d = i+"-"+(i1+1)+"-"+i2;
                try {
                    Date date = format.parse(d);
                    currentDate = date.getTime();
                }catch (Exception ex){}
            }
        });
        cal.setDate(Calendar.getInstance().getTimeInMillis());

        Button back = v.findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
            }
        });

        Button next = v.findViewById(R.id.btn_next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChoiseTimeActivity.class);
                intent.putExtra("date", currentDate);
                startActivityForResult(intent,0);
            }
        });


        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 0 && resultCode == RESULT_OK){
            String date = data.getStringExtra("datetime");
            if(date == null)
                return;
            getActivity().setResult(RESULT_OK,data);
            getActivity().finish();
        }
    }
}
