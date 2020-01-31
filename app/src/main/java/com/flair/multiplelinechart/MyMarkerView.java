
package com.flair.multiplelinechart;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;


/**
 * Custom implementation of the MarkerView.
 * 
 * @author Philipp Jahoda
 */
public class MyMarkerView extends MarkerView {

    private TextView titleTxt,dateTxt;
    RelativeLayout markerParentRelLay;

    public MyMarkerView(Context context, int layoutResource) {
        super(context, layoutResource);
        markerParentRelLay =  findViewById(R.id.markerParentRelLay);
        titleTxt =  findViewById(R.id.titleTxt);
        dateTxt =  findViewById(R.id.dateTxt);
    }

    // callbacks everytime the MarkerView is redrawn, can be used to update the
    // content (user-interface)
    @Override
    public void refreshContent(Entry e, Highlight highlight) {



       if(highlight.getDataSetIndex()==0) {
           markerParentRelLay.setVisibility(View.VISIBLE);
           if (e instanceof CandleEntry) {

               CandleEntry ce = (CandleEntry) e;

               titleTxt.setText("" + Utils.formatNumber(ce.getHigh(), 0, true));
           } else {
               String value = "" + Utils.formatNumber(e.getY(), 0, true);
               dateTxt.setText("on 23-01-2020");
               titleTxt.setText(value.trim());
           }
       }else{
           markerParentRelLay.setVisibility(View.GONE);
       }


        super.refreshContent(e, highlight);
    }

    @Override
    public MPPointF getOffset() {
        return new MPPointF(-(getWidth() / 2), -getHeight());
    }
}
