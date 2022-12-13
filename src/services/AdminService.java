/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.AdminDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Admin;
import utils.AuthHelper;
import utils.DBConnection;

/**
 *
 * @author nyaw
 */
public class AdminService implements AdminDao {

    private final Connection connection;
    private final String SQL_INSERT = "INSERT INTO admin (id, nama, alamat, jenis_kelamin,telepon,username, password) VALUES (?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE admin SET nama=?, alamat=?, jenis_kelamin=?, telepon=?,username=?,password=? WHERE id=?";
    private final String SQL_DELETE = "DELETE FROM admin WHERE id=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM admin";
    private final String SQL_SELECT_BY_NIS = "SELECT * FROM admin WHERE id=?";
    private final String SQL_SEARCH = "SELECT * FROM admin WHERE id LIKE ? OR nama LIKE ? OR username LIKE ?";
    private final String SQL_LOGIN = "SELECT * FROM admin WHERE username=? AND password=?";

    public AdminService() {
        this.connection = DBConnection.getInstance();
    }

    @Override
    public boolean insert(Admin admin) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, admin.getIdAdmin());
            prepareStatement.setString(2, admin.getNama());
            prepareStatement.setString(3, admin.getAlamat());
            prepareStatement.setString(4, admin.getJenisKelamin());
            prepareStatement.setString(5, admin.getTelepon());
            prepareStatement.setString(6, admin.getUsername());
            prepareStatement.setString(7, AuthHelper.getMd5(admin.getPassword()));

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean update(Admin admin) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_UPDATE);
            prepareStatement.setString(1, admin.getNama());
            prepareStatement.setString(2, admin.getAlamat());
            prepareStatement.setString(3, admin.getJenisKelamin());
            prepareStatement.setString(4, admin.getTelepon());
            prepareStatement.setString(5, admin.getUsername());
            prepareStatement.setString(6, admin.getIdAdmin());
            prepareStatement.setString(7, AuthHelper.getMd5(admin.getPassword()));

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean delete(String idAdmin) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_DELETE);
            prepareStatement.setString(1, idAdmin);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public Admin getById(String idAdmin) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        Admin admin = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_NIS);
            prepareStatement.setString(1, idAdmin);
            result = prepareStatement.executeQuery();
            if (result.next()) {
                admin = new Admin();
                admin.setIdAdmin(result.getString("id"));
                admin.setNama(result.getString("nama"));
                admin.setJenisKelamin(result.getString("jenis_kelamin"));
                admin.setAlamat(result.getString("alamat"));
                admin.setTelepon(result.getString("telepon"));
                admin.setUsername(result.getString("username"));
                admin.setPassword(result.getString("password"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return admin;
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> listAdmin = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(SQL_SELECT_ALL);
            while (result.next()) {
                Admin admin = new Admin();
                admin.setIdAdmin(result.getString("id"));
                admin.setNama(result.getString("nama"));
                admin.setJenisKelamin(result.getString("jenis_kelamin"));
                admin.setAlamat(result.getString("alamat"));
                admin.setTelepon(result.getString("telepon"));
                admin.setUsername(result.getString("username"));
                admin.setPassword(result.getString("password"));

                listAdmin.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listAdmin;
    }

    @Override
    public List<Admin> search(String keyword) {
        List<Admin> listAdmin = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SEARCH);
            prepareStatement.setString(1, "%" + keyword + "%");
            prepareStatement.setString(2, "%" + keyword + "%");
            prepareStatement.setString(3, "%" + keyword + "%");

            result = prepareStatement.executeQuery();
            while (result.next()) {
                Admin admin = new Admin();
                admin.setIdAdmin(result.getString("id"));
                admin.setNama(result.getString("nama"));
                admin.setJenisKelamin(result.getString("jenis_kelamin"));
                admin.setAlamat(result.getString("alamat"));
                admin.setTelepon(result.getString("telepon"));
                admin.setUsername(result.getString("username"));
                admin.setPassword(result.getString("password"));

                listAdmin.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listAdmin;
    }

    @Override
    public Admin login(String username, String password) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        Admin admin = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_LOGIN);
            prepareStatement.setString(1, username);
            prepareStatement.setString(2, password);

            result = prepareStatement.executeQuery();
            if (result.next()) {
                admin = new Admin();
                admin.setIdAdmin(result.getString("id"));
                admin.setNama(result.getString("nama"));
                admin.setJenisKelamin(result.getString("jenis_kelamin"));
                admin.setAlamat(result.getString("alamat"));
                admin.setTelepon(result.getString("telepon"));
                admin.setUsername(result.getString("username"));
                admin.setPassword(result.getString("password"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return admin;
    }
}
