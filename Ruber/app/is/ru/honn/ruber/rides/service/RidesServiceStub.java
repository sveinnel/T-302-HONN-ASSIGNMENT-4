package is.ru.honn.ruber.rides.service;


import is.ru.honn.ruber.domain.Trip;

import java.util.ArrayList;
import java.util.List;

public class RidesServiceStub implements RidesService
{
  List<Trip> theTrips = new ArrayList<Trip>();

  @Override
  public void addTrip(Trip trip)
  {
    theTrips.add(trip);
  }

  @Override
  public List<Trip> getTrips(int userId)
  {
    return theTrips;
  }
}

