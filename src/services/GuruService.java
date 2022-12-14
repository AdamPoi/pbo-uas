/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.GuruDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Guru;
import utils.DBConnection;

/**
 *
 * @author nyaw
 */
public class GuruService implements GuruDao {

    private final Connection connection;
    private final String SQL_INSERT = "INSERT INTO guru (nip, nama, alamat, jenis_kelamin,telepon,password) VALUES (?,?,?,?,?,?)";
    private final String SQL_UPDATE_NO_PASSWORD = "UPDATE guru SET nama=?, alamat=?, jenis_kelamin=?, telepon=? WHERE nip=?";
    private final String SQL_UPDATE = "UPDATE guru SET nama=?, alamat=?, jenis_kelamin=?, telepon=?, password=? WHERE nip=?";
    private final String SQL_DELETE = "DELETE FROM guru WHERE nip=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM guru";
    private final String SQL_SELECT_BY_NIS = "SELECT * FROM guru WHERE nip=?";
    private final String SQL_SEARCH = "SELECT * FROM guru WHERE nip LIKE ? OR nama LIKE ?";
    private final String SQL_LOGIN = "SELECT * FROM guru WHERE nip=? AND password=?";

    public GuruService() {
        this.connection = DBConnection.getInstance();
    }

    @Override
    public boolean insert(Guru guru) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, guru.getNip());
            prepareStatement.setString(2, guru.getNama());
            prepareStatement.setString(3, guru.getAlamat());
            prepareStatement.setString(4, guru.getJenisKelamin());
            prepareStatement.setString(5, guru.getTelepon());
            prepareStatement.setString(6, guru.getPassword());

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean update(Guru guru) {
        PreparedStatement prepareStatement = null;
        try {
            if (guru.getPassword() == null) {
                prepareStatement = connection.prepareStatement(SQL_UPDATE_NO_PASSWORD);
                prepareStatement.setString(1, guru.getNama());
                prepareStatement.setString(2, guru.getAlamat());
                prepareStatement.setString(3, guru.getJenisKelamin());
                prepareStatement.setString(4, guru.getTelepon());
                prepareStatement.setString(5, guru.getNip());
            } else {
                prepareStatement = connection.prepareStatement(SQL_UPDATE);
                prepareStatement.setString(1, guru.getNama());
                prepareStatement.setString(2, guru.getAlamat());
                prepareStatement.setString(3, guru.getJenisKelamin());
                prepareStatement.setString(4, guru.getTelepon());
                prepareStatement.setString(5, guru.getPassword());
                prepareStatement.setString(6, guru.getNip());

            }

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean delete(String nip) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_DELETE);
            prepareStatement.setString(1, nip);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public Guru getByNip(String nip) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        Guru guru = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_NIS);
            prepareStatement.setString(1, nip);
            result = prepareStatement.executeQuery();
            if (result.next()) {
                guru = new Guru();
                guru.setNip(result.getString("nip"));
                guru.setNama(result.getString("nama"));
                guru.setJenisKelamin(result.getString("jenis_kelamin"));
                guru.setAlamat(result.getString("alamat"));
                guru.setTelepon(result.getString("telepon"));
                guru.setPassword(result.getString("password"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return guru;
    }

    @Override
    public List<Guru> getAll() {
        List<Guru> listGuru = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(SQL_SELECT_ALL);
            while (result.next()) {
                Guru guru = new Guru();
                guru.setNip(result.getString("nip"));
                guru.setNama(result.getString("nama"));
                guru.setJenisKelamin(result.getString("jenis_kelamin"));
                guru.setAlamat(result.getString("alamat"));
                guru.setTelepon(result.getString("telepon"));

                listGuru.add(guru);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listGuru;
    }

    @Override
    public List<Guru> search(String keyword) {
        List<Guru> listGuru = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SEARCH);
            prepareStatement.setString(1, "%" + keyword + "%");
            prepareStatement.setString(2, "%" + keyword + "%");

            result = prepareStatement.executeQuery();
            while (result.next()) {
                Guru guru = new Guru();
                guru.setNip(result.getString("nip"));
                guru.setNama(result.getString("nama"));
                guru.setJenisKelamin(result.getString("jenis_kelamin"));
                guru.setAlamat(result.getString("alamat"));
                guru.setTelepon(result.getString("telepon"));
                listGuru.add(guru);
            }
        } catch (SQLException ex) {
            Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listGuru;
    }

    @Override
    public Guru login(String nip, String password) throws SQLException {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        Guru guru = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_LOGIN);
            prepareStatement.setString(1, nip);
            prepareStatement.setString(2, password);

            result = prepareStatement.executeQuery();
            if (result.next()) {
                guru = new Guru();
                guru.setNip(result.getString("nip"));
                guru.setNama(result.getString("nama"));
                guru.setJenisKelamin(result.getString("jenis_kelamin"));
                guru.setAlamat(result.getString("alamat"));
                guru.setTelepon(result.getString("telepon"));
                guru.setPassword(result.getString("password"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(GuruService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return guru;
    }
}
