/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.Siswa;

/**
 *
 * @author nyaw
 */
public interface SiswaDao {

    public boolean insert(Siswa siswa) throws SQLException;

    public boolean update(Siswa siswa) throws SQLException;

    public boolean delete(String nisn) throws SQLException;

    public Siswa getSiswaByNisn(String nisn) throws SQLException;

    public List<Siswa> getAllSiswa() throws SQLException;

}
