package com.nusrat.java.drive_club.dao;

import com.nusrat.java.drive_club.model.User;
import com.nusrat.java.drive_club.service.Database;
import com.nusrat.java.drive_club.service.SecurityServiceImpl;
import org.jvnet.hk2.annotations.Service;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Nusrat on 2/25/2017.
 */
@ManagedBean
@Service
public class UserDaoImpl implements UserDao {

    final SecurityServiceImpl securityService;

    @Inject
    public UserDaoImpl(SecurityServiceImpl securityService) {
        this.securityService = securityService;
    }

    public Optional<User> getByLoginName(String loginName) {
        try(Connection connection = Database.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\"" +
                    "WHERE login=?");
            statement.setString(1,loginName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            return Optional.ofNullable(User.builder()
                    .passwordHash(resultSet.getString("passwordhash"))
                    .loginName(resultSet.getString("login"))
                    .firstName(resultSet.getString("firstname"))
                    .lastName(resultSet.getString("lastname"))
                    .gender(resultSet.getString("gender"))
                    .birthDate(LocalDate.parse(resultSet.getString("birthday")))
                    .location(resultSet.getString("location"))
                    .bio(resultSet.getString("bio"))
                    .image_b64(resultSet.getString("image"))
                    .build());


        } catch (SQLException e) {
            e.printStackTrace();
            return Optional.empty();
        }
       // return dummy(loginName);
    }

    @Override
    public boolean createUser(User user) {
        try(Connection connection = Database.getConnection()){
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"User\"(login,"
                    +"passwordhash,firstname,lastname,gender,birthday,location,bio,image) VALUES "
                    +"(?, ?, ?, ?, ?, to_date(?,'YYYY-MM-DD'), ?, ?, ?);");

            statement.setString(1,user.getLoginName());
            statement.setString(2,user.getPasswordHash());
            statement.setString(3,user.getFirstName());
            statement.setString(4,user.getLastName());
            statement.setString(5,user.getGender());
            statement.setString(6,user.getBirthDate().toString());
            statement.setString(7,user.getLocation());
            statement.setString(8,user.getBio());
            statement.setString(9,user.getImage_b64());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean isExist(String login) {
        return false;
    }

    public Optional<User> dummy(String loginName) {
        if(!"test@test.test".equals(loginName)){
            return Optional.empty();
        }

        return Optional.of(
                User.builder()
                    .firstName("Nusrat")
                    .lastName("Shakarov")
                    .birthDate(LocalDate.parse("1996-05-29"))
                    .loginName("test@test.test")
                    .passwordHash(securityService.encrypt("test"))
                .build()
        );

    }
}
