package com.orangedracon.geochiever.sql.point_achi;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author orangeDracon
 */
public class PointAchiJDBCTemplate implements PointAchiDAO{
        
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public PointAchi getPointAchiData_byId(String id){
        String sqlComm = "SELECT * FROM point_achievement WHERE id = ?";
        PointAchi pointAchi = jdbcTemplate.queryForObject(sqlComm, new Object[]{id}, new PointAchiMapper());
        
        return pointAchi;
    }
    
    public List<PointAchi> getAllPointAchi(){
        String sqlComm = "SELECT * FROM point_achievement WHERE active = 1";
        List<PointAchi> allPointAchiList = jdbcTemplate.query(sqlComm, new Object[]{}, new PointAchiMapper());
        
        return allPointAchiList;
    }
    
    public List<PointAchi> getAchievedUserLandmarkAchi_byUsername(String username, int isActive){
        String sqlComm = "SELECT * FROM point_achievement pa, user_achievement_point uap, user u "
                       + "WHERE u.id_user = uap.user_id AND uap.achievement_id = pa.id AND pa.type = 'landmark' AND u.username = ? AND pa.active = ?";
        List<PointAchi> userAchievedLandmarkAchiList = jdbcTemplate.query(sqlComm, new Object[]{username, isActive}, new PointAchiMapper());
        
        return userAchievedLandmarkAchiList;
    }
    
    public List<PointAchi> getUndoneUserLandmarkAchi_byUsername(String username, int isActive){
        String sqlComm = "SELECT * FROM point_achievement pa, user u "
                       + "WHERE NOT EXISTS ( "
                       + "SELECT * FROM user_achievement_point uap, user u "
                       + "WHERE u.id_user = uap.user_id AND uap.achievement_id = pa.id) "
                       + "AND pa.type = 'landmark' AND u.username = ? AND pa.active = ?";
        List<PointAchi> userUndoneLandmarkAchiList = jdbcTemplate.query(sqlComm, new Object[]{username, isActive}, new PointAchiMapper());
        
        return userUndoneLandmarkAchiList;
    }
    
    public List<PointAchi> getAchievedUserTownAchi_byUsername(String username, int isActive){
        String sqlComm = "SELECT * FROM point_achievement pa, user_achievement_point uap, user u "
                       + "WHERE u.id_user = uap.user_id AND uap.achievement_id = pa.id AND pa.type = 'town' AND u.username = ? AND pa.active = ?";
        List<PointAchi> userAchievedTownAchiList = jdbcTemplate.query(sqlComm, new Object[]{username, isActive}, new PointAchiMapper());
        
        return userAchievedTownAchiList;
    }
    
    public List<PointAchi> getUndoneUserTownAchi_byUsername(String username, int isActive){
        String sqlComm = "SELECT * FROM point_achievement pa, user u "
                       + "WHERE NOT EXISTS ( "
                       + "SELECT * FROM user_achievement_point uap, user u "
                       + "WHERE u.id_user = uap.user_id AND uap.achievement_id = pa.id) "
                       + "AND pa.type = 'town' AND u.username = ? AND pa.active = ?";
        List<PointAchi> userUndoneTownAchiList = jdbcTemplate.query(sqlComm, new Object[]{username, isActive}, new PointAchiMapper());
        
        return userUndoneTownAchiList;
    }
    
    public List<PointAchi> getLatestPointAchi_byUsername(String username){
        String sqlComm = "SELECT * FROM point_achievement pa, user_achievement_point uap, user u "
                       + "WHERE u.id_user = uap.user_id AND uap.achievement_id = pa.id AND u.username = ? ORDER BY uap.date_achieved DESC LIMIT 3";
        List<PointAchi> latestPointAchiList = jdbcTemplate.query(sqlComm, new Object[]{username}, new PointAchiMapper());
        
        return latestPointAchiList;
    }
    
    public int getPointAchiData_byName(String name){
        String sqlComm = "SELECT id FROM point_achievement WHERE name = ?";
        int userAchiPointId = jdbcTemplate.queryForObject(sqlComm, Integer.class, name);
        
        return userAchiPointId;
    }
    

}
