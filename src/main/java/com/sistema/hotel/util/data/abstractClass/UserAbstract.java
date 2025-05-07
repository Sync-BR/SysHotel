package com.sistema.hotel.util.data.abstractClass;

import com.sistema.hotel.util.data.abstractInterface.ClientAbstractInterface;
import com.sistema.hotel.util.data.abstractInterface.UserAbstractInterface;
import org.springframework.security.crypto.password.PasswordEncoder;



public class UserAbstract implements UserAbstractInterface, ClientAbstractInterface {

    private final PasswordEncoder passwordEncoder;

    public UserAbstract(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean checkPassword(String rawPassword) {
        return passwordEncoder.matches(rawPassword, encryptPassword(rawPassword));
    }


    @Override
    public String formatPhoneNumber(String phoneNumber) {
        phoneNumber = phoneNumber.replaceAll("\\D", "");
        if (phoneNumber.matches("\\d{11}"))
            return phoneNumber.replaceFirst("(\\d{2})(\\d{5})(\\d{4})", "($1) $2-$3");
        else if (phoneNumber.matches("\\d{10}"))
            return phoneNumber.replaceFirst("(\\d{2})(\\d{4})(\\d{4})", "($1) $2-$3");
        return phoneNumber;
    }

    @Override
    public String formatCpf(String cpf) {
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() == 11) {
            return cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        }
        return cpf;
    }
}
