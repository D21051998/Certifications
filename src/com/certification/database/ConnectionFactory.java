package com.certification.database;
/**
 * @author Deepanshu Jain
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance = new ConnectionFactory();
    private final static String URL = "jdbc:mysql://localhost/publication_module";
    private final static String USER = "root";
    private final static String PASSWORD = "root";
    private static final String DRIVER_CLASS = "com.mysql.jdbc.Driver";

    private ConnectionFactory() {
        try {
           Class.forName(DRIVER_CLASS);
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }
    }
    
    public static Connection getConnection() throws SQLException{
        if(instance == null){
            instance = new ConnectionFactory();
            //System.out.println("NEW CONNECTION!");
        }
        try{
            //System.out.println("CONNECTION CALLED!");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch(SQLException e){
            throw e;
        }
    }


    
    public static void close(Connection c){
        try{
            if(null!=c){
                c.close();
                c=null;
                //System.out.println("CONNECTION CLOSED");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}