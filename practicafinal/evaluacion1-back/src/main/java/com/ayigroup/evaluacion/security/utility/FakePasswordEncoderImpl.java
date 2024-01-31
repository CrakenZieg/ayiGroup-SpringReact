package com.ayigroup.evaluacion.security.utility;

import org.springframework.stereotype.Service;

@Service
public class FakePasswordEncoderImpl implements FakePasswordEncoder{

    @Override
    public String encode(CharSequence password) {
        return password.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }

    @Override
    public boolean upgradeEncoding(String encodedPassword) {
        return false;
    }

}
