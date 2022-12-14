/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.SiswaDao;
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
import models.Siswa;
import utils.DBConnection;

/**
 *
 * @author nyaw
 */
public class SiswaService implements SiswaDao {

    private final Connection connection;
    private final String SQL_INSERT = "INSERT INTO siswa (nis, nama, alamat, jenis_kelamin,telepon) VALUES (?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE siswa SET nama=?, alamat=?, jenis_kelamin=?, telepon=? WHERE nis=?";
    private final String SQL_DELETE = "DELETE FROM siswa WHERE nis=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM siswa";
    private final String SQL_SELECT_BY_NIS = "SELECT * FROM siswa WHERE nis=?";
    private final String SQL_SEARCH = "SELECT * FROM siswa WHERE nis LIKE ? OR nama LIKE ?";
    private final String SQL_GET_SISWA_KELAS = "SELECT kelas.kode_kelas,kelas.nama,kelas.tingkat FROM kelas INNER JOIN siswa_kelas ON siswa_kelas.kode_kelas = kelas.kode_kelas WHERE siswa_kelas.nis_siswa=?";

    public SiswaService() {
        this.connection = DBConnection.getInstance();
    }

    @Override
    public boolean insert(Siswa siswa) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, siswa.getNis());
            prepareStatement.setString(2, siswa.getNama());
            prepareStatement.setString(3, siswa.getAlamat());
            prepareStatement.setString(4, siswa.getJenisKelamin());
            prepareStatement.setString(5, siswa.getTelepon());
            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean update(Siswa siswa) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_UPDATE);
            prepareStatement.setString(1, siswa.getNama());
            prepareStatement.setString(2, siswa.getAlamat());
            prepareStatement.setString(3, siswa.getJenisKelamin());
            prepareStatement.setString(4, siswa.getTelepon());
            prepareStatement.setString(5, siswa.getNis());

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean delete(String nis) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_DELETE);
            prepareStatement.setString(1, nis);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public Siswa getByNis(String nis) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        Siswa siswa = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_NIS);
            prepareStatement.setString(1, nis);
            result = prepareStatement.executeQuery();
            if (result.next()) {
                siswa = new Siswa();
                siswa.setNis(result.getString("nis"));
                siswa.setNama(result.getString("nama"));
                siswa.setJenisKelamin(result.getString("jenis_kelamin"));
                siswa.setAlamat(result.getString("alamat"));
                siswa.setTelepon(result.getString("telepon"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return siswa;
    }

    @Override
    public List<Siswa> getAll() {
        List<Siswa> listSiswa = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(SQL_SELECT_ALL);
            while (result.next()) {
                Siswa siswa = new Siswa();
                siswa.setNis(result.getString("nis"));
                siswa.setNama(result.getString("nama"));
                siswa.setJenisKelamin(result.getString("jenis_kelamin"));
                siswa.setAlamat(result.getString("alamat"));
                siswa.setTelepon(result.getString("telepon"));
                listSiswa.add(siswa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listSiswa;
    }

    @Override
    public List<Siswa> search(String keyword) {
        List<Siswa> listSiswa = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SEARCH);
            prepareStatement.setString(1, "%" + keyword + "%");
            prepareStatement.setString(2, "%" + keyword + "%");

            result = prepareStatement.executeQuery();
            while (result.next()) {
                Siswa siswa = new Siswa();
                siswa.setNis(result.getString("nis"));
                siswa.setNama(result.getString("nama"));
                siswa.setJenisKelamin(result.getString("jenis_kelamin"));
                siswa.setAlamat(result.getString("alamat"));
                siswa.setTelepon(result.getString("telepon"));
                listSiswa.add(siswa);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(SiswaService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listSiswa;
    }

    @Override
    public Kelas getKelas(String nis) {

        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        Kelas kelas = null;

        try {
            prepareStatement = connection.prepareStatement(SQL_GET_SISWA_KELAS);
            prepareStatement.setString(1, nis);
            result = prepareStatement.executeQuery();
            if (result.next()) {
                kelas = new Kelas();
                kelas.setKodeKelas(result.getString("kode_kelas"));
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

}
