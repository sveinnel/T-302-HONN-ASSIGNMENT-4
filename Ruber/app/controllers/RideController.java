package controllers;

import is.ru.honn.ruber.domain.dto.ProductDTO;
import is.ru.honn.ruber.domain.dto.TripDTO;
import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.Trip;
import is.ru.honn.ruber.domain.pojo.User;
import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.rides.service.RidesService;
import is.ru.honn.ruber.users.service.UserService;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static play.libs.Json.toJson;

/**
 * Created by emil on 25.10.2014.
 */
public class RideController extends UserController
{
    private static RidesService rideService = (RidesService) rideCtx.getBean("RidesService");
    private static UserService  userService = (UserService)  userCtx.getBean("userService");
    private static DriverService driverService = (DriverService) driverCtx.getBean("driverService");

    /**
     * Get list of trips that the logged in user has
     * URL GET /rider/history
     * @return Json list of trips
     */
    public static Result getListOfTrips() {

        User user =  userService.getUser(session("username"));

        History history = rideService.getTrips(user.getId(),0,0);
        List<TripDTO> trips = new ArrayList<>();

        try
        {
            for (Trip t : history.getTrips())
            {
                Product product = driverService.getProductById(t.getProductId());
                ProductDTO productDTO = new ProductDTO(
                        product.getId(),
                        product.getDescription(),
                        product.getDisplayName(),
                        product.getCapacity(),
                        product.getImage(),
                        userService.getUserById(product.getDriverId()),
                        driverService.getPriceById(product.getPriceId())
                );
                trips.add(new TripDTO(
                        t.getId(),
                        t.getRequestTime(),
                        productDTO,
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
