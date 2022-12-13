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
    private String username;
    private String password;

    public Admin() {
    }

    public Admin(String idAdmin, String username, String password, String nama, String jenisKelamin, String alamat, String telepon) {
        super(nama, jenisKelamin, alamat, telepon);
        this.idAdmin = idAdmin;
        this.username = username;
        this.password = password;
    }

    public String getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(String idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
