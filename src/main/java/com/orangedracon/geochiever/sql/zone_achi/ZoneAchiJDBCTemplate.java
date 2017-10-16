package com.orangedracon.geochiever.sql.zone_achi;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author orangeDracon
 */
public class ZoneAchiJDBCTemplate implements ZoneAchiDAO{
        
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public ZoneAchi getZoneAchiData_byId(String id){
        String sqlComm = "SELECT * FROM zone_achievement WHERE id = ?";
        ZoneAchi zoneAchi = jdbcTemplate.queryForObject(sqlComm, new Object[]{id}, new ZoneAchiMapper());
        
        return zoneAchi;
    }
    
    public List<ZoneAchi> getAllZoneAchi(){
        String sqlComm = "SELECT * FROM zone_achievement WHERE active = 1";
        List<ZoneAchi> allZoneAchiList = jdbcTemplate.query(sqlComm, new Object[]{}, new ZoneAchiMapper());
        
        return allZoneAchiList;
    }
    
    public List<ZoneAchi> getAchievedUserZoneAchi_byUsername(String username, int isActive){
        String sqlComm = "SELECT * FROM zone_achievement pa, user_achievement_zone uap, user u "
                       + "WHERE u.id_user = uap.user_id AND uap.achievement_id = pa.id AND u.username = ? AND pa.active = ?";
        List<ZoneAchi> userAchievedZoneAchiList = jdbcTemplate.query(sqlComm, new Object[]{username, isActive}, new ZoneAchiMapper());
        
        return userAchievedZoneAchiList;
    }
    
    public List<ZoneAchi> getUndoneUserZoneAchi_byUsername(String username, int isActive){
        String sqlComm = "SELECT * FROM zone_achievement pa "
                       + "WHERE NOT EXISTS ( "
                       + "SELECT * FROM user_achievement_zone uap, user u "
                       + "WHERE u.id_user = uap.user_id AND uap.achievement_id = pa.id AND u.username = ? AND pa.active = ?)";
        List<ZoneAchi> userUndoneZoneAchiList = jdbcTemplate.query(sqlComm, new Object[]{username, isActive}, new ZoneAchiMapper());
        
        return userUndoneZoneAchiList;
    }
    
    public List<ZoneAchi> getLatestZoneAchi_byUsername(String username){
        String sqlComm = "SELECT * FROM zone_achievement pa, user_achievement_zone uap, user u "
                       + "WHERE u.id_user = uap.user_id AND uap.achievement_id = pa.id AND u.username = ? ORDER BY uap.date_achieved DESC LIMIT 3";
        List<ZoneAchi> latestZoneAchiList = jdbcTemplate.query(sqlComm, new Object[]{username}, new ZoneAchiMapper());
        
        return latestZoneAchiList;
    }
}
