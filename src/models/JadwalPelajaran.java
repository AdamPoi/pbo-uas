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
    private int waktuPembelajaran;
    private String hari;
    private Guru guru;
    private Kelas kelas;

    public JadwalPelajaran(String kodeJadwal, int waktuPembelajaran, String hari, Guru guru, Kelas kelas) {
        this.kodeJadwal = kodeJadwal;
        this.waktuPembelajaran = waktuPembelajaran;
        this.hari = hari;
        this.guru = guru;
        this.kelas = kelas;
    }

    public String getKodeJadwal() {
        return kodeJadwal;
    }

    public void setKodeJadwal(String kodeJadwal) {
        this.kodeJadwal = kodeJadwal;
    }

    public int getWaktuPembelajaran() {
        return waktuPembelajaran;
    }

    public void setWaktuPembelajaran(int waktuPembelajaran) {
        this.waktuPembelajaran = waktuPembelajaran;
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

}
