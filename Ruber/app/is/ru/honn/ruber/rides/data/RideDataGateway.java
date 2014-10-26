package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Trip;
import is.ruframework.data.RuDataAccess;

import java.util.List;

/**
 * Created by emil on 24.10.2014.
 */
public interface RideDataGateway extends RuDataAccess {
    public int addTrip(Trip trip);
    History getTrips(int riderId, int offset, int limit);

}
