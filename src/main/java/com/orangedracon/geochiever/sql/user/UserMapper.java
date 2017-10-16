package com.orangedracon.geochiever.sql.user;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author orangeDracon
 */
public class UserMapper implements RowMapper<User> {
    
    public User mapRow(ResultSet resultSet, int row) throws SQLException {
        
        User user = new User();
        user.setId_user(resultSet.getInt("id_user"));
        user.setEmail(resultSet.getString("email"));
        user.setUsername(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        user.setDistance(resultSet.getDouble("distance"));
        
        return user;
    }
}
