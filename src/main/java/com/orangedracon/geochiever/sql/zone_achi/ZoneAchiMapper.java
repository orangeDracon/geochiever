package com.orangedracon.geochiever.sql.zone_achi;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author orangeDracon
 */
public class ZoneAchiMapper implements RowMapper<ZoneAchi>{
    
    public ZoneAchi mapRow(ResultSet resultSet, int row) throws SQLException {
        
        ZoneAchi zoneAchi = new ZoneAchi();
        zoneAchi.setId(resultSet.getInt("id"));
        zoneAchi.setName(resultSet.getString("name"));
        zoneAchi.setDescription(resultSet.getString("description"));
        zoneAchi.setInfo(resultSet.getString("info"));
        zoneAchi.setNorth_border(resultSet.getDouble("north_border"));
        zoneAchi.setSouth_border(resultSet.getDouble("south_border"));
        zoneAchi.setEast_border(resultSet.getDouble("east_border"));
        zoneAchi.setWest_border(resultSet.getDouble("west_border"));
        zoneAchi.setCountry_type(resultSet.getString("country_type"));
        zoneAchi.setDate_added(resultSet.getDate("date_added"));
        zoneAchi.setLogo_url(resultSet.getString("logo_url")); 
        zoneAchi.setActive(resultSet.getInt("active"));
        
        return zoneAchi;
    }
    
}