package com.orangedracon.geochiever.sql.user_achi_zone;

import java.sql.Date;

/**
 *
 * @author orangeDracon
 */
public class UserAchiZone {

    private int id;
    private int user_id;
    private int achievement_id;
    private Date date_achieved;
    
    private String username;
    
    private int count; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAchievement_id() {
        return achievement_id;
    }

    public void setAchievement_id(int achievement_id) {
        this.achievement_id = achievement_id;
    }

    public Date getDate_achieved() {
        return date_achieved;
    }

    public void setDate_achieved(Date date_achieved) {
        this.date_achieved = date_achieved;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
