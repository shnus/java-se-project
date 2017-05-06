package com.nusrat.java.drive_club.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Nusrat on 3/25/2017.
 */
@XmlRootElement
public class UserBean implements Serializable {

    @XmlElement(name="login")
    public String login;

    @XmlElement(name="password")
    public String password;

    @XmlElement(name="firstName")
    public String firstName;

    @XmlElement(name="lastName")
    public String lastName;

    @XmlElement(name="gender")
    public String gender;

    @XmlElement(name="birthDate")
    public String birthDate;

    @XmlElement(name="location")
    public String location;

    @XmlElement(name="image_b64")
    public String image_b64;

}
