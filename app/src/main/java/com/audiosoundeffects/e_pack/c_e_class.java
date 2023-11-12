package com.audiosoundeffects.e_pack;

import android.media.MediaMetadataRetriever;

import com.audiosoundeffects.b_pack.a_b_class;

import java.io.File;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

public class c_e_class {
    public static a_b_class a(File file) {
        String str;
        String str2;
        String str3;
        a_b_class a_b_class = new a_b_class();
        a_b_class.g = file.getName();
        a_b_class.d = file.getPath();
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
            a_b_class.f = mediaMetadataRetriever.extractMetadata(9);
            if (a_b_class.f == null) {
                str3 = "0";
            } else {
                long parseLong = Long.parseLong(a_b_class.f);
                str3 = String.format("%02d:%02d", new Object[]{Long.valueOf(TimeUnit.MILLISECONDS.toMinutes(parseLong)), Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(parseLong) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(parseLong)))});
            }
            a_b_class.f = str3;
            mediaMetadataRetriever.release();
        } catch (Exception e) {
            e.printStackTrace();
            a_b_class.f = "00:00";
        }
        long length = file.length();
        double d = (double) length;
        Double.isNaN(d);
        Double.isNaN(d);
        Double.isNaN(d);
        Double.isNaN(d);
        double d2 = d / 1048576.0d;
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        if (d2 > 1.0d) {
            str = decimalFormat.format(d2);
            str2 = " MB";
        } else if (d2 >= 1.0d || d2 <= 0.001d) {
            str = decimalFormat.format(length);
            str2 = " Bytes";
        } else {
            str = decimalFormat.format(d2 * 1024.0d);
            str2 = " KB";
        }
        a_b_class.e = str.concat(str2);
        return a_b_class;
    }
}
