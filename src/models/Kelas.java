/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nyaw
 */
public class Kelas {

    private String kodeKelas;
    private String namaKelas;
    private int tingkat;
    private Siswa[] siswa;

    public Kelas(String kodeKelas, String namaKelas, int tingkat, Siswa[] siswa) {
        this.kodeKelas = kodeKelas;
        this.namaKelas = namaKelas;
        this.tingkat = tingkat;
        this.siswa = siswa;
    }

    public String getKodeKelas() {
        return kodeKelas;
    }

    public void setKodeKelas(String kodeKelas) {
        this.kodeKelas = kodeKelas;
    }

    public String getNamaKelas() {
        return namaKelas;
    }

    public void setNamaKelas(String namaKelas) {
        this.namaKelas = namaKelas;
    }

    public int getTingkat() {
        return tingkat;
    }

    public void setTingkat(int tingkat) {
        this.tingkat = tingkat;
    }

    public Siswa[] getSiswa() {
        return siswa;
    }

    public void setSiswa(Siswa[] siswa) {
        this.siswa = siswa;
    }

}
