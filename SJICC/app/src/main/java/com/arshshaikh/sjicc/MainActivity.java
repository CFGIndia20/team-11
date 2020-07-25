package com.arshshaikh.sjicc;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText pass1;
    Button loginButton;
    TextView notRegistered;
    CheckBox showPassword;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        pass1 = findViewById(R.id.pass1);
        loginButton = findViewById(R.id.registerButton);
        notRegistered = findViewById(R.id.alreadyRegistered);
        showPassword = findViewById(R.id.showPassword);

        notRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(RegisterIntent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String pwd = pass1.getText().toString().trim();
                //Checking if the mail is fileld
                if(mail.isEmpty()){
                    email.setError("Please enter an Email");
                    email.requestFocus();
                }
                //Checking if the password is filled
                else if(pwd.isEmpty())
                {
                    pass1.setError("Please enter a password");
                    pass1.requestFocus();
                }
                //GoToDashBaoard
                else if(!(mail.isEmpty()) && !(pwd.isEmpty())){
                    Intent goToDashboard = new Intent(MainActivity.this, Testing.class);
                    startActivity(goToDashboard);
                }
            }
        });

        //Hide or Show Password
        showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    pass1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else
                {
                    pass1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
            }
        });
    }
    @Override
    public void onBackPressed()
    {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}