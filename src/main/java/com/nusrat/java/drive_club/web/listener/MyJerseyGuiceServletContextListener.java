package com.nusrat.java.drive_club.web.listener;

import com.google.inject.Module;
import com.google.inject.servlet.ServletModule;
import com.nusrat.java.drive_club.dao.UserDao;
import com.nusrat.java.drive_club.dao.UserDaoImpl;
import com.nusrat.java.drive_club.service.SecurityServiceImpl;
import com.nusrat.java.drive_club.service.UserServiceImpl;
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
                bind(SecurityService.class).to(SecurityServiceImpl.class);
                bind(UserDao.class).to(UserDaoImpl.class);
                bind(UserService.class).to(UserServiceImpl.class);
            }
        });
    }




}