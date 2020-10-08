package com.morlag.nails.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.style.TtsSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.morlag.nails.R;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ChoiseTimeFragment extends Fragment {
    public static ChoiseTimeFragment newInstance() {
        Bundle args = new Bundle();
        ChoiseTimeFragment fragment = new ChoiseTimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View.OnClickListener onTimeButtonClick;
    Long lDate;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_choise_time,container,false);

        TextView txtDate = v.findViewById(R.id.text_date);
        lDate = getActivity().getIntent().getLongExtra("date",0);
        if(lDate == 0)
            return v;
        txtDate.setText(convertTime(lDate));

        return v;
    }
    public String convertTime(long time){
        Date date = new Date(time);
        Format format = new SimpleDateFormat("EEEE\nd MMMM",new Locale("ru"));
        String res = format.format(date);
        res = res.substring(0,1).toUpperCase() + res.substring(1);
        return res;
    }
    public void onTimeButtonClick(View view) {
        String time = ((Button)view).getText().toString();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(lDate);
        String res = format.format(date) + " " + time;
        Intent intent = new Intent();
        intent.putExtra("datetime",res);
        getActivity().setResult(Activity.RESULT_OK,intent);
        getActivity().finish();
    }


}
