package com.audiosoundeffects.e_pack;

import android.os.Environment;


public class d_e_class {
    public static String a = "Delete";
    public static String[] b = {".MP3", ".WMA", ".WAV", ".RA", ".RAM", ".RM", ".MID", ".OGG", ".M4A", ".FLAC", ".AIFF", ".MIDI", ".AAC", ".MTM", ".UMX", ".MO3", ".OTA"};
    public static String c = "OPEN_WITH";
    public static String d = "Properties";
    public static String e = "Rename123";
    public static String f = "Rename123456";
    public static String g = null;
    public static String h = "share";
//    public static int[] i = {R.drawable.ic_img_normal, R.drawable.ic_img_balloon, R.drawable.ic_img_hexafluoride, R.drawable.ic_img_fast, R.drawable.ic_img_slow, R.drawable.ic_img_cave, R.drawable.ic_img_chipmunk, R.drawable.ic_img_monster, R.drawable.ic_img_alien, R.drawable.ic_img_kid, R.drawable.ic_img_bidsound, R.drawable.ic_img_smallsound, R.drawable.ic_img_bee, R.drawable.ic_img_danger, R.drawable.ic_img_spiral, R.drawable.ic_img_slowfast, R.drawable.ic_img_bass, R.drawable.ic_img_mid, R.drawable.ic_img_treble, R.drawable.ic_img_setting};
    public static String[] j = {"Normal", "Helium", "Hexafluoride", "Fast", "Slow", "Cave", "Chipmunk", "Monster", "Alien", "Kid", "Big Sound", "Small Sound", "Bee", "Death", "Spiral", "SlowFast", "Bass", "Mid", "Treble", "Custom"};

    static {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        g = sb.toString();
    }
}
