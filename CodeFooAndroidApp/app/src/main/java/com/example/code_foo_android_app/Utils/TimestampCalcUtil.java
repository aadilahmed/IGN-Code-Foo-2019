package com.example.code_foo_android_app.Utils;

import android.support.v7.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class TimestampCalcUtil {

    public static String calcTimestamp(String dateString, RecyclerView.ViewHolder viewHolder) {
        String returnValue = "";

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss",
                    Locale.US);
            Date date = dateFormat.parse(dateString);
            long dateTime = date.getTime();
            Date currDate = new Date();
            long dateTime2 = currDate.getTime();

            long diff = dateTime2 - dateTime;
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;

            if (days > 0) {
                if (days == 1) {
                    returnValue = "YESTERDAY";
                } else {
                    returnValue = days + " DAYS AGO";
                }
            } else if (hours > 0) {
                returnValue = hours + " HR AGO";
            } else if (minutes > 0) {
                returnValue = minutes + " MIN AGO";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return returnValue;
    }
}