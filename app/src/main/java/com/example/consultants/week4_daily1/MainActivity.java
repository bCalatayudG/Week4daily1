package com.example.consultants.week4_daily1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.consultants.week4_daily1.Person.Person;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    private OkHttpHelper okhttpHelper;
    private Spinner spinnerNationality;
    private Spinner spinnerGender;
    private Spinner spinnerNumber;
    private Object itemNationality;
    private Object itemGender;
    private Object itemNumber;
    private RecyclerView my_recycler_view;
    private List<Person> personList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okhttpHelper = new OkHttpHelper();

        spinnerNationality = findViewById(R.id.spinnerNationality);
        spinnerGender = findViewById(R.id.spinnerGender);
        spinnerNumber = findViewById(R.id.spinnerNumber);
        my_recycler_view = findViewById(R.id.my_recycler_view);


        ArrayAdapter<CharSequence> adapterNationality = ArrayAdapter.createFromResource(this,
                R.array.nationalities_array, android.R.layout.simple_spinner_item);
        adapterNationality.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> adapterGender = ArrayAdapter.createFromResource(this,
                R.array.gender_array, android.R.layout.simple_spinner_dropdown_item);

        ArrayList<String> numberArrayList = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            numberArrayList.add(String.valueOf(i));
        }
        ArrayAdapter<String> adapterNumber = new ArrayAdapter(this, android.R.layout.simple_spinner_item);
        adapterNumber.addAll(numberArrayList);

        spinnerNationality.setAdapter(adapterNationality);
        spinnerGender.setAdapter(adapterGender);
        spinnerNumber.setAdapter(adapterNumber);


        spinnerNationality.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                itemNationality = adapterView.getItemAtPosition(position);
                if (itemNationality != null) {
                    Log.d(TAG, "onItemSelected: " + itemNationality.toString());
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                itemGender = adapterView.getItemAtPosition(position);
                if (itemGender != null) {
                    Log.d(TAG, "onItemSelected: " + itemGender.toString());
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinnerNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int position, long id) {
                itemNumber = adapterView.getItemAtPosition(position);
                if (itemNumber != null) {
                    Log.d(TAG, "onItemSelected: " + itemNumber.toString());
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void onOkHttp(View view) {

        switch (view.getId()) {
            case R.id.btnOkHttpExecute:
//                MyAsyncTask myAsynctask = new MyAsyncTask(itemGender,itemNationality,itemNumber,getApplicationContext(),my_recycler_view);
//                myAsynctask.execute();
                okhttpHelper.execute(itemNationality.toString(), itemGender.toString(), itemNumber.toString(),getApplicationContext(),my_recycler_view);
                break;

        }
    }

}
