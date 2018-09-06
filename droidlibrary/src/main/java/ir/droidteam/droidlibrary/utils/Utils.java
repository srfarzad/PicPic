package ir.droidteam.droidlibrary.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import ir.droidteam.droidlibrary.R;


/**
 * Created by farzad.sarseify on 29/03/2017.
 */

public class Utils {

    public static void share(Activity context, String text) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_TEXT, text);
            context.startActivity(Intent.createChooser(intent, "Share via"));
    }



}
