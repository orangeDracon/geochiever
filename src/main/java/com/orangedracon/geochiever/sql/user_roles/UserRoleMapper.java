package com.orangedracon.geochiever.sql.user_roles;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author orangeDracon
 */
public class UserRoleMapper implements RowMapper<UserRole> {
    
    public UserRole mapRow(ResultSet resultSet, int row) throws SQLException {
        
        UserRole userRole = new UserRole();
        userRole.setRole_id(resultSet.getInt("tole_id"));
        userRole.setId_user(resultSet.getInt("user_role"));
        userRole.setUser_role(resultSet.getString("user_role"));
        
        return userRole;
    }
}