package cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.criminal_intent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import cn.edu.buaa.yaodh.android_the_big_nerd_ranch_guide.R;

public class DatePickerFragment extends DialogFragment {
    public static final String EXTRA_DATE= "date";
    private Date mDate;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mDate = (Date)getArguments().getSerializable(EXTRA_DATE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(mDate);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        View view = getActivity().getLayoutInflater()
                .inflate(R.layout.dialog_date, null);

        final DatePicker datePicker = (DatePicker) view.findViewById(R.id.dialog_date_picker);
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mDate = new GregorianCalendar(year, monthOfYear, dayOfMonth).getTime();
                getArguments().putSerializable(EXTRA_DATE, mDate);
                Toast.makeText(getActivity(), mDate.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                int year = datePicker.getYear();
                                int month = datePicker.getMonth();
                                int day = datePicker.getDayOfMonth();
                                mDate = new GregorianCalendar(year, month, day).getTime();
                                getArguments().putSerializable(EXTRA_DATE, mDate);
                                Toast.makeText(getActivity(), mDate.toString(), Toast.LENGTH_SHORT).show();
                                sendResult(Activity.RESULT_OK);
                            }
                        })
                .create();
    }

    private void sendResult(int resultCode) {
        if(getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, mDate);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }

    public static DatePickerFragment newInstance(Date date) {
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_DATE, date);
        DatePickerFragment fragment = new DatePickerFragment();
        fragment.setArguments(args);
        return fragment;
    }
}
