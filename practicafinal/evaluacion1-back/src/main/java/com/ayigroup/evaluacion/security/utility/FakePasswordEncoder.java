package com.ayigroup.evaluacion.security.utility;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public interface FakePasswordEncoder extends PasswordEncoder {

    String encode(CharSequence password);
    boolean matches(CharSequence rawPassword, String encodedPassword);
    boolean upgradeEncoding(String encodedPassword);

}
