/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.JadwalPelajaranDao;
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
import models.JadwalPelajaran;
import models.Kelas;
import models.MataPelajaran;
import utils.DBConnection;

/**
 *
 * @author nyaw
 */
public class JadwalPelajaranService implements JadwalPelajaranDao {

    private final Connection connection;
    private final String SQL_INSERT = "INSERT INTO jadwal_pelajaran (kode_jadwal, hari, nip_guru, kode_kelas,kode_mata_pelajaran,waktu_mulai,waktu_selesai) VALUES (?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE jadwal_pelajaran SET hari=?, nip_guru=?, kode_kelas=?,kode_mata_pelajaran=?, waktu_mulai=?,waktu_selesai=? WHERE kode_jadwal=?";
    private final String SQL_DELETE = "DELETE FROM jadwal_pelajaran WHERE kode_jadwal=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM jadwal_pelajaran";
    private final String SQL_SELECT_BY_KODE = "SELECT * FROM jadwal_pelajaran WHERE kode_jadwal=?";
    private final String SQL_SELECT_BY_NIP_GURU = "SELECT * FROM jadwal_pelajaran WHERE nip_guru=?";

    private final String SQL_SEARCH = "SELECT * FROM jadwal_pelajaran WHERE kode_jadwal LIKE ?";

    public JadwalPelajaranService() {
        this.connection = DBConnection.getInstance();
    }

    @Override
    public boolean insert(JadwalPelajaran jadwalPelajaran) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, jadwalPelajaran.getKodeJadwal());
            prepareStatement.setString(2, jadwalPelajaran.getHari());
            prepareStatement.setString(3, jadwalPelajaran.getGuru().getNip());
            prepareStatement.setString(4, jadwalPelajaran.getKelas().getKodeKelas());
            prepareStatement.setString(5, jadwalPelajaran.getMapel().getKodeMataPelajaran());
            prepareStatement.setInt(6, jadwalPelajaran.getWaktuMulai());
            prepareStatement.setInt(7, jadwalPelajaran.getWaktuSelesai());
            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean update(JadwalPelajaran jadwalPelajaran) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_UPDATE);
            prepareStatement.setString(1, jadwalPelajaran.getHari());
            prepareStatement.setString(2, jadwalPelajaran.getGuru().getNip());
            prepareStatement.setString(3, jadwalPelajaran.getKelas().getKodeKelas());
            prepareStatement.setString(4, jadwalPelajaran.getMapel().getKodeMataPelajaran());
            prepareStatement.setInt(5, jadwalPelajaran.getWaktuMulai());
            prepareStatement.setInt(6, jadwalPelajaran.getWaktuSelesai());
            prepareStatement.setString(7, jadwalPelajaran.getKodeJadwal());

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public JadwalPelajaran getByKode(String kode) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        JadwalPelajaran jadwalPelajaran = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_KODE);
            prepareStatement.setString(1, kode);
            result = prepareStatement.executeQuery();
            if (result.next()) {
                jadwalPelajaran = new JadwalPelajaran();
                Guru guru = new GuruService().getByNip(result.getString("nip_guru"));
                Kelas kelas = new KelasService().getByKode(result.getString("kode_kelas"));
                MataPelajaran mapel = new MataPelajaranService().getByKode(result.getString("kode_mata_pelajaran"));
                jadwalPelajaran.setKodeJadwal(result.getString("kode_jadwal"));
                jadwalPelajaran.setHari(result.getString("hari"));
                jadwalPelajaran.setGuru(guru);
                jadwalPelajaran.setKelas(kelas);
                jadwalPelajaran.setMapel(mapel);
                jadwalPelajaran.setWaktuMulai(result.getInt("waktu_mulai"));
                jadwalPelajaran.setWaktuSelesai(result.getInt("waktu_selesai"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return jadwalPelajaran;
    }

    @Override
    public List<JadwalPelajaran> getAll() {
        List<JadwalPelajaran> listJadwalPelajaran = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {
            statement = connection.createStatement();
            result = statement.executeQuery(SQL_SELECT_ALL);
            GuruService gs = new GuruService();
            KelasService ks = new KelasService();
            MataPelajaranService mps = new MataPelajaranService();

            while (result.next()) {
                JadwalPelajaran jadwalPelajaran = new JadwalPelajaran();
                Guru guru = gs.getByNip(result.getString("nip_guru"));
                Kelas kelas = ks.getByKode(result.getString("kode_kelas"));
                MataPelajaran mapel = mps.getByKode(result.getString("kode_mata_pelajaran"));

                jadwalPelajaran.setKodeJadwal(result.getString("kode_jadwal"));
                jadwalPelajaran.setHari(result.getString("hari"));
                jadwalPelajaran.setGuru(guru);
                jadwalPelajaran.setKelas(kelas);
                jadwalPelajaran.setMapel(mapel);
                jadwalPelajaran.setWaktuMulai(result.getInt("waktu_mulai"));
                jadwalPelajaran.setWaktuSelesai(result.getInt("waktu_selesai"));
                listJadwalPelajaran.add(jadwalPelajaran);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listJadwalPelajaran;
    }

    @Override
    public List<JadwalPelajaran> search(String keyword) {
        List<JadwalPelajaran> listJadwalPelajaran = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SEARCH);
            prepareStatement.setString(1, "%" + keyword + "%");

            result = prepareStatement.executeQuery();
            while (result.next()) {
                JadwalPelajaran jadwalPelajaran = new JadwalPelajaran();
                Guru guru = new GuruService().getByNip(result.getString("nip_guru"));
                Kelas kelas = new KelasService().getByKode(result.getString("kode_kelas"));
                MataPelajaran mapel = new MataPelajaranService().getByKode(result.getString("kode_mata_pelajaran"));

                jadwalPelajaran.setKodeJadwal(result.getString("kode_jadwal"));
                jadwalPelajaran.setHari(result.getString("hari"));
                jadwalPelajaran.setGuru(guru);
                jadwalPelajaran.setKelas(kelas);
                jadwalPelajaran.setMapel(mapel);
                jadwalPelajaran.setWaktuMulai(result.getInt("waktu_mulai"));
                jadwalPelajaran.setWaktuSelesai(result.getInt("waktu_selesai"));
                listJadwalPelajaran.add(jadwalPelajaran);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listJadwalPelajaran;
    }

    @Override
    public List<JadwalPelajaran> getByNipGuru(String nipGuru) {
        List<JadwalPelajaran> listJadwalPelajaran = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_NIP_GURU);
            prepareStatement.setString(1, nipGuru);

            result = prepareStatement.executeQuery();
            while (result.next()) {
                JadwalPelajaran jadwalPelajaran = new JadwalPelajaran();
                Guru guru = new GuruService().getByNip(result.getString("nip_guru"));
                Kelas kelas = new KelasService().getByKode(result.getString("kode_kelas"));
                MataPelajaran mapel = new MataPelajaranService().getByKode(result.getString("kode_mata_pelajaran"));

                jadwalPelajaran.setKodeJadwal(result.getString("kode_jadwal"));
                jadwalPelajaran.setHari(result.getString("hari"));
                jadwalPelajaran.setGuru(guru);
                jadwalPelajaran.setKelas(kelas);
                jadwalPelajaran.setMapel(mapel);
                jadwalPelajaran.setWaktuMulai(result.getInt("waktu_mulai"));
                jadwalPelajaran.setWaktuSelesai(result.getInt("waktu_selesai"));
                listJadwalPelajaran.add(jadwalPelajaran);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(JadwalPelajaranService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listJadwalPelajaran;
    }
}
