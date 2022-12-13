/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import models.Admin;

/**
 *
 * @author nyaw
 */
public interface AdminDao {

    public boolean insert(Admin admin) throws SQLException;

    public boolean update(Admin admin) throws SQLException;

    public boolean delete(String idAdmin) throws SQLException;

    public Admin getById(String idAdmin) throws SQLException;

    public List<Admin> getAll() throws SQLException;

    public Admin login(String username, String password) throws SQLException;

    public List<Admin> search(String keyword) throws SQLException;

}
