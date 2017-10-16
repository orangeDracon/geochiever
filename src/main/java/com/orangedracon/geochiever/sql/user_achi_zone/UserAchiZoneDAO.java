package com.orangedracon.geochiever.sql.user_achi_zone;

import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author orangeDracon
 */
public interface UserAchiZoneDAO {
    
    public void setDataSource(DataSource dataSource);
    
    public UserAchiZone getUserAchiZoneData_byId(String id);
    
    public int getUserAchiZoneCount_byUsername(String username); 
    
    public List<UserAchiZone> getUserAchiZoneRatingsList(); 
    
}
