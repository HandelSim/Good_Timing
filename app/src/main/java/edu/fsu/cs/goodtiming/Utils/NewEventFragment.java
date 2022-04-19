package edu.fsu.cs.goodtiming.Utils;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.text.DateFormat;
import java.util.Calendar;

import edu.fsu.cs.goodtiming.EventFragment;
import edu.fsu.cs.goodtiming.R;


public class NewEventFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;


    public static NewEventFragment newInstance(String param1, String param2) {
        NewEventFragment fragment = new NewEventFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public NewEventFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, dayOfMonth);

        String currentDateString = DateFormat.getDateInstance().format(c.getTime());

    }

    private DatePickerDialog.OnDateSetListener dateSetListener;
    private EditText etdate;
    private EditText etname;
    private EditText ettime;
    private Button btnDate;
    private Button btnSun;
    private Button btnMon;
    private Button btnTue;
    private Button btnWed;
    private Button btnThu;
    private Button btnFri;
    private Button btnSat;
    private Button btnDone;
    private Button btnTime;
    private Button btnCancel;
    private Button btnReset;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_new_event, container, false);

        btnSun = rootView.findViewById(R.id.Sunday);
        btnMon = rootView.findViewById(R.id.Monday);
        btnTue = rootView.findViewById(R.id.Tuesday);
        btnWed = rootView.findViewById(R.id.Wednesday);
        btnThu = rootView.findViewById(R.id.Thursday);
        btnFri = rootView.findViewById(R.id.Friday);
        btnSat = rootView.findViewById(R.id.Saturday);
        btnDate = rootView.findViewById(R.id.Date);
        btnTime = rootView.findViewById(R.id.Time);
        btnDone = rootView.findViewById(R.id.Done);
        btnCancel = rootView.findViewById(R.id.Cancel);
        btnReset = rootView.findViewById(R.id.Reset);
        etname = rootView.findViewById(R.id.NameT);
        etdate = rootView.findViewById(R.id.DateT);
        ettime = rootView.findViewById(R.id.TimeT);



        btnSun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            btnSun.setEnabled(false);
            }


        });

        btnMon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnMon.setEnabled(false);
            }


        });
        btnTue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnTue.setEnabled(false);
            }


        });
        btnWed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnWed.setEnabled(false);
            }


        });
        btnThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnThu.setEnabled(false);
            }


        });
        btnFri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnFri.setEnabled(false);
            }


        });
        btnSat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSat.setEnabled(false);
            }


        });


        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (etname.length()==0)
                {
                    etname.setError("Please name the event");
                }else if (etdate.length()==0)
                {
                    etdate.setError("Please enter a date");
                }else if (ettime.length()==0)
                {
                    ettime.setError("Please enter a time");
                }

            }

        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventFragment EventFragment = new EventFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame,EventFragment);
                fragmentTransaction.commit();
            }


        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NewEventFragment NewEventFragment = new NewEventFragment();
                FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_frame,NewEventFragment);
                fragmentTransaction.commit();
            }


        });


        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(getContext(), android.R.style.Theme_DeviceDefault_Dialog, dateSetListener, year, month,day);

                dialog.show();
            }

        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                Log.d(TAG, "onDataSet: dd/mm/yyyy: " + day + "/" + month + "/" + year);

                String date = day + "/" + month + "/" + year;
                etdate.setText(date);
            }
        };

        int hour;
        int minute1;

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }


        });


        return rootView;
    }



}