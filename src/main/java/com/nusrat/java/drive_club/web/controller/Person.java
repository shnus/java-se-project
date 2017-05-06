package com.nusrat.java.drive_club.web.controller;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by Nusrat on 3/8/2017.
 */
@XmlRootElement
public class Person implements Serializable
{
    Person(){

    }

    Person(String input){
        this.input = input;
    }
    public String input;
    public String output;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}