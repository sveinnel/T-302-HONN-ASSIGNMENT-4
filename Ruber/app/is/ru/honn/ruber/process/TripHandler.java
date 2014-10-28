/*
 * @(#)TripHandler.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.process;

import is.ru.honn.ruber.domain.pojo.Trip;

/**
 * Interface for handling Trips
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public interface TripHandler
{
    /**
     * Adds trip to datastorage
     * @param trip Trip to be added
     */
    public void addTrip(Trip trip);
}
