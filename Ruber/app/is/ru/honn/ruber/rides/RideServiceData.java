package is.ru.honn.ruber.rides;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.rides.data.RideDataGateway;

import java.util.List;

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
    public List<Trip> getTrips(int userId) {
        return tripDataGateway.getTrips(userId);
    }
}
