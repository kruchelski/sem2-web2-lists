package com.ufpr.tads.web2.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    String driver, hostname, password, port, database, url, user;
    
    private static final String PROPS_FILE = "/com/ufpr/tads/web2/dao/db.properties";
    
    public ConnectionFactory() {
        try {
            Properties props = new Properties();
            props.load(ConnectionFactory.class.getResourceAsStream(PROPS_FILE));
            driver = props.getProperty("db.driver");
            hostname = props.getProperty("db.host");
            password = props.getProperty("db.password");
            port = props.getProperty("db.port");
            database = props.getProperty("db.database");
            url = props.getProperty("db.url");
            user = props.getProperty("db.user");
        } catch(IOException e) {
            throw new RuntimeException ("Error reading database properties " + e.getMessage());
        }   
    }
    public Connection getConnection() throws SQLException {
        String dbUrl = url + hostname + ":" + port + "/" + database;
        
        try {
            Class.forName(driver);
            return DriverManager.getConnection(dbUrl, user, password);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Database driver not found " + e.getMessage());
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to the database " + e.getMessage());
        }
    }
    
}
