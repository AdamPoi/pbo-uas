/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Admin;

/**
 *
 * @author nyaw
 */
public interface AdminDao {

    public boolean insert(Admin admin);

    public boolean update(Admin admin);

    public boolean delete(String idAdmin);

    public Admin getAdminById(String idAdmin);

    public List<Admin> getAllAdmin();
}
