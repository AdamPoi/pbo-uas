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

    private int idNilai;
    private double nilaiTugas;
    private double nilaiKuis;
    private double nilaiUTS;
    private double nilaiUAS;
    private Siswa siswa;
    private MataPelajaran mataPelajaran;

    public Nilai() {
    }

    public Nilai(int idNilai, double nilaiTugas, double nilaiKuis, double nilaiUTS, double nilaiUAS, Siswa siswa, MataPelajaran mataPelajaran) {
        this.idNilai = idNilai;
        this.nilaiTugas = nilaiTugas;
        this.nilaiKuis = nilaiKuis;
        this.nilaiUTS = nilaiUTS;
        this.nilaiUAS = nilaiUAS;
        this.siswa = siswa;
        this.mataPelajaran = mataPelajaran;
    }

    public int getIdNilai() {
        return idNilai;
    }

    public void setIdNilai(int idNilai) {
        this.idNilai = idNilai;
    }

    public double getNilaiTugas() {
        return nilaiTugas;
    }

    public void setNilaiTugas(double nilaiTugas) {
        this.nilaiTugas = nilaiTugas;
    }

    public double getNilaiKuis() {
        return nilaiKuis;
    }

    public void setNilaiKuis(double nilaiKuis) {
        this.nilaiKuis = nilaiKuis;
    }

    public double getNilaiUTS() {
        return nilaiUTS;
    }

    public void setNilaiUTS(double nilaiUTS) {
        this.nilaiUTS = nilaiUTS;
    }

    public double getNilaiUAS() {
        return nilaiUAS;
    }

    public void setNilaiUAS(double nilaiUAS) {
        this.nilaiUAS = nilaiUAS;
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
