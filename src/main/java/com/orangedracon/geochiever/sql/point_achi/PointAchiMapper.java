package com.orangedracon.geochiever.sql.point_achi;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author orangeDracon
 */
public class PointAchiMapper implements RowMapper<PointAchi>{
    
    public PointAchi mapRow(ResultSet resultSet, int row) throws SQLException {
        
        PointAchi pointAchi = new PointAchi();
        pointAchi.setId(resultSet.getInt("id"));
        pointAchi.setName(resultSet.getString("name"));
        pointAchi.setDescription(resultSet.getString("description"));
        pointAchi.setInfo(resultSet.getString("info"));
        pointAchi.setType(resultSet.getString("type"));
        pointAchi.setLatitude(resultSet.getDouble("latitude"));
        pointAchi.setLongitude(resultSet.getDouble("longitude"));
        pointAchi.setZone(resultSet.getDouble("zone"));
        pointAchi.setDate_added(resultSet.getDate("date_added"));
        pointAchi.setLogo_url(resultSet.getString("logo_url"));   
        pointAchi.setActive(resultSet.getInt("active"));
        
        return pointAchi;
    }
    
}
