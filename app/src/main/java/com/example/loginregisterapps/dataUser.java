package com.example.loginregisterapps;

public class dataUser {
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

}
