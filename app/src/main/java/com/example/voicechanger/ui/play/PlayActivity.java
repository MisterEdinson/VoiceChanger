package com.example.voicechanger.ui.play;

import static android.os.Environment.DIRECTORY_MUSIC;

import static com.example.voicechanger.data.utils.Constains.AUDIO_RECORDER_FILE_EXT_MP3;
import static com.example.voicechanger.data.utils.Constains.AUDIO_RECORDER_FILE_EXT_WAV;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.audiosoundeffects.b_pack.a_b_class;
import com.audiosoundeffects.c_pack.a_c_class;
import com.audiosoundeffects.c_pack.b_c_class;
import com.audiosoundeffects.c_pack.c_c_class;
import com.audiosoundeffects.c_pack.d_c_class;
import com.audiosoundeffects.c_pack.e_c_class;
import com.audiosoundeffects.d_pack.a_d_class;
import com.audiosoundeffects.e_pack.a_e_class;
import com.audiosoundeffects.e_pack.b_e_class;
import com.audiosoundeffects.e_pack.c_e_class;
import com.audiosoundeffects.e_pack.d_e_class;
import com.audiosoundeffects.e_pack.e_e_class;
import com.example.voicechanger.R;
import com.example.voicechanger.databinding.ActivityPlayBinding;
import com.warkiz.widget.IndicatorSeekBar;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import in.srain.cube.views.GridViewWithHeaderAndFooter;

