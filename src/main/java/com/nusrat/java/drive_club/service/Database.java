package com.nusrat.java.drive_club.service;

/**
 * Created by Nusrat on 3/14/2017.
 */

import org.apache.commons.dbcp2.BasicDataSource;

import javax.annotation.ManagedBean;
import java.sql.Connection;
import java.sql.SQLException;

@ManagedBean
public class Database {

    private Database(){
        createPool();
    }

    private static BasicDataSource basicDataSource = null;

    private static void createPool() {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:postgresql://localhost:5432/drive_club");
        basicDataSource.setUsername("nusrat");
        basicDataSource.setPassword("5555");

        basicDataSource.setMinIdle(5);
        basicDataSource.setMaxIdle(10);
        basicDataSource.setMaxOpenPreparedStatements(100);
    }

    public static Connection getConnection() throws SQLException {
        if(basicDataSource==null) {
            createPool();
        }

        return basicDataSource.getConnection();
    }

}