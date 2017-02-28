package com.nusrat.java.drive_club.service.interfaces;

import com.nusrat.java.drive_club.model.Credentials;
import com.nusrat.java.drive_club.model.User;

import java.util.Optional;

/**
 * Created by Nusrat on 2/25/2017.
 */

public interface UserService {
    Optional<User> getByCredentials(Credentials credentials);
}
