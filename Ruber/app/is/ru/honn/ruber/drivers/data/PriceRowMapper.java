/*
 * @(#)PriceRowMapper.java 0.1 28. Oct 2014 Sveinn Elmar Magnússon & Emil Ellegaard
 * Copyright (c) Sveinn Elmar Magnússon & Emil Ellegaard.
 */
package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.pojo.Price;
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
public class PriceRowMapper implements RowMapper<Price>
{
    @Override
    public Price mapRow(ResultSet rs, int i) throws SQLException
    {
        return new Price(
                rs.getInt("id"),
                rs.getString("currencycode"),
                ((double) rs.getFloat("lowestimate")),
                ((double) rs.getFloat("highestimate")),
                ((double) rs.getFloat("surgemultiplier")),
                ((double) rs.getFloat("finalprice"))
        );
    }
}
