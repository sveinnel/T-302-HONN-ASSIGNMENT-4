/*
 * @(#)DriverDataGateway.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.pojo.Price;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.Review;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Interface for data gateway
 * Implementers implement connection to
 * data storages
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public interface DriverDataGateway extends RuDataAccess
{
    /**
     * Returns list of all Products (Taxis)
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
     * @param rating int rating between 0-5
     * @param comment String comment about product
     * @return Review The newly added review
     * @throws AddReviewException
     */
    public Review addReview(int productId, int riderId, int rating, String comment) throws AddReviewException;

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
