/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nyaw
 */
public class MataPelajaran {

    private String kodeMataPelajaran;
    private String nama;

    public MataPelajaran() {
    }

    public MataPelajaran(String kodeMataPelajaran, String nama) {
        this.kodeMataPelajaran = kodeMataPelajaran;
        this.nama = nama;
    }

    public String getKodeMataPelajaran() {
        return kodeMataPelajaran;
    }

    public void setKodeMataPelajaran(String kodeMataPelajaran) {
        this.kodeMataPelajaran = kodeMataPelajaran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

}
