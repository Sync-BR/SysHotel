package com.sistema.hotel.controller.service.interfaces;

public interface PasswordEncrypt {
    String encryptPassword(String password);
    boolean checkPassword(String rawPassword, String storedHash);
}
