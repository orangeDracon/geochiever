package com.orangedracon.geochiever.sql.user_achi_point;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author orangeDracon
 */
public class UserAchiPointJDBCTemplate implements UserAchiPointDAO{
        
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public UserAchiPoint getUserAchiPointData_byId(String id){
        String sqlComm = "SELECT * FROM user_achievement_point WHERE id = ?";
        UserAchiPoint userAchiPoint = jdbcTemplate.queryForObject(sqlComm, new Object[]{id}, new UserAchiPointMapper());
        
        return userAchiPoint;
    }
    
    public int getUserAchiPointCount_byUsername(String username){
        String sqlComm = "SELECT COUNT(*) FROM user_achievement_point uap, user u WHERE u.id_user = uap.user_id AND u.username = ?";
        int userAchiPointCount = jdbcTemplate.queryForObject(sqlComm, Integer.class, username);
        
        return userAchiPointCount;
    }
    
    public List<UserAchiPoint> getUserAchiPointRatingsList(){
        String sqlComm = "SELECT *, COUNT( * ) AS 'count' FROM user_achievement_point uap, user u "
                       + "WHERE u.id_user = uap.user_id "
                       + "GROUP BY u.username "
                       + "ORDER BY COUNT( * ) DESC ";
        List<UserAchiPoint> userAchiPointRatingsList = jdbcTemplate.query(sqlComm, new Object[]{}, new UserAchiPointMapper());
        
        return userAchiPointRatingsList;
    }
    
        public void insertNewUserAchiPoint(int user_id, int achievement_id){
        JdbcTemplate jdbcTeamplateObject = new JdbcTemplate(dataSource);
        String sqlComm = "INSERT INTO user_achievement_point (user_id, achievement_id) VALUES ('" + user_id + "','" + achievement_id + "')";
        jdbcTeamplateObject.update(sqlComm);
    }
    
    /*public int getUserAchiPointRatingPosition_byUsername(String username){
        String sqlComm = "SELECT COUNT(*) FROM user_achievement_point uap, user u WHERE u.id_user = uap.user_id AND u.username = ?";
        int userAchiPointCount = jdbcTemplate.queryForObject(sqlComm, Integer.class, username);
        
        return userAchiPointCount;
    } */
}
