/*
 * @(#)RideServiceData.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.rides.service;

import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Trip;
import is.ru.honn.ruber.rides.data.RideDataGateway;

/**
 * Service for data gateway
 * implements connection to
 * data storages
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class RideServiceData implements RidesService {

    private RideDataGateway tripDataGateway;

    public RideServiceData(RideDataGateway tripDataGateway) {
        this.tripDataGateway = tripDataGateway;
    }

    @Override
    public void addTrip(Trip trip) {
        tripDataGateway.addTrip( trip);
    }

    @Override
    public History getTrips(int riderId, int offset, int limit) {
        return tripDataGateway.getTrips(riderId, offset, limit);
    }
}
