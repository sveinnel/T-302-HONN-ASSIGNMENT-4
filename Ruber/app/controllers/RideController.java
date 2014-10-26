package controllers;

import is.ru.honn.ruber.domain.dto.TripDTO;
import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Trip;
import is.ru.honn.ruber.domain.pojo.User;
import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.rides.service.RidesService;
import is.ru.honn.ruber.users.service.UserService;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by emil on 25.10.2014.
 */
public class RideController extends UserController
{
    private static RidesService rideService = (RidesService) rideCtx.getBean("RidesService");
    private static UserService  userService = (UserService)  userCtx.getBean("userService");
    private static DriverService driverService = (DriverService) driverCtx.getBean("driverService");


    public static Result getListOfTrips() {

        User user =  userService.getUser(session("username"));

        History history = rideService.getTrips(user.getId(),0,0);
        List<TripDTO> trips = new ArrayList<>();

        try
        {
            for (Trip t : history.getTrips())
            {
                trips.add(new TripDTO(
                        t.getId(),
                        t.getRequestTime(),
                        driverService.getProductById(t.getProductId()),
                        t.getStatus(),
                        t.getDistance(),
                        t.getStartTime(),
                        t.getEndTime(),
                        t.getStartLongitude(),
                        t.getEndLongitude(),
                        t.getStartLatitude(),
                        t.getEndLatitude(),
                        userService.getUserById(t.getRiderId())
                ));
            }
        }
        catch (Exception e)
        {
            return badRequest("Error getting trips: " + e.getMessage());
        }
       return ok(toJson(trips));
    }
}
