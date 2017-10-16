package com.orangedracon.geochiever.sql.user_achi_zone;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author orangeDracon
 */
public class UserAchiZoneJDBCTemplate implements UserAchiZoneDAO{
        
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    public void setDataSource(DataSource dataSource){
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public UserAchiZone getUserAchiZoneData_byId(String id){
        String sqlComm = "SELECT * FROM user_achievement_zone WHERE id = ?";
        UserAchiZone userAchiZone = jdbcTemplate.queryForObject(sqlComm, new Object[]{id}, new UserAchiZoneMapper());
        
        return userAchiZone;
    }
    
    public int getUserAchiZoneCount_byUsername(String username){
        String sqlComm = "SELECT COUNT(*) FROM user_achievement_zone uaz, user u WHERE u.id_user = uaz.user_id AND u.username = ?";
        int userAchiZoneCount = jdbcTemplate.queryForObject(sqlComm, Integer.class, username);
        
        return userAchiZoneCount;
    }
    
    public List<UserAchiZone> getUserAchiZoneRatingsList(){
        String sqlComm = "SELECT *, COUNT( * ) AS 'count' FROM user_achievement_zone uaz, user u "
                       + "WHERE u.id_user = uaz.user_id "
                       + "GROUP BY u.username "
                       + "ORDER BY COUNT( * ) DESC ";
        List<UserAchiZone> userAchiZoneRatingsList = jdbcTemplate.query(sqlComm, new Object[]{}, new UserAchiZoneMapper());
        
        return userAchiZoneRatingsList;
    }
    
}
