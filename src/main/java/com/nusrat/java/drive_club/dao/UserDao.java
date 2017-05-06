package com.nusrat.java.drive_club.dao;

import com.nusrat.java.drive_club.model.User;

import java.util.Optional;

/**
 * Created by Nusrat on 2/25/2017.
 */
public interface UserDao {
    Optional<User> getByLoginName(String loginName);
    boolean createUser(User user);

    boolean isExist(String login);


}
