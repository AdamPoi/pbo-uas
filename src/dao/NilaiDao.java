/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.Nilai;

/**
 *
 * @author nyaw
 */
public interface NilaiDao {

    public boolean insert(Nilai nilai) throws SQLException;

    public boolean update(Nilai nilai) throws SQLException;

    public boolean delete(int id) throws SQLException;

    public Nilai getById(int id) throws SQLException;

    public List<Nilai> getAll() throws SQLException;

    public List<Nilai> search(String keyword) throws SQLException;

}
