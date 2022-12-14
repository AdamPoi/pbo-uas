package dao;


import java.sql.SQLException;
import models.Kelas;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author nyaw
 */
public interface SiswaKelasDao {

    public Kelas getAllSiswaKelas(String kodeKelas) throws SQLException;

    public boolean insertSiswaKelas(String nis, String kodeKelas) throws SQLException;

    public boolean updateSiswaKelas(String nis, String kodeKelas) throws SQLException;

    public boolean deleteSiswaKelas(String nis, String kodeKelas) throws SQLException;

}
