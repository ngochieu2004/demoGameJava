/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataprovider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Admin
 */
public class SQLServerDataProvider {
    private Connection conn;
    
    public void open(){
        String strServer="localhost";
        String strDatabase="CaroUser";
        String strUsername="sa";
        String strPassword="ngochieu2004";
        try
        {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
          String connectionURL="jdbc:sqlserver://"+strServer+":1433;databaseName="
                  +strDatabase+" ;user ="+strUsername+"; password=" +strPassword;
          conn=DriverManager.getConnection(connectionURL);
        }
        catch(Exception ex)  
        {
            ex.printStackTrace();
        }

    }
    
    public void close(){
        try{
            this.conn.close();
        }
        catch(Exception ex)  
        {
            ex.printStackTrace();
        }
    }
    
    public ResultSet executeQuery(String sql){
        ResultSet rs = null;
        try{
            Statement sta = conn.createStatement();
            rs =sta.executeQuery(sql);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return rs;
    }
    
    public int executeUpdate(String sql){
        int n =-1;
        try{
            Statement sta = conn.createStatement();
            n = sta.executeUpdate(sql);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return n;
    } 
}
