package com.facebook.generic;

import java.sql.Connection;
import java.sql.DriverManager;

import org.testng.annotations.Test;

public class DBUtils {
public static Connection dbConnection = null;
	@Test
    private static void setMysqlDbConnection() throws Exception {

        try {

            Class.forName(UtilConfig.driver);

             dbConnection = DriverManager.getConnection(UtilConfig.url, UtilConfig.userName,

                    UtilConfig.password);

            if (!dbConnection.isClosed())

                System.out.println("Successfully connected to MySQL server");

        } catch (Exception e) {

            System.out.println("Cannot connect to database server");

        }
        
      
    }

}
