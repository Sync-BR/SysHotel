package com.sistema.hotel.util.abstractions;

public interface PasswordEncrypt {
    String encryptPassword(String password);
    boolean checkPassword(String rawPassword, String storedHash);
}
