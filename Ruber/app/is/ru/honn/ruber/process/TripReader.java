package is.ru.honn.ruber.process;


import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ruframework.http.SimpleHttpRequest;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
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
        log.info("Jsonstring : \n" + jsonString );
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
        trip.setRequestTime(new Date(Integer.parseInt(jsonTrip.get("request_time").toString()) * 1000));
        trip.setStartTime(new Date(Integer.parseInt(jsonTrip.get("start_time").toString()) * 1000));
        trip.setEndTime(new Date(Integer.parseInt(jsonTrip.get("end_time").toString()) * 1000));
        log.info(trip.toString());
        log.info("\n");
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