public class PlayActivity extends AppCompatActivity implements View.OnClickListener, b_e_class.a{
    public ItemAdapter adapter;
    private ImageView back3;
    SharedPreferences.Editor editor;
    private ImageView imgDelete;
    public TextView imgOption;
    private LinearLayout imgThump;
    IndicatorSeekBar indicatorSeekBar;
    private boolean isMic = false;
    public boolean isOnSeek;
    public boolean isPlaying;
    public boolean isRelease;
    private TextView labelapp;
    private LinearLayout lladjustment;
    public LinearLayout lleffect;
    private LinearLayout llvoice;
    public GridViewWithHeaderAndFooter lvAMSearch;
    public int mDuration;
    public String mFileName;
    private FrameLayout mFl;
    private String mName;
    private int mState;
    public ArrayList<a_b_class> mdata;
    public boolean misRecordPage;
    SharedPreferences prefs = null;
    d_c_class.a prodia;
    private SeekBar sbMain;
    String str;
    private TextView tvTime;
    public TextView txtadjustment;
    public TextView txtvoice;
    Thread updateThread;
    public View viewadjustment;
    public View viewvoice;
    private native void ChangeState(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);
    private native void FrequencyDomain(int i, int i2, int i3, float f, float f2, float f3, float f4, float f5, float f6, String str2, String str3);
    private native short[] GetBuffer();
    private native void StopDomain();
    private native void SuperpoweredExample(int i, int i2, String str2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8);
    private native void onPlayPause(boolean z);
    private native void release();
    public native void SaveRecord(String str2, String str3);
    public native void onSeed(int i);
    public native void updateSeed();
    public void onClick(View view) {
        if (this.imgOption == view) {
            if (!this.isRelease) {
                saveFile(1, "");
            }
        } else if (this.imgDelete == view) {
            if (this.isPlaying) {
                pauseMedia();
            } else {
                playMedia();
            }
        }
    }
    public class ItemAdapter extends BaseAdapter {
        private Activity mContext;
        private ArrayList<a_b_class> mData;
        private int mPos = 0;
        public long getItemId(int i) {
            return (long) i;
        }
        public ItemAdapter(Activity activity, ArrayList<a_b_class> arrayList) {
            this.mContext = activity;
            this.mData = arrayList;
        }
        public int getCount() {
            return this.mData.size();
        }
        public a_b_class getItem(int i) {
            return this.mData.get(i);
        }
        public View getView(final int i, View view, ViewGroup viewGroup) {
            a_d_class a_d_class;
            View view2;
            String str;
            TextView textView;
            a_b_class item = getItem(i);
            if (view == null) {
                a_d_class = new a_d_class();
                view2 = LayoutInflater.from(this.mContext).inflate(R.layout.item_effect, (ViewGroup) null);
                a_d_class.a = (ImageView) view2.findViewById(R.id.imgThump);
                a_d_class.b = (TextView) view2.findViewById(R.id.tvTitle);
                a_d_class.c = (RelativeLayout) view2.findViewById(R.id.itemholderpar);
                a_d_class.d = (ImageView) view2.findViewById(R.id.selecticon);
                view2.setTag(a_d_class);
            } else {
                view2 = view;
                a_d_class = (com.audiosoundeffects.d_pack.a_d_class) view.getTag();
            }
            if (!item.c) {
                a_d_class.a.setImageResource(item.b);
            }
            if (this.mPos == i) {
                a_d_class.d.setVisibility(View.VISIBLE);
                textView = a_d_class.b;
            } else {
                a_d_class.d.setVisibility(View.GONE);
                textView = a_d_class.b;
            }
            a_d_class.b.setText(item.g);
            a_d_class.c.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i);
                    String[] strArr = {"ClickItem", sb.toString()};
                    b_e_class.a(strArr);
                }
            });
            return view2;
        }
        public void swapData(ArrayList<a_b_class> arrayList, int i) {
            this.mPos = i;
            this.mData = arrayList;
            notifyDataSetChanged();
        }
    }
    class SaveFileTask extends AsyncTask<Void, String, String> {
        String fileName;
        int state;

        SaveFileTask(String str, int i) {
            this.fileName = str;
            this.state = i;
        }
        @Override
        public String doInBackground(Void... voidArr) {
            File file = new File(Environment.getExternalStoragePublicDirectory(DIRECTORY_MUSIC) + "/Super Voice Changer");
            if (!file.exists()) {
                file.mkdirs();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(Environment.getExternalStoragePublicDirectory(DIRECTORY_MUSIC));
            sb.append("/Super Voice Changer/");
            sb.append(this.fileName + AUDIO_RECORDER_FILE_EXT_MP3);
            String sb2 = sb.toString();
            PlayActivity mainActivity = PlayActivity.this;
            mainActivity.SaveRecord(mainActivity.mFileName, sb2);
            return sb2;
        }

        public void onPostExecute(String str) {
            PlayActivity.this.getApplication();
            StringBuilder sb = new StringBuilder();
            sb.append("Saved! File in: ");
            sb.append(str);
            PlayActivity.this.imgOption.setEnabled(true);
            if (PlayActivity.this.prodia != null && d_c_class.a.isShowing()) {
                d_c_class.a.dismiss();
            }
            Toast.makeText(PlayActivity.this, "Song saved successfully", Toast.LENGTH_SHORT).show();
//            Glob.voice_path = str;
//            Glob.voice_name = str.substring(str.lastIndexOf("/") + 1);
            PlayActivity mainActivity = PlayActivity.this;
//            mainActivity.startActivity(new Intent(mainActivity, ShareActivity.class));
            PlayActivity.this.finish();
        }

        public void onPreExecute() {
            PlayActivity.this.imgOption.setEnabled(false);
            PlayActivity mainActivity = PlayActivity.this;
            mainActivity.prodia = new d_c_class.a(mainActivity);
            PlayActivity.this.prodia.b = false;
            PlayActivity.this.prodia.c = true;
            PlayActivity.this.prodia.a();
        }
    }

    public class ShowListTask extends AsyncTask<Void, Void, Void> {
        private ShowListTask() {
        }
        ShowListTask(PlayActivity mainActivity, PlayActivity mainActivity2, PlayActivity mainActivity3, PlayActivity mainActivity4) {
            this();
        }
        public Void doInBackground(Void... voidArr) {
            for (int i = 0; i < d_e_class.j.length; i++) {
                a_b_class a_b_class = new a_b_class();
                a_b_class.c = false;
                a_b_class.a = "";
//                a_b_class.b = d_e_class.i[i];
                a_b_class.g = d_e_class.j[i];
                PlayActivity.this.mdata.add(a_b_class);
            }
            return null;
        }
        public void onPostExecute(Void voidR) {
            PlayActivity.this.imgOption.setEnabled(true);
            if (PlayActivity.this.prodia != null && d_c_class.a.isShowing()) {
                d_c_class.a.dismiss();
            }
            if (!PlayActivity.this.misRecordPage) {
                PlayActivity mainActivity = PlayActivity.this;
                mainActivity.adapter = new ItemAdapter(mainActivity, mainActivity.mdata);
                PlayActivity.this.lvAMSearch.setAdapter((ListAdapter) PlayActivity.this.adapter);
                PlayActivity.this.adapter.notifyDataSetChanged();
            }
        }
        public void onPreExecute() {
            PlayActivity.this.imgOption.setEnabled(false);
            PlayActivity mainActivity = PlayActivity.this;
            mainActivity.prodia = new d_c_class.a(mainActivity);
            PlayActivity.this.prodia.b = false;
            PlayActivity.this.prodia.c = false;
            PlayActivity.this.prodia.a();
            PlayActivity.this.mdata = new ArrayList<>();
        }
    }

    static {
        try {
            System.loadLibrary("SuperpoweredExample");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateSong() {
        Context applicationContext = getApplicationContext();
        String str2 = this.mFileName;
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(applicationContext).edit();
        edit.putString("PATH", str2);
        edit.commit();
        updateTime(e_e_class.b(getApplicationContext(), this.mFileName));
    }

    private void customProperties(String[] strArr) {
        if (strArr[0].equals(d_e_class.a)) {
            a_e_class.a(new File(strArr[1]));
            new ShowListTask(this, this, this, this).execute(new Void[0]);
        } else if (strArr[0].equals(d_e_class.c)) {
            String str2 = strArr[1];
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setType("*/*");
                if (Build.VERSION.SDK_INT <= 25) {
                    intent.setDataAndType(Uri.fromFile(new File(str2)), "*/*");
                    startActivity(Intent.createChooser(intent, "Open with..."));
                    return;
                }
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str2)));
                startActivity(Intent.createChooser(intent, "Open with..."));
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }
        } else if (strArr[0].equals(d_e_class.d)) {
            a_b_class a = c_e_class.a(new File(strArr[1]));
            Dialog dialog = new Dialog(this, R.style.Base_Theme_VoiceChanger);
            dialog.requestWindowFeature(1);
            dialog.setContentView(R.layout.custom_properties_dialog);
            dialog.setCanceledOnTouchOutside(true);
            ((TextView) dialog.findViewById(R.id.tvTitle)).setText(a.g);
            ((TextView) dialog.findViewById(R.id.tvDetailTitle)).setText("Details:");
            ((TextView) dialog.findViewById(R.id.tvDetail)).setText("Duration: " + a.f);
            ((TextView) dialog.findViewById(R.id.tvType)).setText("Music");
            ((TextView) dialog.findViewById(R.id.tvPath)).setText(a.d);
            ((TextView) dialog.findViewById(R.id.tvSize)).setText(a.e);
            ((TextView) dialog.findViewById(R.id.tvCreated)).setText(e_e_class.a(new File(a.d).lastModified()));
            ((TextView) dialog.findViewById(R.id.tvModified)).setText(e_e_class.a(new File(a.d).lastModified()));
            ((TextView) dialog.findViewById(R.id.tvOK)).setOnClickListener(new e_c_class.AnonymousClass1(dialog));
            dialog.show();
        } else if (strArr[0].equals(d_e_class.h)) {
            String str3 = strArr[1];
            Intent intent2 = new Intent();
            intent2.setAction("android.intent.action.SEND");
            intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent2.setType("audio/*");
            try {
                if (Build.VERSION.SDK_INT <= 25) {
                    intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(str3)));
                    startActivity(Intent.createChooser(intent2, "share with..."));
                    return;
                }
                Uri uriForFile = FileProvider.getUriForFile(this, "voicechanger.voiceeditor.funnyvoicemaker.provider", new File(str3));
                intent2.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                intent2.putExtra("android.intent.extra.STREAM", uriForFile);
                startActivity(Intent.createChooser(intent2, "share with..."));
            } catch (Exception e2) {
                e2.printStackTrace();
                Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
            }
        } else if (strArr[0].equals(d_e_class.e)) {
            this.mName = strArr[1];
            saveFile(100, new File(strArr[1]).getName());
        } else if (strArr[0].equals(d_e_class.f)) {
            StringBuilder sb = new StringBuilder();
            String str4 = this.mName;
            sb.append(str4.substring(0, str4.lastIndexOf("/")));
            sb.append("/");
            sb.append(strArr[1]);
            String sb2 = sb.toString();
            if (!sb2.toLowerCase().endsWith(AUDIO_RECORDER_FILE_EXT_WAV)) {
                sb2 = sb2 + AUDIO_RECORDER_FILE_EXT_WAV;
            }
            new File(this.mName).renameTo(new File(sb2));
            new ShowListTask(this, this, this, this).execute(new Void[0]);
        }
    }

    public void initMain() {
        try {
            this.mFileName = getIntent().getStringExtra("filepath");
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    PlayActivity.this.UpdateSong();
                }
            }, 500);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void pauseMedia() {
        this.imgDelete.setImageResource(R.drawable.ic_play);
        this.isPlaying = false;
        if (!this.isRelease) {
            onPlayPause(false);
        }
    }

    public void playMedia() {
        try {
            if (!this.misRecordPage) {
                this.adapter.swapData(this.mdata, this.mState);
            }
            initMediaPlayer();
            this.imgDelete.setImageResource(R.drawable.ic_pause);
            this.isPlaying = true;
            onPlayPause(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void refreshSong() {
        updateTime(e_e_class.b(getApplicationContext(), this.mFileName));
        releaseMusic();
        playMedia();
    }

    public void releaseMusic() {
        if (!this.isRelease) {
            this.mState = 0;
            pauseMedia();
            release();
            this.sbMain.setProgress(0);
            this.isRelease = true;
        }
    }

    private void saveFile(int i, String str2) {
        String str3;
        File file = new File(this.mFileName);
        if (file.getName().contains(".")) {
            str3 = file.getName().substring(0, file.getName().lastIndexOf(46)) + "_";
        } else {
            str3 = file.getName();
        }
        if (this.mState >= 0) {
            str3 = str3 + d_e_class.j[this.mState];
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd_HH-mm");
        final String str4 = str3 + "_" + simpleDateFormat.format(new Date());
        b_c_class.a aVar = new b_c_class.a(this);
        aVar.a = "File Name";
        aVar.e = "#374761";
        aVar.c = "Ok";
        aVar.f = "#374761";
        aVar.k = false;
        aVar.d = "Cancel";
        aVar.b = "Give name to your song with effects";
        aVar.g = str4;
        b_c_class.a.i = new c_c_class() {
            public void OnClick(String str) {
                if (str.equals("")) {
                    str = str4;
                }
                b_e_class.a(new String[]{"SAVE_FILE", str});
            }
        };
        b_c_class.a.j = new c_c_class() {
            public void OnClick(String str) {
            }
        };
        Dialog dialog = new Dialog(b_c_class.a.h);
        dialog.requestWindowFeature(1);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        dialog.setCancelable(aVar.k);
        dialog.setContentView(R.layout.texteditdialog);
        TextView textView = (TextView) dialog.findViewById(R.id.negativeBtn);
        TextView textView2 = (TextView) dialog.findViewById(R.id.positiveBtn);
        EditText editText = (EditText) dialog.findViewById(R.id.packname);
        editText.setText(aVar.g);
        ((TextView) dialog.findViewById(R.id.title)).setText(aVar.a);
        ((TextView) dialog.findViewById(R.id.message)).setText(aVar.b);
        if (aVar.c != null) {
            textView2.setText(aVar.c);
        }
        if (aVar.d != null) {
            textView.setText(aVar.d);
        }
        if (b_c_class.a.i != null) {
            textView2.setOnClickListener(new b_c_class.a.AnonymousClass1(editText, dialog));
        }
        if (b_c_class.a.j != null) {
            textView.setVisibility(View.VISIBLE);
            textView.setOnClickListener(new b_c_class.a.AnonymousClass2(dialog));
        }
        dialog.getWindow().clearFlags(131080);
        dialog.getWindow().setSoftInputMode(5);
        editText.requestFocus();
        dialog.show();
        new b_c_class(aVar, (byte) 0);
        if (this.isPlaying) {
            pauseMedia();
        }
    }
    private void updateTime(int i) {
        int i2 = i / 1000;
        String valueOf = String.valueOf(i2 / 60);
        String valueOf2 = String.valueOf(i2 % 60);
        if (valueOf.length() == 1) {
            valueOf = "0" + valueOf;
        }
        if (valueOf2.length() == 1) {
            valueOf2 = "0" + valueOf2;
        }
        this.tvTime.setText(valueOf + ":" + valueOf2);
    }
    public void getDuration(int i) {
        this.sbMain.setMax(i - 100);
    }
    public float[] getEffect(int i) {
        float[] fArr = new float[7];
        if (i == d_e_class.j.length - 1) {
            return processToItem();
        }
        fArr[6] = 1.0f;
        fArr[5] = 1.0f;
        fArr[4] = 1.0f;
        fArr[2] = 1.0f;
        fArr[0] = 1.0f;
        fArr[3] = 0.0f;
        fArr[1] = 0.0f;
        switch (i) {
            case 1:
                fArr[1] = 10.0f;
                return fArr;
            case 2:
                fArr[1] = -8.0f;
                return fArr;
            case 3:
                fArr[0] = 1.5f;
                return fArr;
            case 4:
                fArr[0] = 0.5f;
                return fArr;
            case 5:
                fArr[0] = 1.01f;
                fArr[1] = 0.01f;
                fArr[3] = 0.85f;
                return fArr;
            case 6:
                fArr[1] = 12.0f;
                fArr[0] = 1.5f;
                return fArr;
            case 7:
                fArr[1] = -10.0f;
                fArr[0] = 0.5f;
                return fArr;
            case 8:
                fArr[0] = 0.75f;
                fArr[1] = 6.0f;
                fArr[3] = 0.75f;
                return fArr;
            case 9:
                fArr[1] = 7.0f;
                return fArr;
            case 10:
                fArr[6] = 2.0f;
                return fArr;
            case 11:
                fArr[6] = 0.3f;
                return fArr;
            case 12:
                fArr[0] = 2.5f;
                fArr[1] = 10.0f;
                return fArr;
            case 13:
                fArr[0] = 0.7f;
                fArr[1] = -12.0f;
                fArr[3] = 0.75f;
                fArr[6] = 1.3f;
                return fArr;
            case 14:
                fArr[6] = 1.3f;
                return fArr;
            case 16:
                fArr[2] = 1.3f;
                fArr[4] = 0.0f;
                fArr[5] = 0.0f;
                return fArr;
            case 17:
                fArr[2] = 0.0f;
                fArr[5] = 0.0f;
                return fArr;
            case 18:
                fArr[2] = 0.0f;
                fArr[4] = 0.0f;
                fArr[5] = 1.3f;
                return fArr;
            default:
                return fArr;
        }
    }
    public void initMediaPlayer() {
        float[] effect = getEffect(this.mState);
        if (this.isRelease) {
            SuperpoweredExample(Integer.parseInt(Build.VERSION.SDK_INT >= 17 ? ((AudioManager) getApplicationContext().getSystemService(AUDIO_SERVICE)).getProperty("android.media.property.OUTPUT_SAMPLE_RATE") : "44100"), Integer.parseInt("512"), this.mFileName, effect[0], effect[1], effect[2], effect[3], effect[4], effect[5], effect[6], (float) this.mState);
            this.isRelease = false;
            return;
        }
        ChangeState(effect[0], effect[1], effect[2], effect[3], effect[4], effect[5], effect[6], (float) this.mState);
    }
    public void javaDefineString(int i) {
        this.mDuration = i;
        this.sbMain.setProgress(this.mDuration);
    }
    public void onBackPressed() {
        super.onBackPressed();
        if (!PlayActivity.this.isRelease) {
            PlayActivity.this.releaseMusic();
        }
        PlayActivity.this.finish();
    }
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setFlags(67108864, 67108864);
        }
        setContentView(R.layout.activity_play);
        //init
        this.prefs = getSharedPreferences(getPackageName(), 0);
        this.lvAMSearch = (GridViewWithHeaderAndFooter) findViewById(R.id.lvAMSearch);
        this.imgThump = (LinearLayout) findViewById(R.id.imgThump);
        this.imgOption = (TextView) findViewById(R.id.btnSaveStudio);
        this.imgDelete = (ImageView) findViewById(R.id.btnPlay);
        this.tvTime = (TextView) findViewById(R.id.tvTimeSong);
        this.sbMain = (SeekBar) findViewById(R.id.seekMain);
        this.labelapp = (TextView) findViewById(R.id.labelapp);
        this.llvoice = (LinearLayout) findViewById(R.id.llvoice);
        this.lladjustment = (LinearLayout) findViewById(R.id.lladjustment);
        this.txtvoice = (TextView) findViewById(R.id.txtvoice);
        this.txtadjustment = (TextView) findViewById(R.id.txtadjustment);
        this.viewvoice = findViewById(R.id.viewvoice);
        this.viewadjustment = findViewById(R.id.viewadjustment);
        this.lleffect = (LinearLayout) findViewById(R.id.lleffect);
        this.txtvoice.setTextColor(getResources().getColor(R.color.black));
        this.txtadjustment.setTextColor(getResources().getColor(R.color.silver));
        this.viewvoice.setVisibility(View.VISIBLE);
        this.viewadjustment.setVisibility(View.GONE);
        this.lvAMSearch.setVisibility(View.VISIBLE);
        this.lleffect.setVisibility(View.GONE);
        this.back3 = (ImageView) findViewById(R.id.btnBack);
        // listeners
        this.llvoice.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PlayActivity.this.txtvoice.setTextColor(PlayActivity.this.getResources().getColor(R.color.black));
                PlayActivity.this.txtadjustment.setTextColor(PlayActivity.this.getResources().getColor(R.color.silver));
                PlayActivity.this.viewvoice.setVisibility(View.VISIBLE);
                PlayActivity.this.viewadjustment.setVisibility(View.GONE);
                PlayActivity.this.lvAMSearch.setVisibility(View.VISIBLE);
                PlayActivity.this.lleffect.setVisibility(View.GONE);
            }
        });
        this.lladjustment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PlayActivity.this.txtvoice.setTextColor(PlayActivity.this.getResources().getColor(R.color.silver));
                PlayActivity.this.txtadjustment.setTextColor(PlayActivity.this.getResources().getColor(R.color.black));
                PlayActivity.this.viewvoice.setVisibility(View.GONE);
                PlayActivity.this.viewadjustment.setVisibility(View.VISIBLE);
                PlayActivity.this.lvAMSearch.setVisibility(View.GONE);
                PlayActivity.this.lleffect.setVisibility(View.VISIBLE);
                a_c_class a_c_class = new a_c_class();
                TextView textView = (TextView) PlayActivity.this.findViewById(R.id.tvVolume);
                TextView textView2 = (TextView) PlayActivity.this.findViewById(R.id.tvPitch);
                IndicatorSeekBar indicatorSeekBar = (IndicatorSeekBar) PlayActivity.this.findViewById(R.id.sbVolume);
                IndicatorSeekBar indicatorSeekBar2 = (IndicatorSeekBar) PlayActivity.this.findViewById(R.id.sbPitch);
                IndicatorSeekBar indicatorSeekBar3 = (IndicatorSeekBar) PlayActivity.this.findViewById(R.id.sbTempo);
                IndicatorSeekBar indicatorSeekBar4 = (IndicatorSeekBar) PlayActivity.this.findViewById(R.id.sbEcho);
                int a = e_e_class.a((Context) PlayActivity.this, "sbVolume");
                TextView textView3 = (TextView) PlayActivity.this.findViewById(R.id.tvGate);
                IndicatorSeekBar indicatorSeekBar5 = (IndicatorSeekBar) PlayActivity.this.findViewById(R.id.sbGate);
                IndicatorSeekBar indicatorSeekBar6 = (IndicatorSeekBar) PlayActivity.this.findViewById(R.id.sbFlanger);
                TextView textView4 = (TextView) PlayActivity.this.findViewById(R.id.tvFlanger);
                TextView textView5 = (TextView) PlayActivity.this.findViewById(R.id.tvReverb);
                IndicatorSeekBar indicatorSeekBar7 = (IndicatorSeekBar) PlayActivity.this.findViewById(R.id.sbReverb);
                TextView textView6 = (TextView) PlayActivity.this.findViewById(R.id.tvEcho);
                TextView textView7 = (TextView) PlayActivity.this.findViewById(R.id.tvTempo);
                if (a == 0 && e_e_class.a((Context) PlayActivity.this, "sbPitch") == 0 && e_e_class.a((Context) PlayActivity.this, "sbTempo") == 0 && e_e_class.a((Context) PlayActivity.this, "sbEcho") == 0 && e_e_class.a((Context) PlayActivity.this, "sbReverb") == 0 && e_e_class.a((Context) PlayActivity.this, "sbFlanger") == 0 && e_e_class.a((Context) PlayActivity.this, "sbGate") == 0) {
                    PlayActivity mainActivity = PlayActivity.this;
                    mainActivity.indicatorSeekBar = indicatorSeekBar4;
                    e_e_class.a(mainActivity, "sbVolume", 50);
                    e_e_class.a(PlayActivity.this, "sbPitch", 50);
                    e_e_class.a(PlayActivity.this, "sbTempo", 50);
                    e_e_class.a(PlayActivity.this, "sbEcho", 50);
                    PlayActivity mainActivity2 = PlayActivity.this;
                    mainActivity2.str = "sbEcho";
                    e_e_class.a(mainActivity2, "sbReverb", 0);
                    e_e_class.a(PlayActivity.this, "sbFlanger", 50);
                    e_e_class.a(PlayActivity.this, "sbGate", 50);
                } else {
                    PlayActivity mainActivity3 = PlayActivity.this;
                    mainActivity3.str = "sbEcho";
                    mainActivity3.indicatorSeekBar = indicatorSeekBar4;
                }
                a_c_class.a(PlayActivity.this, "sbVolume", textView, indicatorSeekBar);
                a_c_class.a(PlayActivity.this, "sbPitch", textView2, indicatorSeekBar2);
                a_c_class.a(PlayActivity.this, "sbTempo", textView7, indicatorSeekBar3);
                String str = PlayActivity.this.str;
                PlayActivity mainActivity4 = PlayActivity.this;
                a_c_class.a(mainActivity4, str, textView6, mainActivity4.indicatorSeekBar);
                a_c_class.a(PlayActivity.this, "sbReverb", textView5, indicatorSeekBar7);
                a_c_class.a(PlayActivity.this, "sbFlanger", textView4, indicatorSeekBar6);
                a_c_class.a(PlayActivity.this, "sbGate", textView3, indicatorSeekBar5);
                PlayActivity.this.playMedia();
            }
        });
        this.back3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PlayActivity.this.onBackPressed();
            }
        });
        this.imgOption.setOnClickListener(this);
        this.imgDelete.setOnClickListener(this);
        this.sbMain.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (z && !PlayActivity.this.isRelease) {
                    PlayActivity mainActivity = PlayActivity.this;
                    mainActivity.isOnSeek = true;
                    mainActivity.mDuration = i;
                    mainActivity.onSeed(i);
                    PlayActivity.this.isOnSeek = false;
                }
            }
        });
        initMain();
        this.isPlaying = false;
        this.isOnSeek = false;
        this.isRelease = true;
        this.mDuration = 0;
        this.mState = 0;
        new ShowListTask(this, this, this, this).execute(new Void[0]);
        startPlayProgressUpdater();
    }
    public void onDestroy() {
        super.onDestroy();
        releaseMusic();
        this.updateThread.interrupt();
    }
    public void onResume() {
        super.onResume();
        b_e_class.a = this;
    }
    public void onStop() {
        super.onStop();
    }
    public float[] processToItem() {
        float[] fArr = {(float) (e_e_class.a(getApplicationContext(), "sbTempo") / 5), ((float) (e_e_class.a(getApplicationContext(), "sbPitch") / 4)) - 12.5f, ((float) e_e_class.a(getApplicationContext(), "sbEcho")) / 10.0f, ((float) e_e_class.a(getApplicationContext(), "sbReverb")) / 100.0f, ((float) e_e_class.a(getApplicationContext(), "sbFlanger")) / 10.0f, ((float) e_e_class.a(getApplicationContext(), "sbGate")) / 10.0f, ((float) e_e_class.a(getApplicationContext(), "sbVolume")) / 10.0f};
        if (fArr[6] > 5.0f) {
            fArr[6] = fArr[6] - 5.0f;
        } else {
            fArr[6] = fArr[6] / 5.0f;
        }
        if (fArr[0] > 10.0f) {
            fArr[0] = fArr[0] - 10.0f;
        } else {
            fArr[0] = fArr[0] / 10.0f;
        }
        if (fArr[2] < 5.0f) {
            fArr[2] = fArr[2] / 5.0f;
        } else {
            fArr[2] = fArr[2] - 4.0f;
        }
        if (fArr[4] < 5.0f) {
            fArr[4] = fArr[4] / 5.0f;
        } else {
            fArr[4] = fArr[4] - 4.0f;
        }
        if (fArr[5] < 5.0f) {
            fArr[5] = fArr[5] / 5.0f;
        } else {
            fArr[5] = fArr[5] - 4.0f;
        }
        return fArr;
    }

    public void startPlayProgressUpdater() {
        this.updateThread = new Thread(new Runnable() {
            public void run() {
                while (!PlayActivity.this.updateThread.isInterrupted()) {
                    try {
                        Thread.sleep(100);
                        PlayActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                if (!PlayActivity.this.isOnSeek && PlayActivity.this.isPlaying) {
                                    PlayActivity.this.updateSeed();
                                }
                            }
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return;
                    }
                }
            }
        });
        this.updateThread.start();
    }

    public void eventCompleted(String[] strArr) {
        char c;
        String str2;
        String str3 = strArr[0];
        switch (str3.hashCode()) {
            case -1881265346:
                if (str3.equals("RENAME")) {
                    c = 1;
                    break;
                }
            case -1327333415:
                if (str3.equals("ClickRecord")) {
                    c = 8;
                    break;
                }
            case -1295101186:
                if (str3.equals("SAVE_FILE")) {
                    c = 9;
                    break;
                }
            case 76327:
                if (str3.equals("MIC")) {
                    c = 1111;
                    break;
                }
            case 38588571:
                if (str3.equals("ClickItem")) {
                    c = 7;
                    break;
                }
            case 948441424:
                if (str3.equals("VoiceChanger")) {
                    c = 6;
                    break;
                }
            case 1810316468:
                if (str3.equals("RENAME2")) {
                    c = 2;
                    break;
                }
            case 1810316469:
                if (str3.equals("RENAME3")) {
                    c = 3;
                    break;
                }
            case 1810316470:
                if (str3.equals("RENAME4")) {
                    c = 4;
                    break;
                }
            case 1810316471:
                if (str3.equals("RENAME5")) {
                    c = 5;
                    break;
                }
            default:
                c = 65535;
                break;
        }
        if (c != 1111) {
            switch (c) {
                case 1:
                    strArr[1] = strArr[1] + AUDIO_RECORDER_FILE_EXT_WAV;
                    return;
                case 2:
                    strArr[1] = strArr[1] + AUDIO_RECORDER_FILE_EXT_WAV;
                    return;
                case 3:
                    strArr[1] = strArr[1] + AUDIO_RECORDER_FILE_EXT_WAV;
                    return;
                case 4:
                    strArr[1] = strArr[1] + AUDIO_RECORDER_FILE_EXT_WAV;
                    return;
                case 5:
                    strArr[1] = strArr[1] + AUDIO_RECORDER_FILE_EXT_WAV;
                    return;
                case 6:
                    playMedia();
                    return;
                case 7:
                    this.mState = Integer.parseInt(strArr[1]);
                    if (this.mState == d_e_class.j.length - 1) {
                        this.txtvoice.setTextColor(getResources().getColor(R.color.silver));
                        this.txtadjustment.setTextColor(getResources().getColor(R.color.colorAccent));
                        this.viewvoice.setVisibility(View.GONE);
                        this.viewadjustment.setVisibility(View.VISIBLE);
                        this.lvAMSearch.setVisibility(View.GONE);
                        this.lleffect.setVisibility(View.VISIBLE);
                        a_c_class a_c_class = new a_c_class();
                        TextView textView = (TextView) findViewById(R.id.tvVolume);
                        TextView textView2 = (TextView) findViewById(R.id.tvPitch);
                        TextView textView3 = (TextView) findViewById(R.id.tvTempo);
                        IndicatorSeekBar indicatorSeekBar2 = (IndicatorSeekBar) findViewById(R.id.sbVolume);
                        IndicatorSeekBar indicatorSeekBar3 = (IndicatorSeekBar) findViewById(R.id.sbPitch);
                        IndicatorSeekBar indicatorSeekBar4 = (IndicatorSeekBar) findViewById(R.id.sbTempo);
                        int a = e_e_class.a((Context) this, "sbVolume");
                        TextView textView4 = (TextView) findViewById(R.id.tvGate);
                        IndicatorSeekBar indicatorSeekBar5 = (IndicatorSeekBar) findViewById(R.id.sbGate);
                        TextView textView5 = (TextView) findViewById(R.id.tvFlanger);
                        IndicatorSeekBar indicatorSeekBar6 = (IndicatorSeekBar) findViewById(R.id.sbFlanger);
                        TextView textView6 = (TextView) findViewById(R.id.tvReverb);
                        IndicatorSeekBar indicatorSeekBar7 = (IndicatorSeekBar) findViewById(R.id.sbReverb);
                        IndicatorSeekBar indicatorSeekBar8 = (IndicatorSeekBar) findViewById(R.id.sbEcho);
                        TextView textView7 = (TextView) findViewById(R.id.tvEcho);
                        if (a == 0 && e_e_class.a((Context) this, "sbPitch") == 0 && e_e_class.a((Context) this, "sbTempo") == 0 && e_e_class.a((Context) this, "sbEcho") == 0 && e_e_class.a((Context) this, "sbReverb") == 0 && e_e_class.a((Context) this, "sbFlanger") == 0 && e_e_class.a((Context) this, "sbGate") == 0) {
                            e_e_class.a(this, "sbVolume", 50);
                            e_e_class.a(this, "sbPitch", 50);
                            e_e_class.a(this, "sbTempo", 50);
                            e_e_class.a(this, "sbEcho", 50);
                            str2 = "sbEcho";
                            e_e_class.a(this, "sbReverb", 0);
                            e_e_class.a(this, "sbFlanger", 50);
                            e_e_class.a(this, "sbGate", 50);
                        } else {
                            str2 = "sbEcho";
                        }
                        a_c_class.a(this, "sbVolume", textView, indicatorSeekBar2);
                        a_c_class.a(this, "sbPitch", textView2, indicatorSeekBar3);
                        a_c_class.a(this, "sbTempo", textView3, indicatorSeekBar4);
                        String str4 = str2;
                        a_c_class.a(this, str4, textView7, indicatorSeekBar8);
                        a_c_class.a(this, "sbReverb", textView6, indicatorSeekBar7);
                        a_c_class.a(this, "sbFlanger", textView5, indicatorSeekBar6);
                        a_c_class.a(this, "sbGate", textView4, indicatorSeekBar5);
                    }
                    playMedia();
                    return;
                case 8:
                    this.mFileName = strArr[1];
                    refreshSong();
                    return;
                case 9:
                    new SaveFileTask(strArr[1], 2).execute(new Void[0]);
                    return;
                default:
                    customProperties(strArr);
                    return;
            }
        } else {
            Toast.makeText(getBaseContext(), "No Option", Toast.LENGTH_SHORT).show();
        }
    }
}