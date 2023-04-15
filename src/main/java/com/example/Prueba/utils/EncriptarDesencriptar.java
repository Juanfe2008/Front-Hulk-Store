package com.example.Prueba.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;

public class EncriptarDesencriptar {
    public static String Encriptar(String cadena){
        String secretKey = "Prueba"; //llave Encriptar
        String Encriptation="";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] keyPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] ByteKey = Arrays.copyOf(keyPassword, 24);

            SecretKey key = new SecretKeySpec(ByteKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);

            byte[] PlainText = cadena.getBytes("utf-8");
            byte[] buf =cifrado.doFinal(PlainText);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            Encriptation = new String(base64Bytes);
        }catch (Exception e){
        }
        return Encriptation;
    }
    public static String Desencriptar(String cadenaEncriptada){
        String secretKey = "Prueba"; //llave Encriptar
        String Encriptation="";
        try {
            byte[] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] KeyPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte[] ByteKey = Arrays.copyOf(KeyPassword, 24);
            SecretKey key = new SecretKeySpec(ByteKey, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] PlainText = decipher.doFinal(message);
            Encriptation = new String(PlainText, "utf-8");
        }catch (Exception e){
        }
        return Encriptation;
    }
}
