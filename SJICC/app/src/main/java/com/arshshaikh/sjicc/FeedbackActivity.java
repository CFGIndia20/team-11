package com.arshshaikh.sjicc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

public class FeedbackActivity extends AppCompatActivity implements SmileRating.OnSmileySelectionListener, SmileRating.OnRatingSelectedListener {

    private static final String TAG = "FeedbackActivity";
    TextView txt1;
    TextView txt2;
    TextView txt3;
    Button submitButton;

    private SmileRating mSmileRating1;
    private SmileRating mSmileRating2;
    private SmileRating mSmileRating3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        submitButton = findViewById(R.id.submitButton);

        mSmileRating1 = (SmileRating) findViewById(R.id.ratingView1);
        mSmileRating1.setOnSmileySelectionListener(this);
        mSmileRating1.setOnRatingSelectedListener(this);

        mSmileRating2 = (SmileRating) findViewById(R.id.ratingView2);
        mSmileRating2.setOnSmileySelectionListener(this);
        mSmileRating2.setOnRatingSelectedListener(this);

        mSmileRating3 = (SmileRating) findViewById(R.id.ratingView3);
        mSmileRating3.setOnSmileySelectionListener(this);
        mSmileRating3.setOnRatingSelectedListener(this);

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int r1 = mSmileRating1.getRating();
                int r2 = mSmileRating2.getRating();
                int r3 = mSmileRating3.getRating();

                Toast toast = Toast. makeText(getApplicationContext(), r1 + " " + r2 + " " + r3, Toast. LENGTH_SHORT);
                toast.show();
            }
        });


    }


    @Override
    public void onSmileySelected(@BaseRating.Smiley int smiley, boolean reselected) {
        switch (smiley) {
            case SmileRating.BAD:
                Log.i(TAG, "Bad");
                break;
            case SmileRating.GOOD:
                Log.i(TAG, "Good");
                break;
            case SmileRating.GREAT:
                Log.i(TAG, "Great");
                break;
            case SmileRating.OKAY:
                Log.i(TAG, "Okay");
                break;
            case SmileRating.TERRIBLE:
                Log.i(TAG, "Terrible");
                break;
            case SmileRating.NONE:
                Log.i(TAG, "None");
                break;
        }
    }

    @Override
    public void onRatingSelected(int level, boolean reselected) {
        Log.i(TAG, "Rated as: " + level + " - " + reselected);
    }

}