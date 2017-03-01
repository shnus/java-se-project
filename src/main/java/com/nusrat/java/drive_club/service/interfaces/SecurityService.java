package com.nusrat.java.drive_club.service.interfaces;

import org.jvnet.hk2.annotations.Contract;

/**
 * Created by Nusrat on 2/25/2017.
 */
@Contract
public interface SecurityService {
    String encrypt(String password);
    boolean validate(String password, String hash);
}
