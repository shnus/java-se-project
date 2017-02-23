package com.nusrat.java.drive_club.model;

import lombok.Value;

import java.util.List;

/**
 * Created by Nusrat on 2/12/2017.
 */
@Value
public class Profile {
    List<Car> activeCars;
    List<Car> oldCars;
}
