/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import models.Siswa;

/**
 *
 * @author nyaw
 */
public interface SiswaDao {

    public boolean insert(Siswa siswa);

    public boolean update(Siswa siswa);

    public boolean delete(String nisn);

    public Siswa getSiswaByNisn(String nisn);

    public List<Siswa> getAllSiswa();

}
