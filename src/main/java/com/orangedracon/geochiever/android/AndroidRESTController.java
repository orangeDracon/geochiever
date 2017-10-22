package com.orangedracon.geochiever.android;

import com.orangedracon.geochiever.MainController;
import com.orangedracon.geochiever.sql.point_achi.PointAchi;
import com.orangedracon.geochiever.sql.point_achi.PointAchiJDBCTemplate;
import com.orangedracon.geochiever.sql.user.User;
import com.orangedracon.geochiever.sql.user.UserJDBCTemplate;
import com.orangedracon.geochiever.sql.user_achi_point.UserAchiPointJDBCTemplate;
import com.orangedracon.geochiever.sql.user_achi_zone.UserAchiZoneJDBCTemplate;
import com.orangedracon.geochiever.sql.zone_achi.ZoneAchi;
import com.orangedracon.geochiever.sql.zone_achi.ZoneAchiJDBCTemplate;
import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author orangeDracon
 */
@RestController
public class AndroidRESTController {

	private static final Logger logger = LoggerFactory.getLogger(MainController.class);

	private static final int ACTIVE = 1;

	@Autowired
	private UserJDBCTemplate userJDBCTemplate;

	@Autowired
	private PointAchiJDBCTemplate pointAchiJDBCTemplate;

	@Autowired
	private ZoneAchiJDBCTemplate zoneAchiJDBCTemplate;

	@Autowired
	private UserAchiPointJDBCTemplate userAchiPointJDBCTemplate;

	@Autowired
	private UserAchiZoneJDBCTemplate userAchiZoneJDBCTemplate;

	@RequestMapping(value = "/user/{username}")
	public ResponseEntity<User> getUserById(@PathVariable("username") String username) {

		User user = userJDBCTemplate.getUserData_byUsername(username);

		return new ResponseEntity<User>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/undonelandmark/{username}")
	public ResponseEntity<List<PointAchi>> getUndoneLandmarkAchi(@PathVariable("username") String username) {

		List<PointAchi> userUndoneLandmarkAchiList = pointAchiJDBCTemplate
				.getUndoneUserLandmarkAchi_byUsername(username, ACTIVE);

		return new ResponseEntity<List<PointAchi>>(userUndoneLandmarkAchiList, HttpStatus.OK);
	}

	@RequestMapping(value = "/undonetown/{username}")
	public ResponseEntity<List<PointAchi>> getUndoneTownAchi(@PathVariable("username") String username) {

		List<PointAchi> userUndoneTownAchiList = pointAchiJDBCTemplate.getUndoneUserTownAchi_byUsername(username,
				ACTIVE);

		return new ResponseEntity<List<PointAchi>>(userUndoneTownAchiList, HttpStatus.OK);
	}

	@RequestMapping(value = "/claimed/{username}", method = RequestMethod.POST)
	public void addClaimedAchiToDatabase(@PathVariable("username") String username, @RequestBody String claimedList) {

		int user_id = userJDBCTemplate.getUserId_byUsername(username);

		String[] formatedclaimedList = claimedList.split(":");

		for (String record : formatedclaimedList) {
			if (StringUtils.isNotBlank(record)) {
				int achievement_id = pointAchiJDBCTemplate.getPointAchiData_byName(record);

				userAchiPointJDBCTemplate.insertNewUserAchiPoint(user_id, achievement_id);
			}
		}

//		PointAchi singlePointAchie;
//		int achievement_id = pointAchiJDBCTemplate.getPointAchiData_byName(formatedclaimedList[0]);
//		singlePointAchie = pointAchiJDBCTemplate.getPointAchiData_byId(String.valueOf(achievement_id));


		// singleZoneAchie =
		// zoneAchiJDBCTemplate.getZoneAchiData_byCoordinates(Math.ceil(singlePointAchie.getLatitude()),
		// Math.floor(singlePointAchie.getLongitude())));
		int singleZoneAchie = zoneAchiJDBCTemplate.getZoneAchiId_byCoordinates(52, 20);

		userAchiZoneJDBCTemplate.insertNewUserAchiZone(user_id, singleZoneAchie);

	}
}