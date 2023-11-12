package com.audiosoundeffects.c_pack;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;


import com.audiosoundeffects.e_pack.b_e_class;
import com.audiosoundeffects.e_pack.e_e_class;
import com.warkiz.widget.IndicatorSeekBar;
import com.warkiz.widget.OnSeekChangeListener;
import com.warkiz.widget.SeekParams;

public class a_c_class extends b_e_class {

    public final void a(final Context context, final String str, final TextView textView, IndicatorSeekBar indicatorSeekBar) {
        indicatorSeekBar.setProgress((float) e_e_class.a(context, str));
        StringBuilder sb = new StringBuilder();
        sb.append(e_e_class.a(context, str));
        textView.setText(sb.toString() + "%");
        indicatorSeekBar.setOnSeekChangeListener(new OnSeekChangeListener() {
            public void onStartTrackingTouch(IndicatorSeekBar indicatorSeekBar) {
            }

            public void onStopTrackingTouch(IndicatorSeekBar indicatorSeekBar) {
            }

            public void onSeeking(SeekParams seekParams) {
                e_e_class.a(context, str, seekParams.progress);
                StringBuilder sb = new StringBuilder();
                sb.append(seekParams.progress);
                textView.setText(sb.toString() + "%");
                b_e_class.a(new String[]{"VoiceChanger"});
            }
        });
    }

    public class C0015AnonymousClass1 implements View.OnClickListener {
        final Dialog a;

        public C0015AnonymousClass1(Dialog dialog) {
            this.a = dialog;
        }

        public final void onClick(View view) {
            this.a.dismiss();
        }
    }
}
