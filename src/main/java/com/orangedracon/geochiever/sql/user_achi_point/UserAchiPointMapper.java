package com.orangedracon.geochiever.sql.user_achi_point;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author orangeDracon
 */
public class UserAchiPointMapper implements RowMapper<UserAchiPoint>{
    
    public UserAchiPoint mapRow(ResultSet resultSet, int row) throws SQLException {
        
        UserAchiPoint userAchiPoint = new UserAchiPoint();
        
        userAchiPoint.setId(resultSet.getInt("id"));
        userAchiPoint.setUser_id(resultSet.getInt("user_id"));
        userAchiPoint.setAchievement_id(resultSet.getInt("achievement_id"));
        userAchiPoint.setDate_achieved(resultSet.getDate("date_achieved"));   
        
        userAchiPoint.setUsername(resultSet.getString("username"));
        
        userAchiPoint.setCount(resultSet.getInt("count"));
        
        return userAchiPoint;
    }
}
