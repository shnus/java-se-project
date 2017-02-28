package com.nusrat.java.drive_club.service;

import com.lambdaworks.crypto.SCryptUtil;
import com.nusrat.java.drive_club.service.interfaces.SecurityService;

/**
 * Created by Nusrat on 2/25/2017.
 */
public class DriverSecurityService implements SecurityService {

    @Override
    public String encrypt(String password) {
        String hash = SCryptUtil.scrypt(password,16,16,16);
        return hash;
    }

    @Override
    public boolean validate(String password, String hash) {
        return SCryptUtil.check(password,hash);
    }
}
