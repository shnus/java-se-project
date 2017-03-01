package com.nusrat.java.drive_club.web.listener;

import com.google.inject.Module;
import com.google.inject.servlet.ServletModule;
import com.nusrat.java.drive_club.dao.DriverUserDao;
import com.nusrat.java.drive_club.dao.UserDao;
import com.nusrat.java.drive_club.service.DriverSecurityService;
import com.nusrat.java.drive_club.service.DriverUserService;
import com.nusrat.java.drive_club.service.interfaces.SecurityService;
import com.nusrat.java.drive_club.service.interfaces.UserService;
import com.squarespace.jersey2.guice.JerseyGuiceServletContextListener;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nusrat on 3/1/2017.
 */
public class MyJerseyGuiceServletContextListener extends JerseyGuiceServletContextListener {
    @Override
    protected List<? extends Module> modules() {
        return Collections.singletonList(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(SecurityService.class).to(DriverSecurityService.class);
                bind(UserDao.class).to(DriverUserDao.class);
                bind(UserService.class).to(DriverUserService.class);
            }
        });
    }
}