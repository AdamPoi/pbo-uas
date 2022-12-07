/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.List;
import models.Guru;

/**
 *
 * @author nyaw
 */
public interface GuruDao {

    public boolean insert(Guru guru);

    public boolean update(Guru guru);

    public boolean delete(String nip);

    public Guru getGuruByNip(String nip);

    public List<Guru> getAllGuru();
}
