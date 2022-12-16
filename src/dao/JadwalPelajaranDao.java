/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.JadwalPelajaran;

/**
 *
 * @author nyaw
 */
public interface JadwalPelajaranDao {

    public boolean insert(JadwalPelajaran jadwalPelajaran) throws SQLException;

    public boolean update(JadwalPelajaran jadwalPelajaran) throws SQLException;

    public boolean delete(String kode) throws SQLException;

    public JadwalPelajaran getByKode(String kode) throws SQLException;

    public List<JadwalPelajaran> getAll() throws SQLException;

    public List<JadwalPelajaran> getByNipGuru(String nipGuru) throws SQLException;

    public List<JadwalPelajaran> search(String keyword) throws SQLException;

}
