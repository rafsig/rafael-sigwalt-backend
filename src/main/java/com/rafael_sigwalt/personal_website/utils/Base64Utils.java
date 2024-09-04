package com.rafael_sigwalt.personal_website.utils;

import java.util.Base64;

public class Base64Utils {

    public byte[] decodeBase64(String b64String){
        return Base64.getDecoder().decode(b64String);
    }
}
