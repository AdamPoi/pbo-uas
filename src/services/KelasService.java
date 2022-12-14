/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.KelasDao;
import dao.SiswaKelasDao;
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
public class KelasService implements KelasDao, SiswaKelasDao {

    private final Connection connection;
    private final String SQL_INSERT = "INSERT INTO kelas (kode_kelas, nama, tingkat) VALUES (?,?,?)";
    private final String SQL_UPDATE = "UPDATE kelas SET nama=?, tingkat=? WHERE kode_kelas=?";
    private final String SQL_DELETE = "DELETE FROM kelas WHERE kode_kelas=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM kelas";
    private final String SQL_SELECT_ALL_SISWA = "SELECT siswa.nis,siswa.nama nama_siswa FROM siswa INNER JOIN siswa_kelas ON siswa.nis = siswa_kelas.nis_siswa WHERE siswa_kelas.kode_kelas=?";
    private final String SQL_SELECT_BY_NIS = "SELECT * FROM kelas WHERE kode_kelas=?";
    private final String SQL_SELECT_BY_TINGKAT = "SELECT * FROM kelas WHERE tingkat=?";
    private final String SQL_SEARCH = "SELECT * FROM kelas WHERE kode_kelas LIKE ? OR nama LIKE ?";
    private final String SQL_INSERT_SISWA = "INSERT INTO siswa_kelas (nis_siswa,kode_kelas) VALUES (?,?)";
    private final String SQL_UPDATE_SISWA = "UPDATE siswa_kelas SET kode_kelas=? WHERE nis_siswa=?";
    private final String SQL_DELETE_SISWA = "DELETE FROM siswa_kelas WHERE nis_siswa=? AND kode_kelas=?";
    private final String SQL_GET_SISWA = "SELECT * FROM siswa_kelas WHERE nis_siswa=? AND kode_kelas=?";

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
            prepareStatement.setString(3, kelas.getKodeKelas());

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
                kelas.setKodeKelas(result.getString("kode_kelas"));
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
    public List<Kelas> search(String keyword) {
        List<Kelas> listKelas = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SEARCH);
            prepareStatement.setString(1, "%" + keyword + "%");
            prepareStatement.setString(2, "%" + keyword + "%");

            result = prepareStatement.executeQuery();
            while (result.next()) {
                Kelas kelas = new Kelas();
                kelas.setKodeKelas(result.getString("kode_kelas"));
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

    @Override
    public Kelas getAllSiswaKelas(String kodeKelas) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        List<Siswa> listSiswa = new ArrayList<>();
        Kelas kelas = getByKode(kodeKelas);
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_ALL_SISWA);
            prepareStatement.setString(1, kodeKelas);

            result = prepareStatement.executeQuery();
            while (result.next()) {
                Siswa siswa = new Siswa();
                siswa.setNis(result.getString("nis"));
                siswa.setNama(result.getString("nama_siswa"));
                listSiswa.add(siswa);
            }
            kelas.setListSiswa(listSiswa);

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
    public boolean insertSiswaKelas(String nis, String kodeKelas) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_INSERT_SISWA);
            prepareStatement.setString(1, nis);
            prepareStatement.setString(2, kodeKelas);
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
    public boolean updateSiswaKelas(String nis, String kodeKelas) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_UPDATE_SISWA);
            prepareStatement.setString(1, kodeKelas);
            prepareStatement.setString(2, nis);

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
    public boolean deleteSiswaKelas(String nis, String kodeKelas) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_DELETE_SISWA);
            prepareStatement.setString(1, nis);
            prepareStatement.setString(2, kodeKelas);

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
    public List<Kelas> getByTingkat(int tingkat) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        List<Kelas> listKelas = new ArrayList<>();
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_TINGKAT);
            prepareStatement.setInt(1, tingkat);
            result = prepareStatement.executeQuery();
            while (result.next()) {
                Kelas kelas = new Kelas();
                kelas.setKodeKelas(result.getString("kode_kelas"));
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
