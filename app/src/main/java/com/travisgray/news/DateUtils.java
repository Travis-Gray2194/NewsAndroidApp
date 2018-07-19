package com.travisgray.news;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by travi on 7/19/2018.
 */

public class DateUtils {

    public static String formatNewsAPIDate(String inputDate) {
        try {
            String inputDateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'";
            String outputDateFromat = "EEE, d MMM yyyy KK:mm";

            SimpleDateFormat inputFormat = new SimpleDateFormat(inputDateFormat);
            SimpleDateFormat outputFormat = new SimpleDateFormat(outputDateFromat);

            Date date = inputFormat.parse(inputDate);
            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return inputDate;
    }
}
