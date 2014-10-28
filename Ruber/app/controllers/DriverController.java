/*
 * @(#)DriverController.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package controllers;
import com.fasterxml.jackson.databind.JsonNode;
import is.ru.honn.ruber.domain.dto.DriverDTO;
import is.ru.honn.ruber.domain.dto.ReviewDTO;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.dto.ProductDTO;
import is.ru.honn.ruber.domain.pojo.Review;
import is.ru.honn.ruber.domain.pojo.User;
import is.ru.honn.ruber.drivers.service.DriverService;
import is.ru.honn.ruber.users.service.UserService;
import play.Logger;
import play.mvc.*;
import views.html.drivers;


import java.util.ArrayList;
import java.util.List;

import static play.libs.Json.toJson;

/**
 * Driver Controller handles requests related to drivers
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class DriverController extends UserController {

    /**
     * Access to the services defined by beans
     */
    private static DriverService driverService = (DriverService) driverCtx.getBean("driverService");
    private static UserService userService = (UserService) userCtx.getBean("userService");

    /**
     * Gets all products form db from the db
     * URL GET /Products
     * @return Json array of all products
     */
    public static Result getAllProducts()
    {
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
            return notFound(e.getMessage());
        }
    }

    /**
     * Gets reviews by product Id
     * GET         /products/:productid/reviews
     * @param id integer id of a product
     * @return json product of drivers
     */
    public static Result getReviwsByProductId(int id)
    {

        List<ReviewDTO> reviews = new ArrayList<>();

        try
        {
            for (Review r : driverService.getReviewsByProductId(id))
            {
                reviews.add(new ReviewDTO(
                        r.getId(),
                        userService.getUserById(r.getReviewerId()),
                        driverService.getProductById(r.getProductId()),
                        r.getRating(),
                        r.getComment()
                ));
            }

            return ok(toJson(reviews));
        }
        catch (Exception e)
        {
            return notFound(e.getMessage());
        }
    }

    /**
     * Get all drivers from the user service only retrieves users marked as drivers
     * URL GET         /drivers
     * @return json drivers
     */
    public static Result  getDrivers(){

        try {
            List<User> users = userService.getDrivers();

            List<DriverDTO> drivers = new ArrayList<>();

            for (User u : users) {
                DriverDTO a = new DriverDTO(u, driverService.getProductsByDriverId(u.getId()));

                drivers.add(a);
            }
            return ok(toJson(drivers));
        }
        catch (Exception e){
            return notFound(e.getMessage());
        }
    };

    /**
     * Add a review to the product
     * URL POST /products/review
     * @return Result the product to be added
     */
    public static Result  addReview()
    {
        JsonNode json = request().body().asJson();
        if(json == null)
        {
            return badRequest("Expecting Json data");
        }
        else
        {
            int productId;
            int rating;
            String comment;
            Review review;

            try
            {

                productId = json.findPath("productId").asInt();
                rating = json.findPath("rating").asInt();
                comment = json.findPath("comment").asText();
            }
            catch (Exception e)
            {
                return badRequest("Error in Json data: " + e.getMessage());
            }
            try
            {
                review = driverService.addReview(productId, userService.getUser(session("username")).getId(), rating, comment);
            }
            catch (Exception e)
            {
                return badRequest("Error in request: " + e.getMessage());
            }
            return ok(toJson(new ReviewDTO(
                    review.getId(),
                    userService.getUserById(review.getReviewerId()),
                    driverService.getProductById(review.getProductId()),
                    review.getRating(),
                    review.getComment()
            )));
        }
    }


    /**
     * Render index of drivers
     * @return html.index site
     */
    public static Result index() {
        return ok(drivers.render("Welcome to Drivers"));
    }
}