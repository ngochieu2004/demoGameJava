/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.User;
import com.sun.xml.internal.ws.util.StringUtils;
import dataprovider.SQLServerDataProvider;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author ngochieu
 */
public class UserDAO {
    public static User LogInUser(String username, String password){
        User user=new User();
        try{
            String sql="SELECT * FROM USERCARO WHERE USERNAME='"+username+"' AND PASS='"+password+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                user.setUsername(rs.getString("username"));
                user.setUserfullname(rs.getString("tennguoichoi"));                
                user.setIsLogIn(true);
            }
            provider.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return user;
    }
    public static User getUser(String username){
        User user=new User();
        try{
            String sql="SELECT * FROM USERCARO WHERE USERNAME='"+username+"'";
            SQLServerDataProvider provider = new SQLServerDataProvider();
            provider.open();
            ResultSet rs = provider.executeQuery(sql);
            while(rs.next()){
                user.setUsername(rs.getString("username"));
                user.setUserfullname(rs.getString("tennguoichoi"));  
                user.setScore(rs.getInt("solanthang"));
                user.setTimePlayed(rs.getInt("solanchoi"));
                user.setIsLogIn(true);
            }
            provider.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return user;
    }
//    public static boolean isUserNameExist(String username){
//        boolean kq=false;
//        try{
//        String sql="SELECT username FROM USERCARO WHERE USERNAME='"+username+"'";
//        SQLServerDataProvider provider = new SQLServerDataProvider();
//            provider.open();
//            ResultSet rs = provider.executeQuery(sql);
//            rs.next();
//            String user=rs.getString("username");
//            //user=StringUtils.deleteWhitespace(user);
//            user.replaceAll("\\s+","");
//            if(user.equals(username))
//                kq=true;
//            provider.close();
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
//        return kq;
//        
//    }
    public static String getUserName(String username){
        String user = null;
        try{
            String sql="SELECT * FROM USERCARO WHERE USERNAME='"+username+"'";
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            boolean next = rs.next();
            if(next)
                user=rs.getString("USERNAME");
            provider.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return user;
    }
    public static boolean addUser(String user, String pass, String name)
    {
        boolean kq=false;
        String sql= String.format("INSERT INTO USERCARO VALUES ('"+user+"','"+pass+"',N'"+name+"',0,0)");
        SQLServerDataProvider provider =new SQLServerDataProvider();
        provider.open();
        int n=provider.executeUpdate(sql);
        if(n==1)
            kq=true;
        provider.close();
        return kq;
    }
    public static ArrayList<User> getListUer(){
        ArrayList<User>list=new ArrayList<User>();
        try{
            String sql="SELECT * FROM USERCARO";
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            while(rs.next())
            {
                User user=new User();
                user.setUserfullname(rs.getString("tennguoichoi"));
                user.setScore(rs.getInt("solanthang"));
                user.setTimePlayed(rs.getInt("solanchoi"));
                list.add(user);
            }
            provider.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return list;
    }
    public static boolean reNameUser(String username, String name, String pass){
        boolean kq=false;
        String sql= String.format("UPDATE USERCARO SET TENNGUOICHOI= N'"+name+"' WHERE USERNAME='"+username+"' AND PASS='"+pass+"'");
        SQLServerDataProvider provider =new SQLServerDataProvider();
        provider.open();
        int n=provider.executeUpdate(sql);
        if(n==1)
            kq=true;
        provider.close();
        return kq;
    }
    public static boolean rePassUser (String username, String pass){
        boolean kq=false;
        String sql= String.format("UPDATE USERCARO SET Pass= '"+pass+"' WHERE USERNAME='"+username+"'");
        SQLServerDataProvider provider =new SQLServerDataProvider();
        provider.open();
        int n=provider.executeUpdate(sql);
        if(n==1)
            kq=true;
        provider.close();
        return kq;
    }
    public static String getPass(String username)
    {
        String pass=null;
        try{
            String sql="SELECT * FROM USERCARO WHERE USERNAME='"+username+"'";
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            boolean next=rs.next();
            if(next)
                pass=rs.getString("PASS");
            provider.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        pass.trim();
        return pass;
    }
    public static boolean updateScore(String username){
        boolean kq=false;
        String sql= String.format("UPDATE USERCARO SET solanthang= solanthang+1 WHERE USERNAME='"+username+"'");
        SQLServerDataProvider provider =new SQLServerDataProvider();
        provider.open();
        int n=provider.executeUpdate(sql);
        if(n==1)
            kq=true;
        provider.close();
        return kq;
    }
    public static boolean updateTimePlayed(String username){
        boolean kq=false;
        String sql= String.format("UPDATE USERCARO SET solanchoi = solanchoi + 1 WHERE USERNAME='"+username+"'");
        SQLServerDataProvider provider =new SQLServerDataProvider();
        provider.open();
        int n=provider.executeUpdate(sql);
        if(n==1)
            kq=true;
        provider.close();
        return kq;
    }
    public static String getName(String username){
        String user = null;
        try{
            String sql="SELECT * FROM USERCARO WHERE USERNAME='"+username+"'";
            SQLServerDataProvider provider=new SQLServerDataProvider();
            provider.open();
            ResultSet rs=provider.executeQuery(sql);
            boolean next = rs.next();
            if(next)
                user=rs.getString("tennguoichoi");
            provider.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        return user;
    }
}