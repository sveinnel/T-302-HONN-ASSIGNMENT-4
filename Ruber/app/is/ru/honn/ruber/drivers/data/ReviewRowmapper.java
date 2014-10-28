/*
 * @(#)ReviewRowMapper.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.pojo.Review;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Extends RowMapper
 * Used to map sql rows to object
 * @author Sveinn Elmar Magnússon
 * @author Emil Atli Ellegaard
 * @version 0.1, 28.Oct 2014
 */
public class ReviewRowmapper implements RowMapper<Review>
{
    @Override
    public Review mapRow(ResultSet rs, int i) throws SQLException
    {
        return new Review(rs.getInt("id"),
                          rs.getInt("reviewerid"),
                          rs.getInt("productid"),
                          rs.getInt("rating"),
                          rs.getString("comment"));
    }
}
