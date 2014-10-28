/*
 * @(#)Trip.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain.pojo;

import java.sql.Timestamp;

/**
 * Pojo Class holding one trip/ride
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class Trip
{
    protected int id;
    protected Timestamp requestTime;
    protected int productId;
    protected TripStatus status;
    protected double distance;
    protected Timestamp startTime;
    protected Timestamp endTime;
    protected double startLongitude;
    protected double endLongitude;
    protected double startLatitude;
    protected double endLatitude;
    protected int riderId;


    public Trip() {

    }

    public Trip(int id, Timestamp requestTime, int productId, TripStatus status, double distance, Timestamp startTime, Timestamp endTime)
    {
        this.id = id;
        this.requestTime = requestTime;
        this.productId = productId;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Trip(Timestamp requestTime, int productId, TripStatus status, double distance, Timestamp startTime, Timestamp endTime)
    {
        this.requestTime = requestTime;
        this.productId = productId;
        this.status = status;
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    public Trip(int id, int productId, Timestamp requestTime, Timestamp startTime, Timestamp endTime, float startlongitude, float endLongiTude, float startLatitude, float endLatitude, float distance, boolean completed, int riderId) {
        this.id = id;
        this.requestTime = requestTime;
        this.productId = productId;
        if(completed)
        {
            this.status = TripStatus.COMPLETED;
        }
        this.distance = distance;
        this.startTime = startTime;
        this.endTime = endTime;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Timestamp requestTime) {
        this.requestTime = requestTime;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public TripStatus getStatus() {
        return status;
    }

    public void setStatus(TripStatus status) {
        this.status = status;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }

    public int getRiderId() {
        return riderId;
    }

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }


    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", requestTime=" + requestTime +
                ", productId=" + productId +
                ", status=" + status +
                ", distance=" + distance +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", startLongitude=" + startLongitude +
                ", endLongitude=" + endLongitude +
                ", startLatitude=" + startLatitude +
                ", endLatitude=" + endLatitude +
                ", riderId=" + riderId +
                '}';
    }
}
