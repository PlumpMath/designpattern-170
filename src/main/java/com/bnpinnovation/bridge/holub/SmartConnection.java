package com.bnpinnovation.bridge.holub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by sajacaros on 16. 5. 30.
 */
public class SmartConnection {
    String username, password;
    Connection connection;

    public void connect(String databaseURL) throws Exception {
        Class.forName( databaseURL).newInstance();
        Connection connection = null;
        Statement statement = null;

        connection = DriverManager.getConnection(databaseURL, username, password);
    }
}
