package com.orangedracon.geochiever.sql.point_achi;

import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author orangeDracon
 */
public interface PointAchiDAO {
    
    public void setDataSource(DataSource dataSource);
    
    public PointAchi getPointAchiData_byId(String id);
    
    public List<PointAchi> getAllPointAchi();
    
    public List<PointAchi> getAchievedUserLandmarkAchi_byUsername(String username, int isActive);
    
    public List<PointAchi> getUndoneUserLandmarkAchi_byUsername(String username, int isActive);
    
    public List<PointAchi> getAchievedUserTownAchi_byUsername(String username, int isActive);
    
    public List<PointAchi> getUndoneUserTownAchi_byUsername(String username, int isActive);
    
    public List<PointAchi> getLatestPointAchi_byUsername(String username);
    
    public int getPointAchiData_byName(String name);
}
