package is.ru.honn.ruber.rides.service;

import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Trip;
import java.util.List;

public interface RidesService
{
  public void addTrip(Trip trip);
  public History getTrips(int riderId ,int offset , int limit);
}
