package is.ru.honn.ruber.rides.data;

import is.ru.honn.ruber.domain.History;
import is.ru.honn.ruber.domain.Trip;
import is.ru.honn.ruber.domain.TripStatus;
import is.ru.honn.ruber.rides.service.RideInsertDatabaseExeption;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.sql.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public History getTrips(int riderId, int offset,int limit) {

        JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
        History history = new History(offset,limit);

        List<Map<String, Object>> rows = jdbcTemplate.queryForList(
                "select * from ru_trips where riderId = '" + riderId + "' AND completed = 1" );

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
            t.setStatus(Boolean.valueOf(a.get("completed").toString()) ? TripStatus.COMPLETED :null);
            t.setRequestTime(Timestamp.valueOf(a.get("requesttime").toString()));
            t.setStartTime(Timestamp.valueOf(a.get("starttime").toString()));
            t.setEndTime(Timestamp.valueOf(a.get("endtime").toString()));
            history.addTrip(t);
        }

        return history;
    }

}
