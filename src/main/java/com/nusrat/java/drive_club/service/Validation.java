package com.nusrat.java.drive_club.service;

import lombok.Builder;
import lombok.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nusrat on 2/27/2017.
 */
@Builder
@Value
public class Validation {
    public Validation(){

    }
    Map<String,Boolean> valid = new HashMap();
}
