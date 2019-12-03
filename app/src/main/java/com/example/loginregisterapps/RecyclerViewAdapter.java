package com.example.loginregisterapps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    //Deklarasi Variable
    private ArrayList<dataUser> listMahasiswa;
    private Context context;

    //Membuat Konstruktor, untuk menerima input dari Database
    public RecyclerViewAdapter(ArrayList<dataUser> listMahasiswa, Context context) {
        this.listMahasiswa = listMahasiswa;
        this.context = context;
    }

    //ViewHolder Digunakan Untuk Menyimpan Referensi Dari View-View
    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Npm, Nama, Jurusan, Kelas;
        private LinearLayout ListItem;

        ViewHolder(View itemView) {
            super(itemView);
            //Menginisialisasi View-View yang terpasang pada layout RecyclerView kita
            Npm = itemView.findViewById(R.id.npm);
            Nama = itemView.findViewById(R.id.nama);
            Jurusan = itemView.findViewById(R.id.jurusan);
            Kelas = itemView.findViewById(R.id.kelas) ;
            ListItem = itemView.findViewById(R.id.list_item);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Membuat View untuk Menyiapkan dan Memasang Layout yang Akan digunakan pada RecyclerView
        View V = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_data, parent, false);
        return new ViewHolder(V);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        //Mengambil Nilai/Value yenag terdapat pada RecyclerView berdasarkan Posisi Tertentu
        final String Npm = listMahasiswa.get(position).getNpm();
        final String Nama = listMahasiswa.get(position).getNama();
        final String Jurusan = listMahasiswa.get(position).getJurusan();
        final String Kelas = listMahasiswa.get(position).getKelas();

        //Memasukan Nilai/Value kedalam View (TextView: NIM, Nama, Jurusan)
        holder.Npm.setText("NPM: "+Npm);
        holder.Nama.setText("Nama: "+Nama);
        holder.Kelas.setText("Kelas: "+Kelas);
        holder.Jurusan.setText("Jurusan: "+Jurusan);

        holder.ListItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                /*
                  Kodingan untuk membuat fungsi Edit dan Delete,
                  yang akan dibahas pada Tutorial Berikutnya.
                 */
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        //Menghitung Ukuran/Jumlah Data Yang Akan Ditampilkan Pada RecyclerView
        return listMahasiswa.size();
    }

}
