package com.example.consultants.week4_daily1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.consultants.week4_daily1.Person.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class OkHttpHelper {

    OkHttpClient client;
    private static final String TAG = OkHttpHelper.class.getSimpleName() + "_TAG";

    List<Person> personList = new ArrayList<>();
    private String response;

    public OkHttpHelper() {
        this.client = new OkHttpClient();
    }


    public void execute(String nationality, String gender, String times, Context context, RecyclerView my_recycler_view) {
        String parameters = "?gender=" + gender + "&nat=" + nationality + "&inc=gender,name,nat&results=" + times;
        Log.d(TAG, "execute: " + NetworkHelper.RANDOM_USER_API + parameters);
        final Request request = new Request.Builder().
                url(NetworkHelper.RANDOM_USER_API + parameters).
                build();
        MyAsyncTask myAsynctask = new MyAsyncTask(request,client,context,my_recycler_view);
        myAsynctask.execute();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Log.d(TAG, "execute: ");
                    //response = client.newCall(request).execute().body().string();
//                    //Log.d(TAG, "run: " + response);
                    //personList = RandomParser.parsePerson(response);
//                    //Log.d(TAG, "run: personList.size: " + personList.size());
                    //Log.d(TAG, "run: " + personList);
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
        //Log.d(TAG, "execute: pre return Person list: "+personList);
        //response = client.newCall(request).execute().body().string();
        //return personList;
    }
}
