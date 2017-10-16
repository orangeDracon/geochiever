package com.orangedracon.geochiever.sql.user_roles;

/**
 *
 * @author orangeDracon
 */
public class UserRole {

    private int role_id;
    private int id_user; 
    private String user_role;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getUser_role() {
        return user_role;
    }

    public void setUser_role(String user_role) {
        this.user_role = user_role;
    }
    
    
}