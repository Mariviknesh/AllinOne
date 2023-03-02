package org.example;
import java.util.Scanner;
import java.util.logging.*;
import java.sql.*;

class Dbase {
    private static Dbase db = null;

    public static Dbase create() {
        if (db == null) {
            db = new Dbase();
        }


        return db;
    }

    Logger log = Logger.getLogger("com.api.jar");

    public Connection connect() {
        String pass;
        Scanner s = new Scanner(System.in);
        log.info("Enter password");
        pass = s.next();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/login", "root", pass);
            if (con != null) {
                log.info("Connected");
            } else {
                log.info("Not Connected");

            }
            return con;
        } catch (Exception e) {
            log.info("Not Connected");
        }
        s.close();
        return null;
    }

    public void close(Connection con) {
        try {
            con.close();
            log.info("Closed");
        } catch (Exception e) {
            log.info("Not Closed");
        }
    }
}
