package com.arshshaikh.sjicc;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    EditText email;
    EditText pass1;
    EditText name;
    Button registerButton;
    TextView alreadyRegistered;
    CheckBox showPassword;
    String useremail = "";
    Spinner spinner1;
    String userpass = "";
    JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        pass1 = findViewById(R.id.pass1);
        name = findViewById(R.id.name);
        registerButton = findViewById(R.id.registerButton);
        alreadyRegistered = findViewById(R.id.alreadyRegistered);
        showPassword = findViewById(R.id.showPassword);
        spinner1 = findViewById(R.id.spinner1);
        Spinner dropdown = findViewById(R.id.spinner1);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.105:3000/")
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        String[] items = new String[]{"NGO", "DONOR", "CMS"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        alreadyRegistered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent RegisterIntent = new Intent(RegisterActivity.this, FeedbackActivity.class);
                startActivity(RegisterIntent);
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = email.getText().toString().trim();
                String pwd = pass1.getText().toString().trim();
                String namef = name.getText().toString().trim();
                String role = name.getText().toString().trim();
                if (mail.isEmpty()) {
                    email.setError("Please enter an Email");
                    email.requestFocus();
                } else if (pwd.isEmpty()) {
                    pass1.setError("Please enter a password");
                    pass1.requestFocus();
                } else if (namef.isEmpty()) {
                    name.setError("Please enter a Name");
                    name.requestFocus();
                } else if (pwd.length() <= 6) {
                    pass1.setError("Password should be greater than 6 characters");
                    pass1.requestFocus();
                }else if (!(mail.isEmpty()) && !(pwd.isEmpty())) {
                   // Register register = new Register(namef,mail,pwd,role);
                   // create(namef,mail,pwd,role);
                    Intent goToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                    goToLogin.putExtra("Name", namef);
                    goToLogin.putExtra("Email", mail);
                    goToLogin.putExtra("Password", pwd);
                    goToLogin.putExtra("Role", role);
                    startActivity(goToLogin);
                }

            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {

        switch (position) {
            case 0:
                Intent DashboardIntent = new Intent(RegisterActivity.this, Chart.class);
                startActivity(DashboardIntent);
                break;
            case 1:
                Intent ChatbotIntent = new Intent(RegisterActivity.this, ChatbotActivity.class);
                startActivity(ChatbotIntent);
                break;
        }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void create(String name, String mail, String pwd, String role){
        Register user = new Register(name,mail,pwd,role);
        Call<Register> call = jsonPlaceHolderApi.usercreate(user);
        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(!response.isSuccessful()){
                    //textViewResult.setText("Code:" + response.code());
                    return;
                }

                Register postresponse = response.body();
                String content = "";
                content += "Code" + response.code() + "\n";
                content += "ID" + postresponse.getEmail() + "\n";
                //textViewResult.append(content);
            }
            @Override
            public void onFailure(Call<Register> call, Throwable t) {

            }
        });

        /* Token secret = new Token();
        Call<Token> call1 = jsonPlaceHolderApi.getSecret(secret);
        call1.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call1, Response<Token> responseForToken) {
                if(!responseForToken.isSuccessful()){
                    //textViewResult.setText("Code:" + response.code());
                    Log.i("Token","no");
                    return;
                }

                Token postresponse = responseForToken.body();
                String content = "";
                content += "Code" + responseForToken.code() + "\n";
                content += "Token" + postresponse.getToken() + "\n";
                Log.i("Token",postresponse.getToken());
            }
            @Override
            public void onFailure(Call<Token> call, Throwable t) {

            }
        }); */

    }
}