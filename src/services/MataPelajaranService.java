/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.MataPelajaranDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.MataPelajaran;
import utils.DBConnection;

/**
 *
 * @author nyaw
 */
public class MataPelajaranService implements MataPelajaranDao {

    private final Connection connection;
    private final String SQL_INSERT = "INSERT INTO mata_pelajaran (kode_mata_pelajaran, nama) VALUES (?,?)";
    private final String SQL_UPDATE = "UPDATE mata_pelajaran SET nama=? WHERE kode_mata_pelajaran=?";
    private final String SQL_DELETE = "DELETE FROM mata_pelajaran WHERE kode_mata_pelajaran=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM mata_pelajaran";
    private final String SQL_SELECT_BY_NIS = "SELECT * FROM mata_pelajaran WHERE kode_mata_pelajaran=?";
    private final String SQL_SEARCH = "SELECT * FROM mata_pelajaran WHERE kode_mata_pelajaran LIKE ? OR nama LIKE ?";

    public MataPelajaranService() {
        this.connection = DBConnection.getInstance();
    }

    @Override
    public boolean insert(MataPelajaran mataPelajaran) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, mataPelajaran.getKodeMataPelajaran());
            prepareStatement.setString(2, mataPelajaran.getNama());
            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean update(MataPelajaran mataPelajaran) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_UPDATE);
            prepareStatement.setString(1, mataPelajaran.getNama());
            prepareStatement.setString(2, mataPelajaran.getKodeMataPelajaran());
            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public boolean delete(String kode) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_DELETE);
            prepareStatement.setString(1, kode);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    @Override
    public MataPelajaran getByKode(String kode) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        MataPelajaran mataPelajaran = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_NIS);
            prepareStatement.setString(1, kode);
            result = prepareStatement.executeQuery();
            if (result.next()) {
                mataPelajaran = new MataPelajaran();
                mataPelajaran.setKodeMataPelajaran(result.getString("kode_mata_pelajaran"));
                mataPelajaran.setNama(result.getString("nama"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return mataPelajaran;
    }

    @Override
    public List<MataPelajaran> getAll() {
        List<MataPelajaran> listMataPelajaran = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(SQL_SELECT_ALL);
            while (result.next()) {
                MataPelajaran mataPelajaran = new MataPelajaran();
                mataPelajaran.setKodeMataPelajaran(result.getString("kode_mata_pelajaran"));
                mataPelajaran.setNama(result.getString("nama"));
                listMataPelajaran.add(mataPelajaran);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listMataPelajaran;
    }

    @Override
    public List<MataPelajaran> search(String keyword) {
        List<MataPelajaran> listMataPelajaran = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SEARCH);
            prepareStatement.setString(1, "%" + keyword + "%");
            prepareStatement.setString(2, "%" + keyword + "%");

            result = prepareStatement.executeQuery();
            while (result.next()) {
                MataPelajaran mataPelajaran = new MataPelajaran();
                mataPelajaran.setKodeMataPelajaran(result.getString("kode_mata_pelajaran"));
                mataPelajaran.setNama(result.getString("nama"));
                listMataPelajaran.add(mataPelajaran);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MataPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listMataPelajaran;
    }
}
