package com.nusrat.java.drive_club.model;

import lombok.Builder;
import lombok.Value;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Date;

/**
 * Created by Nusrat on 2/12/2017.
 */
@Value
@Builder
public class User implements Principal {
    long id;
    String firstName;
    String lastName;
    Date birthDate;
    String loginName;
    String passwordHash;

    public String getName() {
        return firstName+" "+lastName;
    }

    public boolean implies(Subject subject) {
        return false;
    }
}
