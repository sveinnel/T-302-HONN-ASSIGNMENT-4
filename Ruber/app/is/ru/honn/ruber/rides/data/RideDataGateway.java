/*
 * @(#)RideDataGateway.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Trip;
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
public interface RideDataGateway extends RuDataAccess
{
    /**
     * Adds trip to datastorage
     * @param trip Trip to be added
     * @return Returns the Id of the newly added trip
     */
    public int addTrip(Trip trip);

    /**
     * Returns History
     * @param riderId int Id of the rider
     * @param offset int Offset (Where to start)
     * @param limit int limit (How many trips)
     * @return
     */
    History getTrips(int riderId, int offset, int limit);
}
