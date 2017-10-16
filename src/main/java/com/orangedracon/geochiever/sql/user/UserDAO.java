package com.orangedracon.geochiever.sql.user;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;

/**
 *
 * @author orangeDracon
 */
public interface UserDAO {

    public void setDataSource(DataSource dataSource);

    public void createNewUser(String email, String userName, String password);

    public User getUserDataIfUserExists(String username)throws EmptyResultDataAccessException, SQLException;
    
    public User getUserData_byUsername(String username);

}
