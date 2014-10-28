/*
 * @(#)History.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.domain.pojo;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo Class holding history of trips
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class History
{
  protected int offset;
  protected int limit;
  protected int count;
  protected List<Trip> history = new ArrayList<Trip>();

  public History(int offset, int limit)
  {
    this.offset = offset;
    this.limit = limit;
    this.count = 0;
  }


  public History()
  {
    this.count = 0;
  }

  public int getOffset()
  {
    return offset;
  }

  public void setOffset(int offset)
  {
    this.offset = offset;
  }

  public int getLimit()
  {
    return limit;
  }

  public void setLimit(int limit)
  {
    this.limit = limit;
  }

  public int getCount()
  {
    return count;
  }

  public void setCount(int count)
  {
    this.count = count;
  }

  public void addTrip(Trip trip)
  {
    count++;
    history.add(trip);
  }

  public List<Trip> getTrips()
  {
    if(limit <= 0)
       return history;
    else
        return history.subList(offset,offset + limit);
  }
}

