package is.ru.honn.ruber.process;


import is.ru.honn.ruber.domain.pojo.Trip;
import is.ru.honn.ruber.domain.pojo.TripStatus;
import is.ruframework.http.SimpleHttpRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.logging.Logger;

public class TripReader
{
  TripHandler handler;

  public TripReader()
  {
  }

  public void setHandler(TripHandler handler)
  {
    this.handler = handler;
  }

  public void read(String url) throws ProcessException
  {
    Logger log = Logger.getAnonymousLogger();
    URL feedUrl = null;
    try
    {
      feedUrl = new URL(url);
    }
    catch(MalformedURLException murlex)
    {
      String tmp = "URL is not valid.";
      throw new ProcessException(tmp, murlex);
    }

    SimpleHttpRequest jsonRequest = new SimpleHttpRequest();
    JSONParser jsonParser = new JSONParser();

    try
    {
      String jsonString = jsonRequest.sendGetRequest(url);
      JSONObject jsonRoot = (JSONObject)jsonParser.parse(jsonString);
      JSONArray jsonHistory = (JSONArray)jsonRoot.get("history");

      for(int i=0; i<jsonHistory.size(); i++)
      {
        JSONObject jsonTrip = (JSONObject)jsonHistory.get(i);
        Trip trip = new Trip();

        trip.setRiderId(Integer.parseInt(jsonTrip.get("uuid").toString()));
        trip.setProductId(Integer.parseInt(jsonTrip.get("product_id").toString()));
        trip.setStatus(TripStatus.COMPLETED);
        trip.setDistance((Double)jsonTrip.get("distance"));
        trip.setRequestTime(new Timestamp(Long.parseLong(jsonTrip.get("request_time").toString()) * 1000L));
        trip.setStartTime(new Timestamp(Long.parseLong(jsonTrip.get("start_time").toString()) * 1000L));
        trip.setEndTime(new Timestamp(Long.parseLong(jsonTrip.get("end_time").toString()) * 1000L));
        handler.addTrip(trip);
      }
    }
    catch(Exception ex)
    {
      String tmp = "URL is not valid.";
      throw new ProcessException(tmp, ex);
    }
  }
}



