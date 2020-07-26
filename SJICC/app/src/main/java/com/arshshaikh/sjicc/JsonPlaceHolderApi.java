package com.arshshaikh.sjicc;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @GET("api/feedback")
    Call<FeedbackGet> getfeedbacks();

    @POST("api/feedback")
    Call<FeedbackPost> createFeedbackPost(@Body FeedbackPost feedbackPost);

    @POST("api/user")
    Call<Register> usercreate(@Body Register user);

    @GET("api/user")
    Call <Token> getSecret(@Header("x-auth-token") Token AuthToken);

}
