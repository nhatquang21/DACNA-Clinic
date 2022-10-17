/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PHT
 */
public class Hasher {
    public static String hash(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedPassword = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString();//Length = 64 chars
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hasher.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
