package com.orangedracon.geochiever.sql.user_achi_zone;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author orangeDracon
 */
public class UserAchiZoneMapper implements RowMapper<UserAchiZone> {

    public UserAchiZone mapRow(ResultSet resultSet, int row) throws SQLException {

        UserAchiZone userAchiZone = new UserAchiZone();

        userAchiZone.setId(resultSet.getInt("id"));
        userAchiZone.setUser_id(resultSet.getInt("user_id"));
        userAchiZone.setAchievement_id(resultSet.getInt("achievement_id"));
        userAchiZone.setDate_achieved(resultSet.getDate("date_achieved"));
        
        userAchiZone.setUsername(resultSet.getString("username"));
        
        userAchiZone.setCount(resultSet.getInt("count"));

        return userAchiZone;
    }

}