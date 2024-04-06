package com.elabda3.eldaya7een.CalenderPackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;

import com.hashtag.eldya7een.R;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;



/**
 * Created by ebda3-mint on 10/22/17.
 */

public class CalenderDecorate implements DayViewDecorator {


    private Drawable highlightDrawable;
    private Context context;

    public CalenderDecorate( Context context) {
        this.context = context;
        highlightDrawable = this.context.getResources().getDrawable(R.drawable.circle_transparent);
    }
    @Override
    public boolean shouldDecorate(CalendarDay day) {

        return true;
    }



    @Override
    public void decorate(DayViewFacade view) {

        view.setBackgroundDrawable(highlightDrawable);
        view.addSpan(new ForegroundColorSpan(Color.WHITE));
        view.addSpan(new StyleSpan(Typeface.BOLD));
        view.addSpan(new RelativeSizeSpan(1.5f));


    }

}
