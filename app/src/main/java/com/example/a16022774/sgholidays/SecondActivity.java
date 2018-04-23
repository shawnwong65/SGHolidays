package com.example.a16022774.sgholidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    TextView tvType;
    ArrayAdapter aa;
    ArrayList<Holiday> holidayArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) this.findViewById(R.id.lvHolidays);
        tvType = (TextView) findViewById(R.id.textViewTitle);

        holidayArrayList = new ArrayList<Holiday>();
        aa = new HolidayAdapter(this, R.layout.row, holidayArrayList);
        lv.setAdapter(aa);

        Intent i = getIntent();
        String type = i.getStringExtra("type");
        tvType.setText(type);
        if(type.equalsIgnoreCase("Secular")){
            holidayArrayList.add(new Holiday("New Year's Day", "1 Jan 2018"));
            holidayArrayList.add(new Holiday("Labour Day", "1 May 2018"));
            holidayArrayList.add(new Holiday("National Day", "9 Aug 2018"));
        }else{
            holidayArrayList.add(new Holiday("Chinese New Year", "16-17 Feb 2018"));
            holidayArrayList.add(new Holiday("Good Friday", "30 Mar 2018"));
            holidayArrayList.add(new Holiday("Vesak Day", "29 May 2018"));
            holidayArrayList.add(new Holiday("Hari Raya Puasa", "15 Jun 2018"));
            holidayArrayList.add(new Holiday("Hari Raya Haji", "22 Aug 2018"));
            holidayArrayList.add(new Holiday("Deepavali", "6 Nov 2018"));
            holidayArrayList.add(new Holiday("Christmas Day", "25 Dec 2018"));
        }
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holidayArrayList.get(position);

                Toast.makeText(SecondActivity.this, selectedHoliday.getName()
                                + " Date: " + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });

    }
}
