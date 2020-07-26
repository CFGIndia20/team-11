package com.arshshaikh.sjicc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Testing extends AppCompatActivity {
    private TextView textViewResult;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing);
        textViewResult = findViewById(R.id.textViewResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.2.105:3000/")
                //.baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        //post request
        //createPost();

        /*
        //Get Request
        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code" + response.code());
                    return;
                }
                List<Post> posts = response.body();
                for(Post post:posts){
                    String content = "";
                    content += "ID" + post.getId() + "\n";
                    content += "User ID" + post.getUserId() + "\n";
                    content += "Title" + post.getTitle() + "\n";
                    content += "Text" + post.getText() + "\n";
                    textViewResult.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });*/

        //Get Request
        Call<FeedbackGet> feebacks = jsonPlaceHolderApi.getfeedbacks();
        feebacks.enqueue(new Callback<FeedbackGet>() {
            @Override
            public void onResponse(Call<FeedbackGet> call, Response<FeedbackGet> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code" + response.code());
                    return;
                }
                FeedbackGet feedbackGets = response.body();
                String content = "";
                content += "Number 1" + feedbackGets.getNumber1() + "\n";
                content += "Number 2" + feedbackGets.getNumber2() + "\n";
                content += "Number 3" + feedbackGets.getNumber3() + "\n";
                textViewResult.append(content);
            }

            @Override
            public void onFailure(Call<FeedbackGet> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }

    //create post method for post api
    private void create(){
        Post post = new Post(23,"New Title", "New Text");
        Call<Post> call = jsonPlaceHolderApi.createPost(post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code:" + response.code());
                    return;
                }

                Post postresponse = response.body();
                String content = "";
                content += "Code" + response.code() + "\n";
                content += "ID" + postresponse.getId() + "\n";
                content += "User ID" + postresponse.getUserId() + "\n";
                content += "Title" + postresponse.getTitle() + "\n";
                content += "Text" + postresponse.getText() + "\n";
                textViewResult.append(content);
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }
}