/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.MataPelajaran;

/**
 *
 * @author nyaw
 */
public interface MataPelajaranDao {

    public boolean insert(MataPelajaran mataPelajaran) throws SQLException;

    public boolean update(MataPelajaran mataPelajaran) throws SQLException;

    public boolean delete(String kode) throws SQLException;

    public MataPelajaran getByKode(String kode) throws SQLException;

    public List<MataPelajaran> getAll() throws SQLException;

    public List<MataPelajaran> search(String keyword) throws SQLException;

}
