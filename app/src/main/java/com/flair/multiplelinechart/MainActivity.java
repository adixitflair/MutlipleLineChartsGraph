package com.flair.multiplelinechart;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private LineChart mChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        mChart = findViewById(R.id.chart);
        setGraph();
    }


    public void setGraph() {



        ArrayList<Entry> entriesSecondLineChart = new ArrayList<>();
        entriesSecondLineChart.add(new Entry(0, 2));
        entriesSecondLineChart.add(new Entry(1, 2));
        entriesSecondLineChart.add(new Entry(2, 3));
        entriesSecondLineChart.add(new Entry(3, 4));
        entriesSecondLineChart.add(new Entry(4, 5));
        entriesSecondLineChart.add(new Entry(5, 7));
        entriesSecondLineChart.add(new Entry(6, 10));


        LineDataSet lineDataSet2 = new LineDataSet(entriesSecondLineChart, "");
        lineDataSet2.setCircleRadius(0f);
        lineDataSet2.setCircleHoleRadius(0f);
        lineDataSet2.setDrawCircles(false);
        // set graph to fill color
        lineDataSet2.setDrawFilled(true);
        lineDataSet2.setValueTextSize(0f);
        //set graph color
        Drawable drawable1 = ContextCompat.getDrawable(this, R.drawable.graph_2_bg);
        lineDataSet2.setFillDrawable(drawable1);
        lineDataSet2.setColor(Color.parseColor("#45F12121"));
        // hide vertical and horizontal HighlightIndicator
        lineDataSet2.setDrawHorizontalHighlightIndicator(false);
        lineDataSet2.setDrawVerticalHighlightIndicator(false);


        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 4, getResources().getDrawable(R.drawable.graph_transparent_point_bg)));
        entries.add(new Entry(1, 4, getResources().getDrawable(R.drawable.graph_point_bg)));
        entries.add(new Entry(2, 2, getResources().getDrawable(R.drawable.graph_point_bg)));
        entries.add(new Entry(3, 3, getResources().getDrawable(R.drawable.graph_point_bg)));
        entries.add(new Entry(4, 2, getResources().getDrawable(R.drawable.graph_point_bg)));
        entries.add(new Entry(5, 4, getResources().getDrawable(R.drawable.graph_point_bg)));
        entries.add(new Entry(6, 5, getResources().getDrawable(R.drawable.graph_point_bg)));


        XAxis xAxis = mChart.getXAxis();
        xAxis.setAxisLineColor(Color.parseColor("#FFFFFF"));
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(13);
        final String[] months = new String[]{"", "1yr", "2yr", "3yr", "4yr", "5yr", "6yr"};
        ValueFormatter formatter = new ValueFormatter() {
            @Override
            public String getFormattedValue(float value) {
                return months[(int) value];
            }
        };
        xAxis.setTextColor(Color.parseColor("#A7A7A7"));
        xAxis.setValueFormatter(formatter);
        xAxis.setGridLineWidth(1f);
        xAxis.setTextSize(14);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.setYOffset(12);


        // y axis right
        YAxis yAxisRight = mChart.getAxisRight();
        yAxisRight.setEnabled(true);
        yAxisRight.setAxisLineColor(Color.parseColor("#FFFFFF"));
        yAxisRight.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxisRight.setGridColor(Color.parseColor("#FFFFFF"));
        yAxisRight.setAxisMinimum(0f);


       // y axis unit in kg
        MyValueFormatter myValueFormatter = new MyValueFormatter(" kg");
        YAxis yAxisLeft = mChart.getAxisLeft();
        yAxisLeft.setTextColor(Color.parseColor("#A7A7A7"));
        yAxisLeft.setTextSize(14);
        yAxisLeft.setValueFormatter(myValueFormatter);
        yAxisLeft.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        yAxisLeft.setGridLineWidth(2f);
        yAxisLeft.setXOffset(12);
        yAxisLeft.setAxisMinimum(0f);
        yAxisLeft.setDrawLimitLinesBehindData(true);
        xAxis.setDrawLimitLinesBehindData(true);


        LineDataSet lineDataSet1 = new LineDataSet(entries, "");
        lineDataSet1.setDrawIcons(false);
        lineDataSet1.setLineWidth(01f);
        lineDataSet1.setColor(Color.parseColor("#45F12121"));
        lineDataSet1.setCircleHoleRadius(0f);
        lineDataSet1.setCircleRadius(0f);

        lineDataSet1.setDrawFilled(true);
        lineDataSet1.setValueTextSize(0f);
        lineDataSet1.setDrawHorizontalHighlightIndicator(true);
        lineDataSet1.setDrawVerticalHighlightIndicator(true);
        lineDataSet1.setHighLightColor(getResources().getColor(R.color.color_FFFFFF));
        lineDataSet1.setHighlightLineWidth(1f);



        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.graph_1_bg);
        lineDataSet1.setFillDrawable(drawable);

        mChart.getAxisRight().setEnabled(false);
        mChart.setExtraOffsets(0, 0, 0, 30);
        mChart.getAxisLeft().setGridColor(Color.parseColor("#F5615B"));
        mChart.getAxisRight().setGridColor(Color.parseColor("#FFFFFF"));
        mChart.getXAxis().setGridLineWidth(.5f);
        mChart.getAxisLeft().setGridLineWidth(1f);
        mChart.getXAxis().setAxisLineWidth(.5f);
        mChart.getAxisRight().setGridLineWidth(1f);
        //
        mChart.getXAxis().setAxisMinimum(0);
        // hide the description
        mChart.getDescription().setEnabled(false);
        mChart.getLegend().setEnabled(false);


        ArrayList<ILineDataSet> sets = new ArrayList<>();
        lineDataSet1.setDrawFilled(true);
        sets.add(lineDataSet1);
        sets.add(lineDataSet2);
        LineData data = new LineData(sets);


       /* By default, all chart types support legends and will automatically generate
         and draw a legend after setting data for the chart. The Legend usually consists of multiple
        entries each represented by a label an a form/shape.
        see more on https://github.com/PhilJay/MPAndroidChart/wiki/Legend
        */
        Legend legend = mChart.getLegend();
        legend.setXEntrySpace(5f);
        legend.setForm(Legend.LegendForm.LINE);

        //  set custom marker when clicking on point
        MyMarkerView mv = new MyMarkerView(getApplicationContext(), R.layout.custom_marker_view);
        mv.setChartView(mChart);
        mChart.setMarker(mv);
        // hiding vertical and horizontal grid line
        mChart.getXAxis().setDrawGridLines(false);
        mChart.getAxisLeft().setDrawGridLines(false);
        mChart.getAxisRight().setDrawGridLines(false);
        // set both line chart in graph
        mChart.setData(data);
        // show chart animation
        mChart.animateX(1000);
        // stop PinchZoom on graph
        mChart.setPinchZoom(false);
        // stop DoubleTapToZoom on graph
        mChart.setDoubleTapToZoomEnabled(false);
        mChart.setPivotX(10);

        //  increasing point clicking area using this method
        mChart.setMaxHighlightDistance(30);


        setIcon();
        mChart.invalidate();
    }


    /*
       set custom point in Graph
    */
    public void setIcon() {
        List<ILineDataSet> sets = mChart.getData().getDataSets();
        for (ILineDataSet iSet : sets) {
            LineDataSet set = (LineDataSet) iSet;
            set.setDrawIcons(!set.isDrawIconsEnabled());
        }
        mChart.invalidate();
    }
}
