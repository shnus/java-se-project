package com.nusrat.java.drive_club.service.interfaces;

import com.nusrat.java.drive_club.model.Credentials;
import com.nusrat.java.drive_club.model.User;
import com.nusrat.java.drive_club.model.UserBean;
import com.nusrat.java.drive_club.service.Validation;
import org.glassfish.jersey.spi.Contract;

import java.util.Optional;

/**
 * Created by Nusrat on 2/25/2017.
 */
@Contract
public interface UserService {
    Validation checkUser(UserBean user);

    Optional<User> getByCredentials(Credentials credentials);

    void createUser(UserBean user);
}
