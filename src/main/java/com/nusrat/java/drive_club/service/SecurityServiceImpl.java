package com.nusrat.java.drive_club.service;

import com.lambdaworks.crypto.SCryptUtil;
import com.nusrat.java.drive_club.service.interfaces.SecurityService;
import org.jvnet.hk2.annotations.Service;

import javax.annotation.ManagedBean;
import javax.annotation.Resource;

/**
 * Created by Nusrat on 2/25/2017.
 */
@Service
@Resource
@ManagedBean
public class SecurityServiceImpl implements SecurityService {

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
