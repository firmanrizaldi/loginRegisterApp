package com.example.loginregisterapps;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DataAdapter extends RecyclerView.ViewHolder {
    public TextView nama, npm, kelas, jurusan;
    private Context mContext;
    private List<dataUser> list;

    public DataAdapter(View itemView) {
        super(itemView);
        nama = itemView.findViewById(R.id.tv_movie_title);
        npm = itemView.findViewById(R.id.tv_movie_sinopsis);
        kelas = itemView.findViewById(R.id.tv_movie_kelas);
        jurusan = itemView.findViewById(R.id.tv_movie_jurusan);
    }

    public void bindToPerusahaan(dataUser dataUser, View.OnClickListener onClickListener) {
        nama.setText(dataUser.getNama());
        npm.setText(dataUser.getNpm());
        kelas.setText(dataUser.getKelas());
        jurusan.setText(dataUser.getJurusan());

    }

}
