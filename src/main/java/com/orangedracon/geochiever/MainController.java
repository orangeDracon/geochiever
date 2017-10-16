package com.orangedracon.geochiever;

//import com.orangedracon.geochiever.sql.point_achi.augrel_achi.AugrelAchi;
import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.orangedracon.geochiever.sql.user.UserJDBCTemplate;
import com.orangedracon.geochiever.sql.user_roles.UserRoleJDBCTemplate;
import com.orangedracon.geochiever.sql.user.User;
//import com.orangedracon.geochiever.sql.point_achi.augrel_achi.AugrelAchiJDBCTemplate;
import com.orangedracon.geochiever.sql.point_achi.PointAchi;
import com.orangedracon.geochiever.sql.point_achi.PointAchiJDBCTemplate;
import com.orangedracon.geochiever.sql.user.UserValidator;
//import com.orangedracon.geochiever.sql.point_achi.user_achi_augrel.UserAchiAugrel;
import com.orangedracon.geochiever.sql.zone_achi.ZoneAchiJDBCTemplate;
//import com.orangedracon.geochiever.sql.point_achi.user_achi_augrel.UserAchiAugrelJDBCTemplate;
import com.orangedracon.geochiever.sql.user_achi_point.UserAchiPoint;
import com.orangedracon.geochiever.sql.user_achi_point.UserAchiPointJDBCTemplate;
import com.orangedracon.geochiever.sql.user_achi_zone.UserAchiZone;
import com.orangedracon.geochiever.sql.user_achi_zone.UserAchiZoneJDBCTemplate;
import com.orangedracon.geochiever.sql.zone_achi.ZoneAchi;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author orangeDracon
 */
@Controller
public class MainController {

    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    private static final int ACTIVE = 1;
    
    private static final String INTERNAL_FILE="/app/geochieverapp.apk";

    @Autowired
    private UserJDBCTemplate userJDBCTemplate;
    
    @Autowired
    private UserRoleJDBCTemplate userRoleJDBCTemplate;
    
    @Autowired
    private UserValidator userValidator;

//    @Autowired
//    private AugrelAchiJDBCTemplate augrelAchiJDBCTemplate;

    @Autowired
    private PointAchiJDBCTemplate pointAchiJDBCTemplate;

    @Autowired
    private ZoneAchiJDBCTemplate zoneAchiJDBCTemplate;

//    @Autowired
//    private UserAchiAugrelJDBCTemplate userAchiAugrelJDBCTemplate;

    @Autowired
    private UserAchiPointJDBCTemplate userAchiPointJDBCTemplate;

