package is.ru.honn.ruber.rides;

import is.ru.honn.ruber.domain.Trip;
import java.util.List;

public interface RidesService
{
  public void addTrip(Trip trip);
  public List<Trip> getTrips(int userId);
}
