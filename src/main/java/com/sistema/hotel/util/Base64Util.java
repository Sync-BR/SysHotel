package com.sistema.hotel.util;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Base64Util {

    public String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
    public byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

}
