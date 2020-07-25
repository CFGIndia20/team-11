package com.arshshaikh.sjicc;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Chart extends AppCompatActivity {
    JsonPlaceHolderApi jsonPlaceHolderApi;
    int num1,num2,num3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.105:3000/")
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        Call<FeedbackGet> feebacks = jsonPlaceHolderApi.getfeedbacks();
        feebacks.enqueue(new Callback<FeedbackGet>() {
            @Override
            public void onResponse(Call<FeedbackGet> call, Response<FeedbackGet> response) {
                if(!response.isSuccessful()){
                    //textViewResult.setText("Code" + response.code());
                    return;
                }
                FeedbackGet feedbackGets = response.body();
                String content = "";
                content += "Number " + feedbackGets.getNumber1() + "\n";
                content += "Number " + feedbackGets.getNumber2() + "\n";
                content += "Number " + feedbackGets.getNumber3() + "\n";
                Log.i("Content", content);
                //textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<FeedbackGet> call, Throwable t) {
               // textViewResult.setText(t.getMessage());
            }
        });
        BarChart barChart = findViewById(R.id.barChart);
        ArrayList<BarEntry> visitors  = new ArrayList<>();
        visitors.add(new BarEntry(2018,num1));
        visitors.add(new BarEntry(2019,num2));
        visitors.add(new BarEntry(2020,num3));

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