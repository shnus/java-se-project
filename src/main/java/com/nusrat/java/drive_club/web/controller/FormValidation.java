package com.nusrat.java.drive_club.web.controller;

import lombok.Builder;
import lombok.Value;

import java.util.Map;

/**
 * Created by Nusrat on 2/19/2017.
 */
@Builder
@Value
public class FormValidation {
    Map<String, Boolean> validation;
}
