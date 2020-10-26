package javalibrary.securedata;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SecureDataManager {
    private static SecureDataManager instance;

    public static SecureDataManager getInstance() {
        if(instance == null)
            instance = new SecureDataManager();
        return instance;
    }
    public SecretKey getSecretKey(){
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(128); // The AES key size in number of bits
            return generator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    public KeyPair getKeyPair(){
        SecureRandom sr = new SecureRandom();
        KeyPairGenerator kpg = null;
        try {
            kpg = KeyPairGenerator.getInstance("RSA");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        kpg.initialize(2048, sr);
        KeyPair kp = kpg.genKeyPair();
        return kp;
    }


    public byte[] EncrpytMessage(byte[] message, PublicKey publicKey){
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.PUBLIC_KEY, publicKey);
            return cipher.doFinal(message);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public byte[] EncrpytMessage(String message, SecretKey secretKey){
        try {
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return aesCipher.doFinal(message.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public String DecrpytMessage(byte[] data, SecretKey secretKey){
        try {
            Cipher aesCipher = Cipher.getInstance("AES");
            aesCipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] bytePlainText = aesCipher.doFinal(data);
            return new String(bytePlainText, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public byte[] DecrpytMessage(byte[] message, PrivateKey privateKey){
        try {
            Cipher c = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            c.init(Cipher.PRIVATE_KEY, privateKey);
            return c.doFinal(message);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public PublicKey createPublicKeyFromBytes(byte[] bytes){
        try {
            X509EncodedKeySpec spec = new X509EncodedKeySpec(bytes);
            KeyFactory factory= KeyFactory.getInstance("RSA");
            return factory.generatePublic(spec);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SecretKey createSecretKeyFromBytes(byte[] decryptedKey) {
        return new SecretKeySpec(decryptedKey, 0, decryptedKey.length, "AES");
    }
}
