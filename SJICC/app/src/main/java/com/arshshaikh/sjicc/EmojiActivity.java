package com.arshshaikh.sjicc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.hsalf.smilerating.BaseRating;
import com.hsalf.smilerating.SmileRating;

import java.util.Locale;

public class EmojiActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = "FeedbackActivity";
    TextView txt1;
    TextView txt2;
    TextView txt3;
    Button submitButton;
    TextToSpeech t1;
    ImageButton b1;
    TextToSpeech t2;
    ImageButton b2;
    TextToSpeech t3;
    ImageButton b3;

    ImageButton e1, e2, e3, e4, e5;
    ImageButton e11, e12, e13, e14, e15;
    ImageButton e21, e22, e23, e24, e25;

    int r1=3, r2=3, r3=3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt1 = findViewById(R.id.txt1);
        txt2 = findViewById(R.id.txt2);
        txt3 = findViewById(R.id.txt3);
        submitButton = findViewById(R.id.submitButton);
        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.e4);
        e5 = findViewById(R.id.e5);
        e11 = findViewById(R.id.e11);
        e12 = findViewById(R.id.e12);
        e13 = findViewById(R.id.e13);
        e14 = findViewById(R.id.e14);
        e15 = findViewById(R.id.e15);
        e21 = findViewById(R.id.e21);
        e22 = findViewById(R.id.e22);
        e23 = findViewById(R.id.e23);
        e24 = findViewById(R.id.e24);
        e25 = findViewById(R.id.e25);

        e1.setOnClickListener(this);
        e2.setOnClickListener(this);
        e3.setOnClickListener(this);
        e4.setOnClickListener(this);
        e5.setOnClickListener(this);
        e11.setOnClickListener(this);
        e12.setOnClickListener(this);
        e13.setOnClickListener(this);
        e14.setOnClickListener(this);
        e15.setOnClickListener(this);
        e21.setOnClickListener(this);
        e22.setOnClickListener(this);
        e23.setOnClickListener(this);
        e24.setOnClickListener(this);
        e25.setOnClickListener(this);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = txt1.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

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

        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Send r1, r2, r3 to API
            }
        });

    }

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.e1:
                r1=1;
                break;
            case R.id.e2:
                r1=2;
                break;
            case R.id.e3:
                r1=3;
                break;
            case R.id.e4:
                r1=4;
                break;
            case R.id.e5:
                r1=5;
                break;
            case R.id.e11:
                r2=1;
                break;
            case R.id.e12:
                r2=2;
                break;
            case R.id.e13:
                r2=3;
                break;
            case R.id.e14:
                r2=4;
                break;
            case R.id.e15:
                r2=5;
                break;
            case R.id.e21:
                r3=1;
                break;
            case R.id.e22:
                r3=2;
                break;
            case R.id.e23:
                r3=3;
                break;
            case R.id.e24:
                r3=4;
                break;
            case R.id.e25:
                r3=5;
                break;

        }

    }
}