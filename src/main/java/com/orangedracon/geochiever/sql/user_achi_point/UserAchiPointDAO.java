package com.orangedracon.geochiever.sql.user_achi_point;

import java.util.Date;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author orangeDracon
 */
public interface UserAchiPointDAO {
    
    public void setDataSource(DataSource dataSource);
    
    public UserAchiPoint getUserAchiPointData_byId(String id);
    
    public int getUserAchiPointCount_byUsername(String username); 
    
    public List<UserAchiPoint> getUserAchiPointRatingsList(); 
    
    public void insertNewUserAchiPoint(int user_id, int achievement_id);
    
    //public int getUserAchiPointRatingPosition_byUsername(String username); 
}
