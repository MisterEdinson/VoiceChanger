package com.audiosoundeffects.c_pack;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class b_c_class {
    private static Activity g;
    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;
    private c_c_class h;
    private c_c_class i;
    private boolean j;

    private b_c_class(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.h = this.i;
        this.e = aVar.e;
        this.f = aVar.f;
        this.c = aVar.c;
        this.d = aVar.d;
        this.j = aVar.k;
    }

    public b_c_class(a aVar, byte b2) {
        this(aVar);
    }

    public static class a {
        public static Activity h;
        public static c_c_class i;
        public static c_c_class j;
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public String g;
        public boolean k;

        public a(Activity activity) {
            h = activity;
        }

        public static class AnonymousClass1 implements View.OnClickListener {
            final Dialog b;
            final EditText str;

            public AnonymousClass1(EditText editText, Dialog dialog) {
                this.str = editText;
                this.b = dialog;
            }

            public final void onClick(View view) {
                if (this.str.equals("")) {
                    Toast.makeText(h, "No Text Found", Toast.LENGTH_SHORT).show();
                    return;
                }
                i.OnClick(this.str.getText().toString());
                this.b.dismiss();
            }
        }

        public static class AnonymousClass2 implements View.OnClickListener {
            final Dialog a;

            public AnonymousClass2(Dialog dialog) {
                this.a = dialog;
            }

            public final void onClick(View view) {
                j.OnClick("em");
                this.a.dismiss();
            }
        }
    }
}
