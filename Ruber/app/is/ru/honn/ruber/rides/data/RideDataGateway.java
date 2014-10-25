package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.Trip;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by emil on 24.10.2014.
 */
public interface RideDataGateway extends RuDataAccess {
    public int addTrip(Trip trip);
    List<Trip> getTrips(int userId);
}
