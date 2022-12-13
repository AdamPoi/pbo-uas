/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Pengguna;

/**
 *
 * @author nyaw
 */
public class AuthHelper {

    private static Pengguna currentUser;

    public static Pengguna getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUSer(Pengguna currentUser) {
        AuthHelper.currentUser = currentUser;
    }

    public static String getMd5(String text) {

        MessageDigest md;
        StringBuilder sb = new StringBuilder(32);
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(text.getBytes());
            byte[] digest = md.digest();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AuthHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }

//    public static
}
