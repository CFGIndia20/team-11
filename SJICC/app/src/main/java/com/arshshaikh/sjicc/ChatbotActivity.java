package com.arshshaikh.sjicc;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.igalata.bubblepicker.BubblePickerListener;
import com.igalata.bubblepicker.model.PickerItem;
import com.igalata.bubblepicker.rendering.BubblePicker;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class ChatbotActivity extends AppCompatActivity {

    BubblePicker bubblePicker;

    String queries[] = {"Number of students admitted", "Name of the patient I have sponsored", "Is the patient a returnee?"};

    int color1= Color.parseColor("@drawable/gradient_background");
    int color2=R.drawable.bg_gradient;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatbot);

        bubblePicker=(BubblePicker)findViewById(R.id.picker);
        ArrayList<PickerItem> listItems=new ArrayList<>();
        for(int i=0; i<queries.length; i++)
        {
            PickerItem item=new PickerItem(queries[i], color1, Color.BLACK, getDrawable(color2));
            listItems.add(item);
        }
        bubblePicker.setItems(listItems);
        bubblePicker.setListener(new BubblePickerListener() {
            @Override
            public void onBubbleSelected(@NotNull PickerItem pickerItem) {
                //Get response
            }

            @Override
            public void onBubbleDeselected(@NotNull PickerItem pickerItem) {

            }
        });

    }

}

