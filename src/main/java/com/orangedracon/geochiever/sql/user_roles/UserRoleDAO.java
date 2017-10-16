package com.orangedracon.geochiever.sql.user_roles;

import javax.sql.DataSource;

/**
 *
 * @author orangeDracon
 */
public interface UserRoleDAO {
    
    public void setDataSource(DataSource dataSource);

    public void createNewUserRole_ROLE_USER(int id_user);
}
