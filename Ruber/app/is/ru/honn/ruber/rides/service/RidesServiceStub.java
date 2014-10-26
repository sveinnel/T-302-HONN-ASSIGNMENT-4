package is.ru.honn.ruber.rides.service;


import is.ru.honn.ruber.domain.pojo.History;
import is.ru.honn.ruber.domain.pojo.Trip;

import java.util.ArrayList;
import java.util.List;

public class RidesServiceStub implements RidesService
{
  //List<Trip> theTrips = new ArrayList<Trip>();
    History history = new History();
  @Override
  public void addTrip(Trip trip)
  {
   history.addTrip(trip);
  }

  @Override
  public History getTrips(int userId, int offset, int limmit)
  {
    return history;
  }
}

