/*
 * @(#)DriverServiceData.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.pojo.Price;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.Review;
import is.ru.honn.ruber.drivers.data.AddReviewException;
import is.ru.honn.ruber.drivers.data.DriverDataGateway;
import is.ru.honn.ruber.drivers.data.PriceNotFoundException;
import is.ru.honn.ruber.users.service.UserService;

import java.util.List;
import java.util.logging.Logger;

/**
 * Service for data gateway
 * implements connection to
 * data storages
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class DriverServiceData implements DriverService
{
    private Logger log = Logger.getLogger(DriverServiceData.class.getName());

    private DriverDataGateway driverDataGateway;

    public DriverServiceData(DriverDataGateway driverDataGateway)
    {
        this.driverDataGateway = driverDataGateway;
    }


    @Override
    public List<Product> getAllProducts()
    {
        return driverDataGateway.getAllProducts();
    }

    @Override
    public Product getProductById(int id)
    {
        return driverDataGateway.getProductById(id);
    }

    @Override
    public List<Review> getReviewsByProductId(int productId)
    {
        return driverDataGateway.getReviewsByProductId(productId);
    }

    @Override
    public Review addReview(int productId, int riderId, int rating, String comment) throws AddReviewException
    {
        return driverDataGateway.addReview(productId, riderId, rating, comment);
    }

    @Override
    public Price getPriceById(int id) throws PriceNotFoundException
    {
        try
        {
            return driverDataGateway.getPriceById(id);
        } catch (PriceNotFoundException e)
        {
            throw e;
        }
    }

    @Override
    public List<Product> getProductsByDriverId(int driverid) {
        List<Product> products = driverDataGateway.getProductsByDriverId(driverid);

        return products;
    }
}
