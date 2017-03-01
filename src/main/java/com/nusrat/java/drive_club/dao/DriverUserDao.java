package com.nusrat.java.drive_club.dao;

import com.nusrat.java.drive_club.model.User;
import com.nusrat.java.drive_club.service.DriverSecurityService;
import org.jvnet.hk2.annotations.Service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.util.Date;
import java.util.Optional;

/**
 * Created by Nusrat on 2/25/2017.
 */
@ManagedBean
@Service
public class DriverUserDao implements UserDao {

    final DriverSecurityService securityService;

    @Inject
    public DriverUserDao(DriverSecurityService securityService) {
        this.securityService = securityService;
    }

    public Optional<User> getByLoginName(String loginName) {
        return dummy(loginName);
    }

    public Optional<User> dummy(String loginName) {
        if(!"test@test.test".equals(loginName)){
            return Optional.empty();
        }

        return Optional.of(
                User.builder()
                    .firstName("Nusrat")
                    .lastName("Shakarov")
                    .birthDate(new Date())
                    .loginName("test@test.test")
                    .passwordHash(securityService.encrypt("test"))
                .build()
        );

    }
}
