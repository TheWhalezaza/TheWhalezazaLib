package me.thewhalezaza.thewhalezazalib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TWZLibralyMySQL {
    private static Connection connection;
    public String host,database,username,password;
    public int port;
    public TWZLibralyMySQL(String host, String database, String username, String password, int port){
        this.host = host;
        this.database = database;
        this.password = password;
        this.username = username;
        this.port = port;
    }
    public void mysqlSetup(){
        try{

            synchronized (this){
                if(getConnection() != null && !getConnection().isClosed()){
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection( DriverManager.getConnection("jdbc:mysql://" + this.host + ":"
                        + this.port + "/" + this.database, this.username, this.password));

                System.out.println("MySQL Connected!");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
