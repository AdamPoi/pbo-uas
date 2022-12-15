/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nyaw
 */
public class Siswa extends Pengguna {

    private String nis;
    private JadwalPelajaran[] listJadwalPelajaran;

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public JadwalPelajaran[] getJadwalPelajaran() {
        return listJadwalPelajaran;
    }

    public void setJadwalPelajaran(JadwalPelajaran[] jadwalPelajaran) {
        this.listJadwalPelajaran = jadwalPelajaran;
    }

}
