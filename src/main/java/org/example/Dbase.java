package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbase {
    private static final String url="jdbc:postgresql://localhost:5431/postgres";
    private static final String username="postgres";
    private static final String possword="1234567891";

    public static Connection connection(){
        Connection conn=null;
      try {
          conn= DriverManager.getConnection(url,username,possword);
          System.out.println("Connected to Dbase successfully");
      }catch (SQLException e){
          System.out.println(e.getMessage());
      }
      return conn;
    }
}
