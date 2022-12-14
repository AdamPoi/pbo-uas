/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.Kelas;

/**
 *
 * @author nyaw
 */
public interface KelasDao {

    public boolean insert(Kelas kelas) throws SQLException;

    public boolean update(Kelas kelas) throws SQLException;

    public boolean delete(String kodeKelas) throws SQLException;

    public Kelas getByKode(String kodeKelas) throws SQLException;

    public List<Kelas> getByTingkat(int tingkat) throws SQLException;

    public List<Kelas> getAll() throws SQLException;

    public List<Kelas> search(String keyword) throws SQLException;

}
