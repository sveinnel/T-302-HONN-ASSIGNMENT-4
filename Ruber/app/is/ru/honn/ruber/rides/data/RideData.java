package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ru.honn.ruber.rides.RideInsertDatabaseExeption;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.*;
import java.util.*;
import java.sql.Date;
/**
 * Created by emil on 24.10.2014.
 */
public class RideData extends RuData implements RideDataGateway {
    @Override
    public int addTrip(Trip trip) {
        SimpleJdbcInsert insert =
                new SimpleJdbcInsert(getDataSource())
                .withTableName("ru_trips")
                .usingGeneratedKeyColumns("id");

    Map<String, Object> p = new HashMap<String, Object>(10);
        p.put("riderid",  trip.getRiderId());
        p.put("productid", trip.getProductId());
        p.put("requesttime", trip.getRequestTime());
        p.put("starttime", trip.getStartTime());
        p.put("endtime", trip.getEndTime());
        p.put("startlongitude", trip.getStartLongitude());
        p.put("endlongitude", trip.getEndLongitude());
        p.put("startlatitude", trip.getStartLatitude());
        p.put("endlatitude", trip.getEndLatitude());
        p.put("distance", trip.getDistance());
        p.put("completed", trip.getStatus() == TripStatus.COMPLETED);

        int returnKey;

        try{
            returnKey = insert.executeAndReturnKey(p).intValue();
        }catch (DataIntegrityViolationException divex){
            throw new RideInsertDatabaseExeption("Ride insert ex " + trip.getProductId() + divex.getMessage());
        }

        return returnKey;



    }

    @Override
    public List<Trip> getTrips(int riderId) {
        //Collection<String> trips;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        /**
         * new shit
         */


        List<Trip> trips = new ArrayList<Trip>();

        List<Map<String, Object>> rows = jdbcTemplate.queryForList("select * from ru_trips where riderId = '" + riderId + "'");

        for(Map a : rows){
            Trip t = new Trip();
            t.setId((Integer)a.get("id"));
            t.setProductId(Integer.parseInt(a.get("productid").toString()));
            t.setStartLongitude(Double.parseDouble(a.get("startlongitude").toString()));

            t.setStartLongitude(Double.parseDouble(a.get("endlongitude").toString()));

            t.setStartLongitude(Double.parseDouble(a.get("startlatitude").toString()));

            t.setStartLongitude(Double.parseDouble(a.get("endlatitude").toString()));
            t.setDistance(Double.parseDouble(a.get("distance").toString()));
            t.setRiderId(Integer.parseInt(a.get("riderid").toString()));
            String completed = a.get("completed").toString();
            t.setStatus(completed == "completed"? TripStatus.COMPLETED:null);


            long l= Long.parseLong(a.get("requesttime").toString());

            t.setRequestTime(new Date(l*1000L));
            log.info();
            //t.setStartTime(new Date(Long.parseLong(a.get("starttime").toString())*1000L));

            //t.setEndTime(new Date(Long.parseLong(a.get("endtime").toString())*1000L));


            trips.add(t);
        }

        return trips;
    }

}
