package com.sistema.hotel.util.data.abstractInterface;

public interface UserAbstractInterface {
    String encryptPassword(String password);
    boolean checkPassword(String rawPassword, String storedHash);
}
