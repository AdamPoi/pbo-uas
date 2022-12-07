/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nyaw
 */
public class Nilai {

    private String jenisNilai;
    private double nilai;
    private Siswa siswa;
    private MataPelajaran mataPelajaran;

    public Nilai(String jenisNilai, double nilai, Siswa siswa, MataPelajaran mataPelajaran) {
        this.jenisNilai = jenisNilai;
        this.nilai = nilai;
        this.siswa = siswa;
        this.mataPelajaran = mataPelajaran;
    }

    public String getJenisNilai() {
        return jenisNilai;
    }

    public void setJenisNilai(String jenisNilai) {
        this.jenisNilai = jenisNilai;
    }

    public double getNilai() {
        return nilai;
    }

    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    public Siswa getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

    public MataPelajaran getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(MataPelajaran mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

}
