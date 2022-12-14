/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.List;

/**
 *
 * @author nyaw
 */
public class Kelas {

    private String kodeKelas;
    private String nama;
    private int tingkat;
    private List<Siswa> listSiswa;

    public Kelas() {
    }

    public Kelas(String kodeKelas, String nama, int tingkat) {
        this.kodeKelas = kodeKelas;
        this.nama = nama;
        this.tingkat = tingkat;
    }

    public List<Siswa> getListSiswa() {
        return listSiswa;
    }

    public void setListSiswa(List<Siswa> listSiswa) {
        this.listSiswa = listSiswa;
    }

    public String getKodeKelas() {
        return kodeKelas;
    }

    public void setKodeKelas(String kodeKelas) {
        this.kodeKelas = kodeKelas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getTingkat() {
        return tingkat;
    }

    public void setTingkat(int tingkat) {
        this.tingkat = tingkat;
    }

}
