package controllers;

import is.ru.honn.ruber.domain.User;
import is.ru.honn.ruber.rides.RidesService;
import is.ru.honn.ruber.users.service.UserService;
import play.Logger;
import play.api.Play;
import play.mvc.*;

import static play.libs.Json.toJson;

/**
 * Created by emil on 25.10.2014.
 */
public class HomeController extends UserController {



    public static Result getListOfTrips() {
        RidesService rideService = (RidesService) ridesCtx.getBean("RidesService");
        UserService  userService = (UserService)  userCtx.getBean("userService");
        User user =  userService.getUser(session("username"));

       return ok(toJson(rideService.getTrips(user.getId())));
    }
}
