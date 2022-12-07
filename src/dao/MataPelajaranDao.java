/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.MataPelajaran;

/**
 *
 * @author nyaw
 */
public interface MataPelajaranDao {

    public boolean insert(MataPelajaran mataPelajaran);

    public boolean update(MataPelajaran mataPelajaran);

    public boolean delete(String kode);

    public MataPelajaran getMataPelajaranByKode(String kode);

    public List<MataPelajaran> getAllMataPelajaran();

}
