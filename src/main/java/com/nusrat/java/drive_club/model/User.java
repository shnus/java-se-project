package com.nusrat.java.drive_club.model;

import lombok.Builder;
import lombok.Value;

import javax.security.auth.Subject;
import java.security.Principal;
import java.time.LocalDate;

/**
 * Created by Nusrat on 2/12/2017.
 */
@Value
@Builder
public class User implements Principal {
    long id;
    String firstName;
    String lastName;
    LocalDate birthDate;
    String gender;
    String bio;
    String location;
    String loginName;
    String passwordHash;
    String image_b64;



    public String getName() {
        return firstName+" "+lastName;
    }

    public boolean implies(Subject subject) {
        return false;
    }
}
