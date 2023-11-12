package com.audiosoundeffects.a_pack;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.audiosoundeffects.b_pack.b_b_class;
import com.example.voicechanger.R;

import java.util.ArrayList;

public class a_b_adapter extends RecyclerView.Adapter<a_b_adapter.a> {
    public b c;
    public delete_inteface inteface;
    public share_inteface intefaceshare;
    private ArrayList<b_b_class> d;

    public a_b_adapter(ArrayList<b_b_class> arrayList) {
        this.d = arrayList;
    }

    public int getItemCount() {
        return this.d.size();
    }

    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        //return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.maingrid_full, viewGroup, false), this.c, this.inteface, this.intefaceshare);
        return null;
    }

    public void onBindViewHolder(a aVar, int i) {
        aVar.s.setText(this.d.get(i).c);
    }

    public interface b {
        void a(int i);
    }

    public interface delete_inteface {
        void a(int i);
    }

    public interface share_inteface {
        void a(int i);
    }

    public class a extends RecyclerView.ViewHolder {
        ImageView delete;
        LinearLayout main_lin;
        ImageView r;
        TextView s;
        ImageView share;

        a(View view, final b bVar, final delete_inteface delete_inteface, final share_inteface share_inteface) {
            super(view);
//            this.delete = (ImageView) view.findViewById(R.id.delete);
//            this.share = (ImageView) view.findViewById(R.id.share);
//            this.r = (ImageView) view.findViewById(R.id.home_list_icon);
//            this.s = (TextView) view.findViewById(R.id.home_list_title);
//            this.main_lin = (LinearLayout) view.findViewById(R.id.main_lin);
            this.main_lin.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    int adapterPosition;
                    if (bVar != null && (adapterPosition = a.this.getAdapterPosition()) != -1) {
                        bVar.a(adapterPosition);
                    }
                }
            });
            this.delete.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int adapterPosition;
                    if (delete_inteface != null && (adapterPosition = a.this.getAdapterPosition()) != -1) {
                        delete_inteface.a(adapterPosition);
                    }
                }
            });
            this.share.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    int adapterPosition;
                    if (share_inteface != null && (adapterPosition = a.this.getAdapterPosition()) != -1) {
                        share_inteface.a(adapterPosition);
                    }
                }
            });
        }
    }
}
