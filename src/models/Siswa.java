/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nyaw
 */
public class Siswa extends Orang {

    private String nisn;
    private JadwalPelajaran[] jadwalPelajaran;

    public Siswa(String nisn, JadwalPelajaran[] jadwalPelajaran, String nama, String jenisKelamin, String alamat, String noTelp) {
        super(nama, jenisKelamin, alamat, noTelp);
        this.nisn = nisn;
        this.jadwalPelajaran = jadwalPelajaran;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public JadwalPelajaran[] getJadwalPelajaran() {
        return jadwalPelajaran;
    }

    public void setJadwalPelajaran(JadwalPelajaran[] jadwalPelajaran) {
        this.jadwalPelajaran = jadwalPelajaran;
    }

}
