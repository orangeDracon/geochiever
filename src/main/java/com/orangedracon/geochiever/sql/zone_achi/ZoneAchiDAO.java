package com.orangedracon.geochiever.sql.zone_achi;

import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author orangeDracon
 */
public interface ZoneAchiDAO {
    
    public void setDataSource(DataSource dataSource);
    
    public ZoneAchi getZoneAchiData_byId(String id);
    
    public List<ZoneAchi> getAllZoneAchi();
    
    public List<ZoneAchi> getAchievedUserZoneAchi_byUsername(String username, int isActive);
    
    public List<ZoneAchi> getUndoneUserZoneAchi_byUsername(String username, int isActive);
    
    public List<ZoneAchi> getLatestZoneAchi_byUsername(String username);
}
