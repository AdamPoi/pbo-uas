/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Kelas;

/**
 *
 * @author nyaw
 */
public interface KelasDao {

    public boolean insert(Kelas kelas);

    public boolean update(Kelas kelas);

    public boolean delete(String kodeKelas);

    public Kelas getKelasByKodeKelas(String kodeKelas);

    public List<Kelas> getAllKelas();
}
