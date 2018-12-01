package com.ws.design.flight_booking;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Spinner;

import java.util.ArrayList;

import Adapters.ItemData;
import Adapters.ItemDataClass;
import Adapters.SpinnerClassAdapter;
import Adapters.SpinnerCousineAdapter;

public class Home_Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);


        ArrayList<ItemData> list = new ArrayList<>();


        list.add(new ItemData("Select No Of Adults"));
        list.add(new ItemData("1 Adult"));
        list.add(new ItemData("2 Adults"));
        list.add(new ItemData("3 Adults"));
        Spinner sp = (Spinner) findViewById(R.id.spinner1);
        SpinnerCousineAdapter adapter = new SpinnerCousineAdapter(this, R.layout.spinner_selecting_adults, R.id.data, list);
        sp.setAdapter(adapter);

        ArrayList<ItemDataClass> lists = new ArrayList<>();


        lists.add(new ItemDataClass("Select Class"));
        lists.add(new ItemDataClass("Business"));
        lists.add(new ItemDataClass("Economy"));
        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
        SpinnerClassAdapter adapters = new SpinnerClassAdapter(this, R.layout.spinner_selecting_adults, R.id.data, lists);
        spinner.setAdapter(adapters);

    }

}

