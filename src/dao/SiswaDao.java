/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.Kelas;
import models.Siswa;

/**
 *
 * @author nyaw
 */
public interface SiswaDao {

    public boolean insert(Siswa siswa) throws SQLException;

    public boolean update(Siswa siswa) throws SQLException;

    public boolean delete(String nis) throws SQLException;

    public Siswa getByNis(String nis) throws SQLException;

    public List<Siswa> getAll() throws SQLException;

    public Kelas getKelas(String nis) throws SQLException;

    public List<Siswa> search(String keyword) throws SQLException;

}
