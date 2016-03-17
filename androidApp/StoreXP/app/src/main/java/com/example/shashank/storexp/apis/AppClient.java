package com.example.shashank.storexp.apis;

import android.util.Log;

import com.google.gson.JsonObject;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;

/**
 * Created by root on 26/6/15.
 */
public class AppClient {

//    public static final String URL_UAT = "http://192.168.1.14:8080/api";
    public static final String URL_UAT = "http://172.26.178.140:8080/api";
    public static final String URL_PROD = "";
    public static String URL = "";
    public static boolean isDebuggable = true;
    private static RestAdapter mRestAdapter ;
    private static final String xAuthEmail = "x-auth-email";
    private static final String xAuthPassword = "x-auth-password";
    private static final String xAuthName = "x-auth-name";

    /**
     * Generic response interface to be used by all
     *
     * @param <T>
     */
    public interface INetworkResponse<T> {
        public void onSuccess(T data);

        public void onError(Exception e);
    }

    // Rest adapter instance
    private static RestAdapter getRestAdapter() {

        if (!isDebuggable) {
            URL = URL_PROD;
        } else {
            URL = URL_UAT;
        }

        if (mRestAdapter != null) {
            return mRestAdapter;
        }
        return mRestAdapter = new RestAdapter.Builder()
                .setEndpoint(URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
    }

    private interface IApiClient {

        @POST("/signup")
        void registerUser(@Body JsonObject dataObject, Callback<JsonObject> jsonObjectCallback);

        @POST("/login")
        void authenticateUser(@Body JsonObject jsonObject, Callback<JsonObject> jsonObjectCallback);


        @POST("/checkOTP")
        void checkOTP(@Body JsonObject jsonObject, Callback<JsonObject> jsonObjectCallback);


        @GET("/alreadyUser")
        void alreadyUser(@Header("x-auth-token") String authtoken, Callback<JsonObject> jsonObjectCallback);


    }
    public static void checkOTP(JsonObject jsonObject, final INetworkResponse<JsonObject> listener) {

        getRestAdapter().create(IApiClient.class).checkOTP(jsonObject, new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {

                if (listener != null) {
                    listener.onSuccess(jsonObject);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("RegisterUserAPI", error.toString());
            }
        });
    }
    public static void alreadyUser(String authtoken, final INetworkResponse<JsonObject> listener) {

        getRestAdapter().create(IApiClient.class).alreadyUser(authtoken, new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {

                if (listener != null) {
                    listener.onSuccess(jsonObject);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("RegisterUserAPI", error.toString());
            }
        });
    }
    public static void registerUser(JsonObject dataObject, final INetworkResponse<JsonObject> listener) {
           System.out.print("hit the reguster user");
        getRestAdapter().create(IApiClient.class).registerUser(dataObject, new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {

                if (listener != null) {
                    listener.onSuccess(jsonObject);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("RegisterUserAPI", error.toString());
            }
        });
    }
    public static void authenticateUser(JsonObject jsonObject, final INetworkResponse<JsonObject> listener) {

        getRestAdapter().create(IApiClient.class).authenticateUser(jsonObject, new Callback<JsonObject>() {
            @Override
            public void success(JsonObject jsonObject, Response response) {

                if (listener != null) {
                    listener.onSuccess(jsonObject);
                }
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("RegisterUserAPI", error.toString());
            }
        });
    }

}
