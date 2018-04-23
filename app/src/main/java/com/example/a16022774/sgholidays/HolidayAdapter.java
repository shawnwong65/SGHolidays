package com.example.a16022774.sgholidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvName;
    private ImageView ivHoliday;
    private TextView tvDate;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);
        holiday = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvName = (TextView) rowView.findViewById(R.id.textViewName);
        // Get the ImageView object
        ivHoliday = (ImageView) rowView.findViewById(R.id.imageView);

        tvDate = (TextView) rowView.findViewById(R.id.textViewDate);

        Holiday currentHoliday = holiday.get(position);
        // Set the TextView to show the food

        tvName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());
        // Set the image to star or nostar accordingly
        if (currentHoliday.getName().equalsIgnoreCase("New Year's Day")) {
            ivHoliday.setImageResource(R.drawable.new_year);
        } else if(currentHoliday.getName().equalsIgnoreCase("Labour Day")){
            ivHoliday.setImageResource(R.drawable.labour_day);
        }else if(currentHoliday.getName().equalsIgnoreCase("Chinese New Year")){
            ivHoliday.setImageResource(R.drawable.cny);
        }else if(currentHoliday.getName().equalsIgnoreCase("Good Friday")){
            ivHoliday.setImageResource(R.drawable.good_friday);
        }else if(currentHoliday.getName().equalsIgnoreCase("Vesak Day")){
            ivHoliday.setImageResource(R.drawable.vesak_day);
        }else if(currentHoliday.getName().equalsIgnoreCase("Hari Raya Puasa")){
            ivHoliday.setImageResource(R.drawable.hari_raya_puasa);
        }else if(currentHoliday.getName().equalsIgnoreCase("National Day")){
            ivHoliday.setImageResource(R.drawable.national_day);
        }else if(currentHoliday.getName().equalsIgnoreCase("Hari Raya Haji")){
            ivHoliday.setImageResource(R.drawable.hari_raya_haji);
        }else if(currentHoliday.getName().equalsIgnoreCase("Deepavali")){
            ivHoliday.setImageResource(R.drawable.deepavali);
        }else if(currentHoliday.getName().equalsIgnoreCase("Christmas Day")){
            ivHoliday.setImageResource(R.drawable.christmas);
        }
        return rowView;
    }
}
