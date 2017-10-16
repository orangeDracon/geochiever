package com.orangedracon.geochiever.sql.user;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author orangeDracon
 */
public class UserJDBCTemplate implements UserDAO {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User getUserDataIfUserExists(String username) throws EmptyResultDataAccessException, SQLException{
        String sqlComm = "SELECT username FROM user WHERE username = ?";

        User user = new User();
        try {
            user = jdbcTemplate.queryForObject(sqlComm, new Object[]{username}, new UserMapper());
        } 
        catch (EmptyResultDataAccessException e) {
        }
        catch (Exception se) {
            se.printStackTrace();
        }
        
        return user;
    }

    public User getUserData_byUsername(String username) {
        String sqlComm = "SELECT * FROM user WHERE username = ?";
        User user = jdbcTemplate.queryForObject(sqlComm, new Object[]{username}, new UserMapper());
        return user;
    }

    public void createNewUser(String username, String email, String password) {
        JdbcTemplate jdbcTeamplateObject = new JdbcTemplate(dataSource);
        String sqlComm = "INSERT INTO user (username, email, password) VALUES ('" + username + "','" + email + "','" + password + "')";
        jdbcTeamplateObject.update(sqlComm);
    }

    public int getUserId_byUsername(String username) {
        String sqlComm = "SELECT id_user FROM user WHERE username = ?";
        int id_user = jdbcTemplate.queryForObject(sqlComm, Integer.class, username);

        return id_user;
    }

}
