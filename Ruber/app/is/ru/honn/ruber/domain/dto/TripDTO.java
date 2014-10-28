/*
 * @(#)TripDTO.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain.dto;

import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.TripStatus;
import is.ru.honn.ruber.domain.pojo.User;

import java.sql.Timestamp;

/**
 * DTO class used for sending Trip to client
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class TripDTO
{
    protected int id;
    protected Timestamp requestTime;
    protected ProductDTO product;
    protected TripStatus status;
    protected double distance;
    protected Timestamp startTime;
    protected Timestamp endTime;
    protected double startLongitude;
    protected double endLongitude;
    protected double startLatitude;
    protected double endLatitude;
    protected User rider;


    public TripDTO(int id, Timestamp requestTime, ProductDTO product, TripStatus status, double distance, Timestamp startTime, Timestamp endTime, double startLongitude, double endLongitude, double startLatitude, double endLatitude, User rider)
    {
        this.id = id;
        this.requestTime = requestTime;
        this.product = product;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLongitude = startLongitude;
        this.endLongitude = endLongitude;
        this.startLatitude = startLatitude;
        this.endLatitude = endLatitude;
        this.rider = rider;
    }

    public TripDTO(Timestamp requestTime, ProductDTO product, TripStatus status, double distance, Timestamp startTime, Timestamp endTime, double startLongitude, double endLongitude, double startLatitude, double endLatitude, User rider)
    {
        this.requestTime = requestTime;
        this.product = product;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
        this.startLongitude = startLongitude;
        this.endLongitude = endLongitude;
        this.startLatitude = startLatitude;
        this.endLatitude = endLatitude;
        this.rider = rider;
    }

    public int getId()
    {
        return id;
    }


    public void setId(int id)
    {
        this.id = id;
    }

    public Timestamp getRequestTime()
    {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime)
    {
        this.requestTime = requestTime;
    }

    public ProductDTO getProduct()
    {
        return product;
    }
    public void setProduct(ProductDTO product)
    {
        this.product = product;
    }

    public TripStatus getStatus()
    {
        return status;
    }

    public void setStatus(TripStatus status)
    {
        this.status = status;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }

    public Timestamp getStartTime()
    {
        return startTime;
    }

    public void setStartTime(Timestamp startTime)
    {
        this.startTime = startTime;
    }

    public Timestamp getEndTime()
    {
        return endTime;
    }

    public void setEndTime(Timestamp endTime)
    {
        this.endTime = endTime;
    }

    public double getStartLongitude()
    {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude)
    {
        this.startLongitude = startLongitude;
    }

    public double getEndLongitude()
    {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude)
    {
        this.endLongitude = endLongitude;
    }

    public double getStartLatitude()
    {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude)
    {
        this.startLatitude = startLatitude;
    }

    public double getEndLatitude()
    {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude)
    {
        this.endLatitude = endLatitude;
    }

    public User getRider()
    {
        return rider;
    }

    public void setRider(User rider)
    {
        this.rider = rider;
    }
}

