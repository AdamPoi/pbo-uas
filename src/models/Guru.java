/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nyaw
 */
public class Guru extends Orang {

    private String nip;

    public Guru() {
    }

    public Guru(String nip, String nama, String jenisKelamin, String alamat, String telepon) {
        super(nama, jenisKelamin, alamat, telepon);
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

}
