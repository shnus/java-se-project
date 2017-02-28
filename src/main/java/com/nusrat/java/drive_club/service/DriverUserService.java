package com.nusrat.java.drive_club.service;

import com.nusrat.java.drive_club.dao.UserDao;
import com.nusrat.java.drive_club.model.Credentials;
import com.nusrat.java.drive_club.model.User;
import com.nusrat.java.drive_club.service.interfaces.SecurityService;
import com.nusrat.java.drive_club.service.interfaces.UserService;

import java.util.Optional;

/**
 * Created by Nusrat on 2/25/2017.
 */
public class DriverUserService implements UserService {
    private final UserDao userDao;
    private final SecurityService securityService;

    public DriverUserService(UserDao userDao, SecurityService securityService) {
        this.userDao = userDao;
        this.securityService = securityService;
    }

    @Override
    public Optional<User> getByCredentials(Credentials credentials) {
        final Optional<User> userOptional = userDao.getByLoginName(credentials.getLogin());
        if(!userOptional.isPresent()){
            return Optional.empty();
        }
        final User user = userOptional.get();
        if(!securityService.validate(credentials.getPassword(), user.getPasswordHash())){
            return Optional.empty();
        }
        return Optional.of(user);
    }
}
