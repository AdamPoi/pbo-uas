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

    public boolean insert(Siswa s);

    public boolean update(Siswa s);

    public boolean delete(String nisn);

    public Siswa getSiswaByNisn(String nisn);

    public List<Siswa> getAllSiswa();

}
