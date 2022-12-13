/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.NilaiDao;
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
import models.Nilai;
import models.Siswa;
import utils.DBConnection;

/**
 *
 * @author nyaw
 */
public class NilaiService implements NilaiDao {

    private final Connection connection;
    private final String SQL_INSERT = "INSERT INTO nilai (nis_siswa,kode_mata_pelajaran, nilai_tugas, nilai_kuis, nilai_uts,nilai_uas) VALUES (?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE nilai SET  nis_siswa=?, kode_mata_pelajaran=?, nilai_tugas=?, nilai_kuis=?, nilai_uts=?, nilai_uas=? WHERE id_nilai=?";
    private final String SQL_DELETE = "DELETE FROM nilai WHERE id_nilai=?";
    private final String SQL_SELECT_ALL = "SELECT * FROM nilai";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM nilai WHERE id_nilai=?";
    private final String SQL_SELECT_BY_SISWA = "SELECT * FROM nilai WHERE nis_siswa=?";
    private final String SQL_SELECT_BY_MATA_PELAJARAN = "SELECT * FROM nilai WHERE kode_mata_pelajaran=?";
    private final String SQL_SELECT_BY_SISWA_MATA_PELAJARAN = "SELECT * FROM nilai WHERE nis_siswa=? AND kode_mata_pelajaran=?";
    private final String SQL_SEARCH = "SELECT * FROM nilai WHERE nis_siswa LIKE ? OR kode_mata_pelajaran LIKE ?";

    public NilaiService() {
        this.connection = DBConnection.getInstance();
    }

    @Override
    public boolean insert(Nilai nilai) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_INSERT);
            prepareStatement.setString(1, nilai.getSiswa().getNis());
            prepareStatement.setString(2, nilai.getMataPelajaran().getKodeMataPelajaran());
            prepareStatement.setDouble(3, nilai.getNilaiTugas());
            prepareStatement.setDouble(4, nilai.getNilaiKuis());
            prepareStatement.setDouble(5, nilai.getNilaiUTS());
            prepareStatement.setDouble(6, nilai.getNilaiUAS());

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean update(Nilai nilai) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_UPDATE);
            prepareStatement.setString(1, nilai.getSiswa().getNis());
            prepareStatement.setString(2, nilai.getMataPelajaran().getKodeMataPelajaran());
            prepareStatement.setDouble(3, nilai.getNilaiTugas());
            prepareStatement.setDouble(4, nilai.getNilaiKuis());
            prepareStatement.setDouble(5, nilai.getNilaiUTS());
            prepareStatement.setDouble(6, nilai.getNilaiUAS());
            prepareStatement.setInt(7, nilai.getIdNilai());

            return prepareStatement.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        PreparedStatement prepareStatement = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_DELETE);
            prepareStatement.setInt(1, id);
            return prepareStatement.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return false;
    }

    @Override
    public Nilai getById(int id) {
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        Nilai nilai = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SELECT_BY_ID);
            prepareStatement.setInt(1, id);
            result = prepareStatement.executeQuery();
            if (result.next()) {
                nilai = new Nilai();
                Siswa siswa = new SiswaService().getByNis(result.getString("nis_siswa"));
                MataPelajaran mapel = new MataPelajaranService().getByKode(result.getString("kode_mata_pelajaran"));

                nilai.setIdNilai(result.getInt("id_nilai"));
                nilai.setSiswa(siswa);
                nilai.setMataPelajaran(mapel);
                nilai.setNilaiTugas(result.getDouble("nilai_tugas"));
                nilai.setNilaiKuis(result.getDouble("nilai_kuis"));
                nilai.setNilaiUTS(result.getDouble("nilai_uts"));
                nilai.setNilaiUAS(result.getDouble("nilai_uas"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return nilai;
    }

    @Override
    public List<Nilai> getAll() {
        List<Nilai> listNilai = new ArrayList<>();
        Statement statement = null;
        ResultSet result = null;
        try {

            statement = connection.createStatement();
            result = statement.executeQuery(SQL_SELECT_ALL);
            SiswaService ss = new SiswaService();
            MataPelajaranService mps = new MataPelajaranService();
            while (result.next()) {
                Nilai nilai = new Nilai();
                Siswa siswa = ss.getByNis(result.getString("nis_siswa"));
                MataPelajaran mapel = mps.getByKode(result.getString("kode_mata_pelajaran"));

                nilai.setIdNilai(result.getInt("id_nilai"));
                nilai.setSiswa(siswa);
                nilai.setMataPelajaran(mapel);
                nilai.setNilaiTugas(result.getDouble("nilai_tugas"));
                nilai.setNilaiKuis(result.getDouble("nilai_kuis"));
                nilai.setNilaiUTS(result.getDouble("nilai_uts"));
                nilai.setNilaiUAS(result.getDouble("nilai_uas"));

                listNilai.add(nilai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (statement != null) {
                    statement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listNilai;
    }

    @Override
    public List<Nilai> search(String keyword) {
        List<Nilai> listNilai = new ArrayList<>();
        PreparedStatement prepareStatement = null;
        ResultSet result = null;
        try {
            prepareStatement = connection.prepareStatement(SQL_SEARCH);
            prepareStatement.setString(1, "%" + keyword + "%");
            prepareStatement.setString(2, "%" + keyword + "%");
            result = prepareStatement.executeQuery();
            SiswaService ss = new SiswaService();
            MataPelajaranService mps = new MataPelajaranService();
            while (result.next()) {
                Nilai nilai = new Nilai();
                Siswa siswa = ss.getByNis(result.getString("nis_siswa"));
                MataPelajaran mapel = mps.getByKode(result.getString("kode_mata_pelajaran"));

                nilai.setIdNilai(result.getInt("id_nilai"));
                nilai.setSiswa(siswa);
                nilai.setMataPelajaran(mapel);
                nilai.setNilaiTugas(result.getDouble("nilai_tugas"));
                nilai.setNilaiKuis(result.getDouble("nilai_kuis"));
                nilai.setNilaiUTS(result.getDouble("nilai_uts"));
                nilai.setNilaiUAS(result.getDouble("nilai_uas"));
                listNilai.add(nilai);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (prepareStatement != null) {
                    prepareStatement.close();
                }
                if (result != null) {
                    result.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(NilaiService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return listNilai;
    }

    @Override
    public Nilai getBySiswa(String nis) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Nilai getByMataPelajaran(String kode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Nilai getBySiswaMataPelajaran(String nis, String kode) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
