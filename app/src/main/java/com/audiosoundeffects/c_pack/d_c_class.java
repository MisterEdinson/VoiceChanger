package com.audiosoundeffects.c_pack;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.TextView;

public class d_c_class {
    public static Dialog a;
    private static Activity b;
    private boolean c;

    private d_c_class(a aVar) {
        b = aVar.a;
        this.c = aVar.b;
    }

    public d_c_class(a aVar, byte b2) {
        this(aVar);
    }

    public static class a {
        public boolean b;
        public boolean c = true;
        Activity a;
        private TextView d;

        public a(Activity activity) {
            this.a = activity;
        }

        public final d_c_class a() {
            Dialog dialog = new Dialog(this.a);
            d_c_class.a = dialog;
            dialog.requestWindowFeature(1);
            d_c_class.a.getWindow().setBackgroundDrawable(new ColorDrawable(0));
            d_c_class.a.setCancelable(this.b);
//            d_c_class.a.setContentView(R.layout.dialog_prepare);
//            this.d = (TextView) d_c_class.a.findViewById(R.id.messagedsn);
            if (this.c) {
                this.d.setVisibility(View.VISIBLE);
            } else {
                this.d.setVisibility(View.GONE);
            }
            d_c_class.a.show();
            return new d_c_class(this, (byte) 0);
        }
    }
}
