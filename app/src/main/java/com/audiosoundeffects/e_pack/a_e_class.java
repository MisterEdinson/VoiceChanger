package com.audiosoundeffects.e_pack;

import java.io.File;

public class a_e_class {
    public static void a(File file) {
        if (file.isDirectory()) {
            for (String file2 : file.list()) {
                File file3 = new File(file, file2);
                if (file3.isDirectory()) {
                    a(file3);
                } else if (!file3.delete()) {
                }
            }
        }
        file.delete();
    }
}
