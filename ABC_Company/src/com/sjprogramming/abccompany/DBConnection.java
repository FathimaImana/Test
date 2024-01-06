package com.sjprogramming.abccompany;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;  //create variable Connection
    public static Connection createDBConnection(){ //create method


        try{
            //Get DB Connection

            String url="jdbc:mysql://localhost:3306/login_schema?useSSL=false";
            String username ="root";
            String password ="1234";

            con= DriverManager.getConnection(url,username, password);

        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return con;
    }
}
