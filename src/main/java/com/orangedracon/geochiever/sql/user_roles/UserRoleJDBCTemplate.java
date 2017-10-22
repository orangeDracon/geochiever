package com.orangedracon.geochiever.sql.user_roles;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author orangeDracon
 */
public class UserRoleJDBCTemplate implements UserRoleDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void createNewUserRole_ROLE_USER(int id_user) {
		JdbcTemplate jdbcTeamplateObject = new JdbcTemplate(dataSource);
		String sqlComm = "INSERT INTO user_roles (id_user, user_role) VALUES ('" + id_user + "', 'ROLE_USER')";
		jdbcTeamplateObject.update(sqlComm);
	}
}
