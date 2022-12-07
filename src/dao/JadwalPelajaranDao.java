/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.JadwalPelajaran;

/**
 *
 * @author nyaw
 */
public interface JadwalPelajaranDao {

    public boolean insert(JadwalPelajaran jadwalPelajaran);

    public boolean update(JadwalPelajaran jadwalPelajaran);

    public boolean delete(String kode);

    public JadwalPelajaran getJadwalPelajaranByKode(String kode);

    public List<JadwalPelajaran> getAllJadwalPelajaran();

}
