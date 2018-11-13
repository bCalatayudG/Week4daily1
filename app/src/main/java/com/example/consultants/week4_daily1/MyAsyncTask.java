package com.example.consultants.week4_daily1;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.consultants.week4_daily1.Person.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MyAsyncTask extends AsyncTask<String, Integer, List<Person>> {

    private OkHttpHelper okhttpHelper;
    private List<Person> personList = new ArrayList<>();
    private static final String TAG = MyAsyncTask.class.getSimpleName() + "_TAG";

    private Context context;
    private RecyclerView my_recycler_view;
    private Request request;
    private OkHttpClient client;
    private RecyclerViewAdapter adapter;


    public MyAsyncTask(Request request, OkHttpClient client, Context context, RecyclerView my_recycler_view) {
        this.request = request;
        this.client = client;
        this.context = context;
        this.my_recycler_view = my_recycler_view;
        okhttpHelper = new OkHttpHelper();
    }

    @Override
    protected List<Person> doInBackground(String... strings) {
        try {
            String response = client.newCall(request).execute().body().string();
            personList = RandomParser.parsePerson(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "doInBackground: "+personList);
        return null;
    }

    @Override
    protected void onPostExecute(List<Person> people) {
        super.onPostExecute(people);
        Log.d(TAG, "onPostExecute: people"+people);
        adapter = new RecyclerViewAdapter(personList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context);
        my_recycler_view.setAdapter(adapter);
        my_recycler_view.setLayoutManager(layoutManager);
    }
}