    @Autowired
    private UserAchiZoneJDBCTemplate userAchiZoneJDBCTemplate;

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcomePage(Model model) {
        model.addAttribute("message1", "Welcome to GEOCHIEVER");
        return "welcomePage";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model) {
        return "adminPage";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {

        return "loginPage";
    }

    @RequestMapping(value = "/logoutSuccessful", method = RequestMethod.GET)
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        String username = principal.getName();

        User user = userJDBCTemplate.getUserData_byUsername(username);

        model.addAttribute("userEmail", user.getEmail());
        model.addAttribute("userName", user.getUsername());
        model.addAttribute("userDistance", user.getDistance());  
  
        ///////////////////////////
        //int userAchiAugrelCount = userAchiAugrelJDBCTemplate.getUserAchiAugrelCount_byUsername(username);
        int userAchiPointCount = userAchiPointJDBCTemplate.getUserAchiPointCount_byUsername(username);
        int userAchiZoneCount = userAchiZoneJDBCTemplate.getUserAchiZoneCount_byUsername(username);
        int userAchiAllCount = /*userAchiAugrelCount +*/ userAchiPointCount + userAchiZoneCount;

        //model.addAttribute("userTotalAugRealAchievements", userAchiAugrelCount);
        model.addAttribute("userTotalPointAchievements", userAchiPointCount);
        model.addAttribute("userTotalZoneAchievements", userAchiZoneCount);
        model.addAttribute("userTotalAllAchievements", userAchiAllCount);

        ///////////////////////////
        //List<PointAchi> allPointAchiList = pointAchiJDBCTemplate.getAllPointAchi();
        //model.addAttribute("allPointAchiList", allPointAchiList);
        List<PointAchi> userAchievedLandmarkAchiList = pointAchiJDBCTemplate.getAchievedUserLandmarkAchi_byUsername(username, ACTIVE);
        model.addAttribute("userAchievedLandmarkAchiList", userAchievedLandmarkAchiList);

        List<PointAchi> userUndoneLandmarkAchiList = pointAchiJDBCTemplate.getUndoneUserLandmarkAchi_byUsername(username, ACTIVE);
        model.addAttribute("userUndoneLandmarkAchiList", userUndoneLandmarkAchiList);

        List<PointAchi> userAchievedTownAchiList = pointAchiJDBCTemplate.getAchievedUserTownAchi_byUsername(username, ACTIVE);
        model.addAttribute("userAchievedTownAchiList", userAchievedTownAchiList);

        List<PointAchi> userUndoneTownAchiList = pointAchiJDBCTemplate.getUndoneUserTownAchi_byUsername(username, ACTIVE);
        model.addAttribute("userUndoneTownAchiList", userUndoneTownAchiList);

        List<ZoneAchi> userAchievedZoneAchiList = zoneAchiJDBCTemplate.getAchievedUserZoneAchi_byUsername(username, ACTIVE);
        model.addAttribute("userAchievedZoneAchiList", userAchievedZoneAchiList);

        List<ZoneAchi> userUndoneZoneAchiList = zoneAchiJDBCTemplate.getUndoneUserZoneAchi_byUsername(username, ACTIVE);
        model.addAttribute("userUndoneZoneAchiList", userUndoneZoneAchiList);
        
//        List<AugrelAchi> userAchievedAugrelAchiList = augrelAchiJDBCTemplate.getAchievedUserAugrelAchi_byUsername(username, ACTIVE);
//        model.addAttribute("userAchievedAugrelAchiList", userAchievedAugrelAchiList);
//
//        List<AugrelAchi> userUndoneAugrelAchiList = augrelAchiJDBCTemplate.getUndoneUserAugrelAchi_byUsername(username, ACTIVE);
//        model.addAttribute("userUndoneAugrelAchiList", userUndoneAugrelAchiList);

        ///////////////////////////
        List<PointAchi> userLatestPointAchiList = pointAchiJDBCTemplate.getLatestPointAchi_byUsername(username);
        model.addAttribute("userLatestPointAchiList", userLatestPointAchiList);

        List<ZoneAchi> userLatestZoneAchiList = zoneAchiJDBCTemplate.getLatestZoneAchi_byUsername(username);
        model.addAttribute("userLatestZoneAchiList", userLatestZoneAchiList);

//        List<AugrelAchi> userLatestAugrelAchiList = augrelAchiJDBCTemplate.getLatestAugrelAchi_byUsername(username);
//        model.addAttribute("userLatestAugrelAchiList", userLatestAugrelAchiList);
        
        ///////////////////////////
        List<UserAchiPoint> userAchiPointRatingsList = userAchiPointJDBCTemplate.getUserAchiPointRatingsList();
        int userAchiPointRank_int = 0;
        Boolean foundUserAchiPoint = false;
        for (UserAchiPoint record : userAchiPointRatingsList){
            userAchiPointRank_int++;
            if(username.equals(record.getUsername())){
                foundUserAchiPoint = true;
                break;
            }
        }
        if(!foundUserAchiPoint){
            userAchiPointRank_int = 0;
        }
        String userAchiPointRank = "-";
        if(userAchiPointRank_int != 0){
            userAchiPointRank = Integer.toString(userAchiPointRank_int);
        }
        model.addAttribute("userAchiPointRank", userAchiPointRank);
        
        List<UserAchiZone> userAchiZoneRatingsList = userAchiZoneJDBCTemplate.getUserAchiZoneRatingsList();
        int userAchiZoneRank_int = 0;
        Boolean foundZoneAchiPoint = false;
        for (UserAchiZone record : userAchiZoneRatingsList){
            userAchiZoneRank_int++;
            if(username.equals(record.getUsername())){
                foundZoneAchiPoint = true;
                break;
            }
        }
        if(!foundZoneAchiPoint){
            userAchiZoneRank_int = 0;
        }
        String userAchiZoneRank = "-";
        if(userAchiZoneRank_int != 0){
            userAchiZoneRank = Integer.toString(userAchiZoneRank_int);
        }
        model.addAttribute("userAchiZoneRank", userAchiZoneRank);
        
//        List<UserAchiAugrel> userAchiAugrelRatingsList = userAchiAugrelJDBCTemplate.getUserAchiAugrelRatingsList();
//        int userAchiAugrelRank_int = 0;
//        Boolean foundAugrelAchiPoint = false;
//        for (UserAchiAugrel record : userAchiAugrelRatingsList){
//            userAchiAugrelRank_int++;
//            if(username.equals(record.getUsername())){
//                foundAugrelAchiPoint = true;
//                break;
//            }
//        }
//        if(!foundAugrelAchiPoint){
//            userAchiAugrelRank_int = 0;
//        }
//        String userAchiAugrelRank = "-";
//        if(userAchiAugrelRank_int != 0){
//            userAchiAugrelRank = Integer.toString(userAchiAugrelRank_int);
//        }
//        model.addAttribute("userAchiAugrelRank", userAchiAugrelRank);
        
        return "userProfile";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            model.addAttribute("message", "Hi " + principal.getName()
                    + "<br> You do not have permission to access this page!");
        } else {
            model.addAttribute("msg",
                    "You do not have permission to access this page!");
        }
        return "403Page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerPage(Model model) {
        model.addAttribute("registerForm", new User());

