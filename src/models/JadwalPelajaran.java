/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nyaw
 */
public class JadwalPelajaran {

    private String kodeJadwal;
    private int waktuMulai;
    private int waktuSelesai;
    private String hari;
    private Guru guru;
    private Kelas kelas;
    private Siswa[] listSiswa;

    public String getKodeJadwal() {
        return kodeJadwal;
    }

    public void setKodeJadwal(String kodeJadwal) {
        this.kodeJadwal = kodeJadwal;
    }

    public int getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(int waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public int getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(int waktuSelesai) {
        this.waktuSelesai = waktuSelesai;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public Guru getGuru() {
        return guru;
    }

    public void setGuru(Guru guru) {
        this.guru = guru;
    }

    public Kelas getKelas() {
        return kelas;
    }

    public void setKelas(Kelas kelas) {
        this.kelas = kelas;
    }

    public Siswa[] getListSiswa() {
        return listSiswa;
    }

    public void setListSiswa(Siswa[] listSiswa) {
        this.listSiswa = listSiswa;
    }

}
