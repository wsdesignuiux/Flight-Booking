package com.ws.design.flight_booking;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Adapters.ListAdapters;
import Models.PojoClass;
import other.ItemData1;
import other.Spinner_ClassAdapter;
import other.Spinner_Cusine_DataAdapter;

public class MainActivity extends AppCompatActivity {

    private TextView textView_round, textView_oneway,Edittext_dep, Edittext_return;
    private LinearLayout trip_select, linear1, linear2;
    private RecyclerView rv;
    private ArrayList<PojoClass> pojoClassArrayList;
    private String[] text_airline = {"JFK-SFO American Airline", "JFK-SFO American Airline", "JFK-SFO American Airline", "JFK-SFO American Airline"};
    private String[] text_timeschedule = {"6hr 45min, Non-stop", "6hr 45min, Non-stop", "6hr 45min, Non-stop", "6hr 45min, Non-stop"};
    private String[] text_time = {"7:00-10:00", "7:00-10:00", "7:00-10:00", "7:00-10:00"};
    private Integer[] logo = {R.drawable.logo, R.drawable.logo, R.drawable.logo, R.drawable.logo};


    private ListAdapters listAdapter;

    public LinearLayout continue_booking;
    private Spinner spinner, spinner1;
    private int mYear, mMonth, mDay;

    Date date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        textView_round = (TextView) findViewById(R.id.textView_round);
        textView_oneway = (TextView) findViewById(R.id.textView_oneway);
        Edittext_dep = (TextView) findViewById(R.id.Edittext_dep);
        Edittext_return = (TextView) findViewById(R.id.Edittext_return);
        trip_select = (LinearLayout) findViewById(R.id.trip_select);
        linear1 = (LinearLayout) findViewById(R.id.linear1);
        linear2 = (LinearLayout) findViewById(R.id.linear2);

        linear1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                linear1.setBackgroundResource(R.drawable.top_leftcorner);
                textView_round.setTextColor(Color.parseColor("#ffffff"));

                linear2.setBackgroundResource(R.drawable.top_rightcorner_white);
                textView_oneway.setTextColor(Color.parseColor("#837a7a"));


            }
        });
        linear2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        linear2.setBackgroundResource(R.drawable.top_rightcorner);
                        textView_oneway.setTextColor(Color.parseColor("#ffffff"));

                        linear1.setBackgroundResource(R.drawable.top_leftcorner_white);
                        textView_round.setTextColor(Color.parseColor("#837a7a"));

                    }
                }
        );

        Edittext_dep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {


                                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                                String dateInString = dayOfMonth+"-"+monthOfYear+"-"+year;

                                try {

                                     date = formatter.parse(dateInString);
                                    System.out.println(date);
                                    System.out.println(formatter.format(date));

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                String dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday
                                String day          = (String) DateFormat.format("dd",   date); // 20
                                String monthString  = (String) DateFormat.format("MMM",  date); // Jun

                                Edittext_dep.setText(dayOfTheWeek.substring(0,3)+", "+day+" "+monthString);


                            }
                        }, mYear, mMonth, mDay);



                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();

            }
        });

        Edittext_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);


                final DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {


                                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                                String dateInString = dayOfMonth+"-"+monthOfYear+"-"+year;

                                try {

                                    date = formatter.parse(dateInString);
                                    System.out.println(date);
                                    System.out.println(formatter.format(date));

                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }

                                String dayOfTheWeek = (String) DateFormat.format("EEEE", date); // Thursday
                                String day          = (String) DateFormat.format("dd",   date); // 20
                                String monthString  = (String) DateFormat.format("MMM",  date); // Jun


                                Edittext_return.setText(dayOfTheWeek.substring(0,3)+", "+day+" "+monthString);


                            }
                        }, mYear, mMonth, mDay);



                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();

            }
        });





        pojoClassArrayList = new ArrayList<>();


        for (int i = 0; i < text_airline.length; i++) {

            PojoClass pojoClass = new PojoClass();
            pojoClass.setText_airline(text_airline[i]);
            pojoClass.setText_timeschedule(text_timeschedule[i]);
            pojoClass.setText_time(text_time[i]);
            pojoClass.setLogo(logo[i]);
            pojoClassArrayList.add(pojoClass);
        }

        rv = (RecyclerView) findViewById(R.id.rv);

        listAdapter = new ListAdapters(MainActivity.this, pojoClassArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(listAdapter);

        spinner = (Spinner) findViewById(R.id.spinner_dep);
        spinner1 = (Spinner) findViewById(R.id.spinner_class);

        ArrayList<ItemData1> list = new ArrayList<>();


        list.add(new ItemData1("1 Adults"));
        list.add(new ItemData1("2 Adults"));
        list.add(new ItemData1("3 Adults"));
        list.add(new ItemData1("4 Adults"));
        Spinner sp = (Spinner) findViewById(R.id.spinner_dep);
        Spinner_Cusine_DataAdapter adapter = new Spinner_Cusine_DataAdapter(this, R.layout.itemlist_dep, R.id.textView_dep, list);
        sp.setAdapter(adapter);
        spinner.setAdapter(adapter);


        ArrayList<ItemData1> list1 = new ArrayList<>();

        list1.add(new ItemData1("Business"));
        list1.add(new ItemData1("Economy"));
        list1.add(new ItemData1("Premium Economy"));
        list1.add(new ItemData1("First Class"));
        Spinner sp1 = (Spinner) findViewById(R.id.spinner_class);
        Spinner_ClassAdapter adapter1 = new Spinner_ClassAdapter(this, R.layout.itemlist_class, R.id.textview_class, list1);
        sp1.setAdapter(adapter1);
        spinner1.setAdapter(adapter1);
    }

    public void init() {

        LinearLayout btn = (LinearLayout) findViewById(R.id.continue_booking);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Intent contact = new Intent(MainActivity.this, Home_Activity.class);
                startActivity(contact);

            }
        });


    }
}
