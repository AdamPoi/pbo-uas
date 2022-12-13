/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.Guru;

/**
 *
 * @author nyaw
 */
public interface GuruDao {

    public boolean insert(Guru guru) throws SQLException;

    public boolean update(Guru guru) throws SQLException;

    public boolean delete(String nip) throws SQLException;

    public Guru getByNip(String nip) throws SQLException;

    public List<Guru> getAll() throws SQLException;

    public List<Guru> search(String keyword) throws SQLException;

    public Guru login(String nip, String password) throws SQLException;
}
