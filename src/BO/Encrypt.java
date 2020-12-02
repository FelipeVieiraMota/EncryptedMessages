/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BO;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author felipe
 */
public class Encrypt {
    
    public String encryptMessage(String message, String algorithm) throws Throwable {
        return encryptMessageByAlgorithm(message, algorithm);
    }
    
    private String encryptMessageByAlgorithm(String message, String algorithm) throws NoSuchAlgorithmException{
        // Static getInstance method is called with hashing MD5 
        MessageDigest md = MessageDigest.getInstance(algorithm.toUpperCase()); 

        // digest() method is called to calculate message digest 
        //  of an input digest() return array of byte 
        byte[] messageDigest = md.digest(message.getBytes()); 

        // Convert byte array into signum representation 
        BigInteger no = new BigInteger(1, messageDigest); 

        // Convert message digest into hex value 
        String hashtext = no.toString(16); 
        while (hashtext.length() < 32) { 
            hashtext = "0" + hashtext; 
        } 
        return hashtext; 
    }
}
