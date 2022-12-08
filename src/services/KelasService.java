/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.KelasDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Kelas;
import utils.DBConnection;

/**
 *
 * @author nyaw
 */
public class KelasService implements KelasDao {

    private final Connection connection;
    private final String SQL_INSERT = "INSERT INTO kelas (kode_kelas, nama, tingkat) VALUES (?,?,?)";
    private final String SQL_UPDATE = "UPDATE kelas SET nama=?, tingkat=? WHERE kode_kelas=?";
    private final String SQL_DELETE = "DELETE FROM kelas WHERE kode_kelas=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM kelas";
    private final String SQL_SELECT_BY_NIS = "SELECT * FROM kelas WHERE kode_kelas=?";
    private final String SQL_SEARCH = "SELECT * FROM kelas WHERE kode_kelas LIKE ? OR nama LIKE ?";

    public KelasService() {
        this.connection = DBConnection.getInstance();
    }

    @Override
    public boolean insert(Kelas kelas) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, kelas.getKodeKelas());
            prepareStatement.setString(2, kelas.getNama());
            prepareStatement.setInt(3, kelas.getTingkat());
            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean update(Kelas kelas) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_UPDATE);
            prepareStatement.setString(1, kelas.getNama());
            prepareStatement.setInt(2, kelas.getTingkat());

            prepareStatement.setString(5, kelas.getKodeKelas());

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean delete(String kodeKelas) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_DELETE);
            prepareStatement.setString(1, kodeKelas);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public Kelas getByKode(String kodeKelas) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        Kelas kelas = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_NIS);
            prepareStatement.setString(1, kodeKelas);
            result = prepareStatement.executeQuery();
            if (result.next()) {
                kelas = new Kelas();
                kelas.setKodeKelas(result.getString("kodeKelas"));
                kelas.setNama(result.getString("nama"));
                kelas.setTingkat(result.getInt("tingkat"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return kelas;
    }

    @Override
    public List<Kelas> getAll() {
        List<Kelas> listKelas = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(SQL_SELECT_ALL);
            while (result.next()) {
                Kelas kelas = new Kelas();
                kelas.setKodeKelas(result.getString("kodeKelas"));
                kelas.setNama(result.getString("nama"));
                kelas.setTingkat(result.getInt("tingkat"));
                listKelas.add(kelas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listKelas;
    }

    @Override
    public List<Kelas> search(String keyword) throws SQLException {
        List<Kelas> listKelas = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SEARCH);
            prepareStatement.setString(1, keyword);
            prepareStatement.setString(1, keyword);

            result = prepareStatement.executeQuery();
            while (result.next()) {
                Kelas kelas = new Kelas();
                kelas.setKodeKelas(result.getString("kodeKelas"));
                kelas.setNama(result.getString("nama"));
                kelas.setTingkat(result.getInt("tingkat"));
                listKelas.add(kelas);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KelasService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listKelas;
    }
}
