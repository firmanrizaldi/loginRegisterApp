package com.example.loginregisterapps;

import android.os.Parcel;
import android.os.Parcelable;

public class dataUser implements Parcelable {
    public String nama;
    public String npm;
    public String kelas;
    public String jurusan;
    public String key;

    public dataUser(){

    }

    public dataUser(String nama, String npm,String kelas, String jurusan) {
        this.nama = nama;
        this.npm = npm;
        this.kelas = kelas;
        this.jurusan = jurusan;
    }

    public static final Creator<dataUser> CREATOR = new Creator<dataUser>() {
        @Override
        public dataUser createFromParcel(Parcel in) {
            return new dataUser(in);
        }

        @Override
        public dataUser[] newArray(int size) {
            return new dataUser[size];
        }
    };

    protected dataUser(Parcel in) {
        nama = in.readString();
        npm = in.readString();
        kelas = in.readString();
         jurusan = in.readString();
        key = in.readString();
    }

    public String getKey(){ return  key;}
    public void setKey(String key) { this.key = key ;}
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNpm() {
        return npm;
    }
    public void setNpm(String npm) {
        this.npm = npm;
    }
    public String getKelas() {
        return kelas;
    }
    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    public String getJurusan() {
        return jurusan;
    }
    public void setJurusan(String jurusan) {
        this.jurusan = jurusan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nama);
        parcel.writeString(npm);
        parcel.writeString(kelas);
        parcel.writeString(jurusan);
        parcel.writeString(key);
    }
}
