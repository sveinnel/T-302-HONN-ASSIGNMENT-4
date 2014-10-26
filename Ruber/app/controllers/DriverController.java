package controllers;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.dto.ProductDTO;
import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.users.service.UserService;
import play.mvc.*;

import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * Created by emil on 25.10.2014.
 */
public class DriverController extends UserController {

    public static Result getAllProducts() {
        DriverService driverService = (DriverService) driverCtx.getBean("driverService");
        UserService userService = (UserService) userCtx.getBean("userService");
        List<ProductDTO> products = new ArrayList<>();
        try
        {
            for (Product p : driverService.getAllProducts())
            {
                products.add(new ProductDTO(
                        p.getId(),
                        p.getDescription(),
                        p.getDisplayName(),
                        p.getCapacity(),
                        p.getImage(),
                        userService.getUserById(p.getDriverId()),
                        driverService.getPriceById(p.getPriceId())
                ));
            }
            return ok(toJson(products));
        }
        catch(Exception e)
        {
            return internalServerError(e.getMessage());
        }
    }
}
