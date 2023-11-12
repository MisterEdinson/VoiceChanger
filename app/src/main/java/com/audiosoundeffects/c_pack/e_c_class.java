package com.audiosoundeffects.c_pack;

import android.app.Dialog;
import android.view.View;
import com.audiosoundeffects.e_pack.b_e_class;

public class e_c_class extends b_e_class {

    public static class AnonymousClass1 implements View.OnClickListener {
        final Dialog a;

        public AnonymousClass1(Dialog dialog) {
            this.a = dialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
        }
    }
}
