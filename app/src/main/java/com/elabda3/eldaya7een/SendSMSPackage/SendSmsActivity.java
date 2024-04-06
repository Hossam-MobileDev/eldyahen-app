package com.elabda3.eldaya7een.SendSMSPackage;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.calendardatepicker.MonthAdapter;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;
import com.hashtag.eldya7een.R;

import java.util.Calendar;

import androidx.appcompat.app.AppCompatActivity;

public class SendSmsActivity extends AppCompatActivity implements SendSmsView,
        View.OnClickListener, CalendarDatePickerDialogFragment.OnDateSetListener,
        RadialTimePickerDialogFragment.OnTimeSetListener {

    TextView title ,date,time,numChars;
    EditText senderPhone,deliverdPhone,smsDetails;
    Button sendNowBtn,schedularBtn;

    LinearLayout schedularLinear;

    RelativeLayout timeRelative,dateRelative;

    String timeString="",dateString="";

    ProgressBar progressBar;

    SendSmsPresenterImp sendSmsPresenterImp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_sms);
        progressBar=findViewById(R.id.progress);

        title=findViewById(R.id.toolbarTitle);
        title.setText("أرسال المسجات");

        schedularLinear=findViewById(R.id.schedularLinear);
        date=findViewById(R.id.date);
        time=findViewById(R.id.time);
        timeRelative=findViewById(R.id.timeRelative);
        timeRelative.setOnClickListener(this);
        dateRelative=findViewById(R.id.dateRelative);
        dateRelative.setOnClickListener(this);
        sendNowBtn=findViewById(R.id.sendNowBtn);
        sendNowBtn.setOnClickListener(this);
        numChars=findViewById(R.id.numChars);


        senderPhone=findViewById(R.id.senderPhone);
        deliverdPhone=findViewById(R.id.deliveredPhone);
        smsDetails=findViewById(R.id.smsDetails);
        smsDetails.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                numChars.setText(charSequence.length()+"");
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        schedularBtn=findViewById(R.id.schedularBtn);
        schedularBtn.setOnClickListener(this);

        sendSmsPresenterImp=new SendSmsPresenterImp(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.schedularBtn:
                schedularLinear.setVisibility(View.VISIBLE);
                schedularBtn.setVisibility(View.GONE);
                break;
            case R.id.dateRelative:
                MonthAdapter.CalendarDay minDate=new MonthAdapter.CalendarDay();
                minDate.setDay(Calendar.getInstance().get(Calendar.YEAR),Calendar.getInstance().
                        get(Calendar.MONTH),Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                        .setOnDateSetListener(this)
                        .setDateRange(minDate, null)
                        .setDoneText("موافق")
                        .setCancelText("إالغاء")
                        ;
                cdp.show(getSupportFragmentManager(), "");
                break;

            case R.id.timeRelative:
                int hour=(Calendar.getInstance().get(Calendar.HOUR));
                int minutes=(Calendar.getInstance().get(Calendar.MINUTE));

                RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                        .setOnTimeSetListener(this)
                        .setStartTime(hour, minutes)
                        .setDoneText("موافق")
                        .setCancelText("إلغاء");
                rtpd.show(getSupportFragmentManager(), "");
                break;
            case R.id.sendNowBtn:

                if(TextUtils.isEmpty(dateString)){
                    dateString= Calendar.getInstance().get(Calendar.YEAR)+"-"+(Calendar.getInstance()
                            .get(Calendar.MONTH)+1)+"-"+Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
                }

                if(TextUtils.isEmpty(timeString)){
                    int h=(Calendar.getInstance().get(Calendar.HOUR));
                    int m=(Calendar.getInstance().get(Calendar.MINUTE));
                    timeString=h+":"+m+":"+"00";
                }
                String date=dateString+" "+timeString;

                Log.v("dada",date);
                sendSmsPresenterImp.sendSmsDataToServer(senderPhone.getText().toString(),
                        deliverdPhone.getText().toString(),smsDetails.getText().toString(),date);

                break;

        }
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        dateString=year+"-"+(monthOfYear+1)+"-"+dayOfMonth;
        date.setText(dateString);
    }

    @Override
    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
        timeString=hourOfDay+":"+minute+":"+"00";
        time.setText(timeString);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void smsSent(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

        senderPhone.setText("");
        deliverdPhone.setText("");
        smsDetails.setText("");
        date.setText("0000/00/00");
        time.setText("00:00");

        schedularLinear.setVisibility(View.GONE);
        schedularBtn.setVisibility(View.VISIBLE);



    }

    @Override
    public void showAlert(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }
}
