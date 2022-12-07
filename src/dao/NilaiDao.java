/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package dao;

import java.util.List;
import models.Nilai;

/**
 *
 * @author nyaw
 */
public interface NilaiDao {

    public boolean insert(Nilai nilai);

    public boolean update(Nilai nilai);

    public boolean delete(int id);

    public Nilai getNilaiById(int id);

    public List<Nilai> getAllNilai();
}
