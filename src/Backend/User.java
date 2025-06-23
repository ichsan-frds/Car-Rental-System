/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Backend;

import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class User {
    private String usernamelama;
    private String usernamebaru;
    private String pass; 
    private String email; 
    private String level;
    
    public Koneksi kon = new Koneksi();
    public ResultSet r = null;
    
    public User(){ }
    
    public String getUsernamelama(){ return usernamelama; }
    public String getUsernamebaru(){ return usernamebaru; }
    public String getPass(){ return pass; }
    public String getEmail(){ return email; }
    public String getLevel(){ return level; }

    public void setUsernamelama(String usernamelama){ this.usernamelama = usernamelama; }
    public void setUsernamebaru(String usernamebaru){ this.usernamebaru = usernamebaru; }
    public void setPass(String pass){ this.pass = pass; } 
    public void setEmail(String email){ this.email = email; } 
    public void setLevel(String level){ this.level = level; }
    
    public void insertUser(){ 
        String s = "insert into users values ('"+this.usernamebaru+"', '"+this.pass+"', '"+this.email+"', '"+this.level+"')"; 
        kon.query(s);
    }
    
    public void updateUser(){  
        String s = "update users set username = '"+this.usernamebaru+"', pass = '"+this.pass+"', email = '"+this.email+"', level = '"+this.level+"' where username = '"+this.usernamelama+"'";
        kon.query(s); 
    }
    
    public void deleteUser(){ 
        String s = "delete from users where username = '" + this.usernamebaru+"'";
        kon.query(s);
    }
    
    public ResultSet getUser(){
        r = kon.getData("select * from users");
        return r;
    }
    
    public ResultSet getUserUsername(){
        r = kon.getData("select * from users where username = '"+this.usernamebaru+"'");
        return r;
    }
}
