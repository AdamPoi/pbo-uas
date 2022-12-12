/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author nyaw
 */
public class Admin extends Pengguna {

    private String idAdmin;

    public Admin() {
    }

    public Admin(String idAdmin, String nama, String jenisKelamin, String alamat, String telepon) {
        super(nama, jenisKelamin, alamat, telepon);
        this.idAdmin = idAdmin;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

}
