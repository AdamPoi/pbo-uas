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
    private String waktuMulai;
    private String waktuSelesai;
    private String hari;
    private Guru guru;
    private Kelas kelas;
    private Siswa[] listSiswa;

    public JadwalPelajaran() {
    }

    public JadwalPelajaran(String kodeJadwal, String waktuMulai, String waktuSelesai, String hari, Guru guru, Kelas kelas, Siswa[] listSiswa) {
        this.kodeJadwal = kodeJadwal;
        this.waktuMulai = waktuMulai;
        this.waktuSelesai = waktuSelesai;
        this.hari = hari;
        this.guru = guru;
        this.kelas = kelas;
        this.listSiswa = listSiswa;
    }

    public String getKodeJadwal() {
        return kodeJadwal;
    }

    public void setKodeJadwal(String kodeJadwal) {
        this.kodeJadwal = kodeJadwal;
    }

    public String getWaktuMulai() {
        return waktuMulai;
    }

    public void setWaktuMulai(String waktuMulai) {
        this.waktuMulai = waktuMulai;
    }

    public String getWaktuSelesai() {
        return waktuSelesai;
    }

    public void setWaktuSelesai(String waktuSelesai) {
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
