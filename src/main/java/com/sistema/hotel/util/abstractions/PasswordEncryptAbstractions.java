package com.sistema.hotel.util.abstractions;

public interface PasswordEncryptAbstractions {
    String encryptPassword(String password);
    boolean checkPassword(String rawPassword, String storedHash);
}
