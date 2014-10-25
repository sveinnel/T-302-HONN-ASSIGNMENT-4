package is.ru.honn.ruber.rides.service;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.rides.data.RideDataGateway;

/**
 * Created by emil on 24.10.2014.
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
    public History getTrips(int riderId) {
        return tripDataGateway.getTrips(riderId, offset, limit);
    }
}
