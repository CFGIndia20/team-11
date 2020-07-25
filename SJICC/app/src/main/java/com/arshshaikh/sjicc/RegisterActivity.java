package com.arshshaikh.sjicc;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText email;
    EditText pass1;
    EditText pass2;
    Button registerButton;
    TextView alreadyRegistered;
    CheckBox showPassword;
    String useremail="";
    String userpass="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        pass1 = findViewById(R.id.pass1);
        pass2 = findViewById(R.id.pass2);
        registerButton = findViewById(R.id.registerButton);
        alreadyRegistered = findViewById(R.id.alreadyRegistered);
        showPassword = findViewById(R.id.showPassword);

        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(RegisterActivity.this, Chart.class);
                startActivity(RegisterIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String pwd = pass1.getText().toString().trim();
                String pwd2 = pass2.getText().toString().trim();
                if (mail.isEmpty()) {
                    email.setError("Please enter an Email");
                    email.requestFocus();
                } else if (pwd.isEmpty()) {
                    pass1.setError("Please enter a password");
                    pass1.requestFocus();
                } else if (pwd2.isEmpty()) {
                    pass2.setError("Please enter a password");
                    pass2.requestFocus();
                } else if (pwd.length() <= 6) {
                    pass1.setError("Password should be greater than 6 characters");
                    pass1.requestFocus();
                } else if (pwd2.length() <= 6) {
                    pass2.setError("Password should be greater than 6 characters");
                    pass2.requestFocus();
                } else if (!pwd.equals(pwd2)) {
                    Toast.makeText(RegisterActivity.this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
                } else if (!(mail.isEmpty()) && !(pwd.isEmpty())) {
                    // Register register = new Register();
                    //useremail = register.getEmail();
                    //userpass = register.getPwd();
                    Intent goToLogin = new Intent(RegisterActivity.this,MainActivity.class);
                    startActivity(goToLogin);
                }

                showPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            pass1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            pass2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                        } else {
                            pass1.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            pass2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                        }
                    }
                });
            }
        });
    }
}