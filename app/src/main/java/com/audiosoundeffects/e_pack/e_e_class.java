package com.audiosoundeffects.e_pack;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.preference.PreferenceManager;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class e_e_class {
    public static int a(Context context, String str) {
        return PreferenceManager.getDefaultSharedPreferences(context).getInt(str, 0);
    }

    public static String a(long j) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, yyyy");
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        return simpleDateFormat.format(instance.getTime());
    }

    public static String a(Activity activity, Uri uri) {
        try {
            Cursor managedQuery = activity.managedQuery(uri, new String[]{"_data", "_data"}, (String) null, (String[]) null, (String) null);
            int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
            managedQuery.moveToFirst();
            return managedQuery.getString(columnIndexOrThrow);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(Context context, String str, int i) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putInt(str, i);
        edit.commit();
    }

    public static int b(Context context, String str) {
        try {
            Uri parse = Uri.parse(str);
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(context, parse);
            return Integer.parseInt(mediaMetadataRetriever.extractMetadata(9));
        } catch (Exception unused) {
            return 0;
        }
    }
}
