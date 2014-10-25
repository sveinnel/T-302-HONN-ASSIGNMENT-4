package controllers;
import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.rides.RidesService;
import is.ru.honn.ruber.users.service.UserService;
import play.data.*;
import play.mvc.*;

import static play.libs.Json.toJson;

/**
 * Created by emil on 25.10.2014.
 */
public class DriverController extends UserController {

    public static Result getAllProducts() {
        DriverService driverService = (DriverService) driverCtx.getBean("driverService");
        return ok(toJson(driverService.getAllProducts()));
    }
}