        return "registerPage";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPage(@ModelAttribute("registerForm") User registerForm, BindingResult bindingResult, Model model) {
        userValidator.validate(registerForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registerPage";
        }
        
        userJDBCTemplate.createNewUser(registerForm.getUsername(), registerForm.getEmail(), registerForm.getPassword());
        int id_user = userJDBCTemplate.getUserId_byUsername(registerForm.getUsername());
        userRoleJDBCTemplate.createNewUserRole_ROLE_USER(id_user);
        

        return "redirect:/login";
    }

    @RequestMapping(value = "/achievements", method = RequestMethod.GET)
    public String achievementsPage(Model model) {

        return "achievementsPage";
    }

    @RequestMapping(value = "/ratings", method = RequestMethod.GET)
    public String ratingsPage(Model model) {

        List<UserAchiPoint> userAchiPointRatingsList = userAchiPointJDBCTemplate.getUserAchiPointRatingsList();
        model.addAttribute("userAchiPointRatingsList", userAchiPointRatingsList);
        
        List<UserAchiZone> userAchiZoneRatingsList = userAchiZoneJDBCTemplate.getUserAchiZoneRatingsList();
        model.addAttribute("userAchiZoneRatingsList", userAchiZoneRatingsList);
        
//        List<UserAchiAugrel> userAchiAugrelRatingsList = userAchiAugrelJDBCTemplate.getUserAchiAugrelRatingsList();
//        model.addAttribute("userAchiAugrelRatingsList", userAchiAugrelRatingsList);
        
        return "ratingsPage";
    }
    
    
    @RequestMapping(value="/download/{type}", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException {
     
        File file = null;
         
        if(type.equalsIgnoreCase("internal")){
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
        }
         
        if(!file.exists()){
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }
         
//        String mimeType= URLConnection.guessContentTypeFromName(file.getName());
//        if(mimeType==null){
//            System.out.println("mimetype is not detectable, will take default");
//            mimeType = "application/octet-stream";
//        }
//         
//        System.out.println("mimetype : "+mimeType);
         
        response.setContentType("application/octet-stream");
         
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
 
         
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
         
        response.setContentLength((int)file.length());
 
        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
 
        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
    }
}