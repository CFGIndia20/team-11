package com.arshshaikh.sjicc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Chart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> visitors  = new ArrayList<>();
        visitors.add(new BarEntry(2014,400));
        visitors.add(new BarEntry(2015,470));
        visitors.add(new BarEntry(2016,900));
        visitors.add(new BarEntry(2017,670));
        visitors.add(new BarEntry(2018,120));
        visitors.add(new BarEntry(2019,20));
        visitors.add(new BarEntry(2020,400));

        BarDataSet dataSet = new BarDataSet(visitors,"Visitors");
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        dataSet.setValueTextColor(Color.BLACK);
        dataSet.setValueTextSize(16f);
        BarData barData = new BarData(dataSet);
        barChart.setFitBars(true);
        barChart.setData(barData);
        barChart.getDescription().setText("Bar Chart Example");
        barChart.animateY(2000);
    }
}