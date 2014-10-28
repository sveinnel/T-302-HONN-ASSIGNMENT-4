/*
 * @(#)RidesService.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.rides.service;

import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Trip;
import java.util.List;

/**
 * Interface for RidesService
 * Implementers should implement service that handles
 * manipulation for ride related queries
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public interface RidesService
{
    /**
     * Adds trip to database
     * @param trip Trip to be added
     */
    public void addTrip(Trip trip);

    /**
     * Returns History of a rider
     * @param riderId int User id of the rider
     * @param offset int Offset
     * @param limit int limit
     * @return History of trips for given rider
     */
    public History getTrips(int riderId ,int offset , int limit);
}
