package com.rafael_sigwalt.personal_website.services;

import com.rafael_sigwalt.personal_website.exceptions.NotAbleToDecryptDataException;
import com.rafael_sigwalt.personal_website.exceptions.NotAbleToEncryptDataException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

@Service
public class EncryptionService {

    @Value("${encryptionKey}")
    private String key;

    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";

    public String encryptData(String text) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            IvParameterSpec initializationVectorParams = getInitializationVector();

            cipher.init(Cipher.ENCRYPT_MODE, getSecret(), initializationVectorParams);

            byte[] encryptedBytes = cipher.doFinal(text.getBytes());

            byte[] combined = combineIvAndValue(encryptedBytes, initializationVectorParams.getIV());

            return Base64.getEncoder().encodeToString(combined);
        } catch(IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | NoSuchAlgorithmException ex) {
            throw new NotAbleToEncryptDataException(ex);
        }
    }

    public String decryptData(String encryptedText){
        try {
            byte[] encryptedByte = Base64.getDecoder().decode(encryptedText);

            byte[] iv = new byte[16];
            byte[] value = new byte[encryptedByte.length - iv.length];

            System.arraycopy(encryptedByte,0, iv, 0, iv.length);
            System.arraycopy(encryptedByte, iv.length, value, 0, value.length );

            IvParameterSpec ivSpec = new IvParameterSpec(iv);

            Cipher cipher = Cipher.getInstance(ALGORITHM);

            cipher.init(Cipher.DECRYPT_MODE, getSecret(), ivSpec);
            byte[] decryptedBytes = cipher.doFinal(value);

            return new String(decryptedBytes);
        } catch(IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | NoSuchAlgorithmException ex) {
            throw new NotAbleToEncryptDataException(ex);
        }
    }

    private SecretKeySpec getSecret() {
        byte[] decodedKey = Base64.getDecoder().decode(key);

        return new SecretKeySpec(decodedKey, 0 , decodedKey.length, KEY_ALGORITHM);
    }

    private IvParameterSpec getInitializationVector() {
        byte[] iv = new byte[16];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    private byte[] combineIvAndValue(byte[] encryptedBytes, byte[] iv) {
        byte[] combined = new byte[iv.length + encryptedBytes.length];
        System.arraycopy(iv, 0 ,combined, 0, iv.length);
        System.arraycopy(encryptedBytes, 0, combined, iv.length, encryptedBytes.length);
        return combined;
    }

}
