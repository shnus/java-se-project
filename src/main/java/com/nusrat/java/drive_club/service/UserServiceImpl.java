package com.nusrat.java.drive_club.service;

import com.nusrat.java.drive_club.dao.UserDao;
import com.nusrat.java.drive_club.model.Credentials;
import com.nusrat.java.drive_club.model.User;
import com.nusrat.java.drive_club.model.UserBean;
import com.nusrat.java.drive_club.service.interfaces.SecurityService;
import com.nusrat.java.drive_club.service.interfaces.UserService;
import org.apache.commons.validator.routines.EmailValidator;
import org.jvnet.hk2.annotations.Service;

import javax.inject.Inject;
import java.time.LocalDate;
import java.util.Optional;

/**
 * Created by Nusrat on 2/25/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    final UserDao userDao;

    final SecurityService securityService;

    @Inject
    public UserServiceImpl(UserDao userDao, SecurityService securityService) {
        this.userDao = userDao;
        this.securityService = securityService;
    }

    @Override
    public Validation checkUser(UserBean user) {
        System.out.println("START CHECKING");
        final Validation validation  = Validation.builder().build();

        System.out.println("EMAIL CHECKING");
        if(userDao.isExist(user.login)) {
            validation.getValid().put("USER_EXIST", true);
        } else if(!EmailValidator.getInstance().isValid(user.login)){
            validation.getValid().put("INVALID_EMAIL", true);
            System.out.println("!!!!!!!!!!"+user.login);
        } else{
            System.out.println(user.login+"nice");
        }

        if(!(user.firstName+user.lastName).matches("[a-zA-Z]+")) {
            validation.getValid().put("INVALID_NAME", true);
        }

        return validation;
    }

    @Override
    public Optional<User> getByCredentials(Credentials credentials) {
        final Optional<User> userOptional = userDao.getByLoginName(credentials.getLogin());
        if(!userOptional.isPresent()){
            return Optional.empty();
        }

        final User user = userOptional.get();
        if(!securityService.validate(credentials.getPassword(), user.getPasswordHash())){
            System.out.println(credentials.getPassword());
            System.out.println(securityService.encrypt("akram")+
            "\n\n\n"+
                    securityService.encrypt(credentials.getPassword())+
                    "\n\n\n"+
            user.getPasswordHash());
            return Optional.empty();
        }
        return Optional.of(user);
    }

    @Override
    public void createUser(UserBean user) {
        if(user.birthDate.contains("!")){
            user.birthDate="0001-01-01";
        }
        userDao.createUser(
                User.builder()
                        .loginName(user.login)
                        .passwordHash(securityService.encrypt(user.password))
                        .firstName(user.firstName)
                        .lastName(user.lastName)
                        .gender(user.gender)
                        .birthDate(LocalDate.parse(user.birthDate))
                        .location(user.location)
                        .bio("")
                        .image_b64(user.image_b64)
                        .build());
    }

    private boolean isExist(String login){
        return false;
    }



}
