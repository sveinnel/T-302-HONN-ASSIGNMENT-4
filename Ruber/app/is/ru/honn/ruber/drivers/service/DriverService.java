/*
 * @(#)DriverService.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.pojo.Price;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.Review;
import is.ru.honn.ruber.drivers.data.AddReviewException;
import is.ru.honn.ruber.drivers.data.PriceNotFoundException;

import java.util.List;

/**
 * Interface for DriverService
 * Implementers should implement service that handles
 * manipulation for driver related queries
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public interface DriverService
{
    /**
     * Returns list of all products
     * @return List of products
     */
    public List<Product> getAllProducts();

    /**
     * Returns product (taxi) by id
     * @param id int id of the product
     * @return Product
     */
    public Product getProductById(int id);

    /**
     * Returns all reviews by product id
     * @param productId int id of the product
     * @return List of Reviews
     */
    public List<Review> getReviewsByProductId(int productId);

    /**
     * Adds review to data storage
     * @param productId int id of the product
     * @param riderId int User id of the rider
     * @param rate int rating between 0-5
     * @param comment String comment about product
     * @return Review The newly added review
     * @throws AddReviewException
     */
    public Review addReview(int productId, int riderId, int rate, String comment) throws AddReviewException;

    /**
     * Returns Price object by id
     * @param id int id of the price
     * @return Price
     * @throws PriceNotFoundException
     */
    public Price getPriceById(int id) throws PriceNotFoundException;

    /**
     * Returns products by driver id
     * @param driverid int id of the driver
     * @return List of Product
     */
    public List<Product> getProductsByDriverId(int driverid);
}
