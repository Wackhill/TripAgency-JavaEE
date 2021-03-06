package com.shpakovskiy.trippy.utils.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

    public String getHash(String password) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_16));

            //FIXME: Ah, no, my eyes are bleeding
            for (int i = 0; i < hash.length; i++) {
                if (!((new Character((char) hash[i])).toString().matches("[a-zA-Z0-9]+"))) {
                    hash[i] = 48;
                }
            }

            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
