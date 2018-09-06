package ir.droidteam.droidlibrary.utils;

import android.content.Context;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

/**
 * Created by farzad.sarseify on 24/05/2017.
 */

public class DateUtils {

    Context context;
    long diff;

    private DateUtils() {

    }

    public DateUtils(Context context) {
        this.context = context;
    }

    public String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }





    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * Used to Convert date to Calendar
     *
     * @param date get Date

     */
    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }


    public static boolean holidayCheck(int month, int day) {
        boolean result = false;


        if (month == 9 && day == 27) {
            result = true;
        }
        if (month == 3 && day == 12) {
            result = true;
        }
        if (month == 1 && day == 1) {
            result = true;
        }
        if (month == 12 && day == 10) {
            result = true;
        }
        if (month == 1 && day == 10) {
            result = true;
        }
        if (month == 9 && day == 1) {
            result = true;
        }

        if (month == 7 && day == 27) {
            result = true;
        }


        return result;
    }

    /**
     * Used to Convert timeStamp to DateTime
     *
     * @param month Time stamp value ScrollView
     * @param day Time stamp value ScrollView
     */
    public static String holiday(int month, int day) {

        String messag = "";
        boolean result = holidayCheck(month, day);


        if (result == false) {
            messag = "";
        } else {


            if (month == 9 && day == 27) {
                messag = "Lailat al-Qadr";
            }
            if (month == 3 && day == 12) {
                messag = "The Prophet&apos;s Birthday";
            }
            if (month == 1 && day == 1) {
                messag = "Muharram";
            }
            if (month == 12 && day == 10) {
                messag = "Eid al-Adha";
            }
            if (month == 1 && day == 10) {
                messag = "Eid al-Fitr";
            }
            if (month == 9 && day == 1) {
                messag = "Ramadan starts";
            }

            if (month == 7 && day == 27) {
                messag = "Isra and Mi&apos;raj";
            }

        }


        return messag;
    }



    public static Date getMyTime() {


        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date myDate = new Date(stamp.getTime());

        return myDate;

    }


}
