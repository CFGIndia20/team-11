package com.arshshaikh.sjicc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FeedbackActivity extends AppCompatActivity implements SmileRating.OnSmileySelectionListener, SmileRating.OnRatingSelectedListener {

    private static final String TAG = "FeedbackActivity";
    TextView txt1;
    TextView txt2;
    TextView txt3;
    Button submitButton;
    TextToSpeech t1;
    Button b1;
    TextToSpeech t2;
    Button b2;
    TextToSpeech t3;
    Button b3;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    private SmileRating mSmileRating1;
    private SmileRating mSmileRating2;
    private SmileRating mSmileRating3;
    int r1,r2,r3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.105:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        submitButton = findViewById(R.id.submitButton);
        createFeedbackPost(1,2,3);
       /* mSmileRating1 = (SmileRating) findViewById(R.id.ratingView1);
        mSmileRating1.setOnSmileySelectionListener(this);
        mSmileRating1.setOnRatingSelectedListener(this);

        mSmileRating2 = (SmileRating) findViewById(R.id.ratingView2);
        mSmileRating2.setOnSmileySelectionListener(this);
        mSmileRating2.setOnRatingSelectedListener(this);

        mSmileRating3 = (SmileRating) findViewById(R.id.ratingView3);
        mSmileRating3.setOnSmileySelectionListener(this);
        mSmileRating3.setOnRatingSelectedListener(this);

        t1=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.UK);
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        t2=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t2.setLanguage(Locale.UK);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt2.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t2.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        t3=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    t3.setLanguage(Locale.UK);
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt3.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t3.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        */


        //submitButton.setOnClickListener(new View.OnClickListener() {
          //  public void onClick(View v) {
               /* r1 = mSmileRating1.getRating();
                r2 = mSmileRating2.getRating();
                r3 = mSmileRating3.getRating();
                createFeedbackPost(r1,r2,r3); */
                //createFeedbackPost(1,2,3);
               // Toast toast = Toast. makeText(getApplicationContext(), r1 + " " + r2 + " " + r3, Toast. LENGTH_SHORT);
               // toast.show();
        //    }
      //  });
    }

    public void onPause(){
        if(t1 !=null){
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
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

    private void createFeedbackPost(int r1, int r2, int r3){
        FeedbackPost feedbackPost = new FeedbackPost(1,2,3);
        Call<FeedbackPost> call = jsonPlaceHolderApi.createFeedbackPost(feedbackPost);
        call.enqueue(new Callback<FeedbackPost>() {
            @Override
            public void onResponse(Call<FeedbackPost> call, Response<FeedbackPost> response) {
                if(!response.isSuccessful()){
                   // textViewResult.setText("Code:" + response.code());
                    return;
                }

                FeedbackPost postresponse = response.body();
                String content = "";
                content += "Code" + response.code() + "\n";
                content += "Answer1" + postresponse.getAnswer1() + "\n";
                content += "Answer2" + postresponse.getAnswer1() + "\n";
                content += "Answer3" + postresponse.getAnswer1() + "\n";
                Log.i("Content",content);
            }
            @Override
            public void onFailure(Call<FeedbackPost> call, Throwable t) {

            }
        });
    }

}