package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sveinn on 25.10.2014.
 */
public class DriverData extends RuData implements DriverDataGateway
{
    @Override
    public List<Product> getAllProducts()
    {
        JdbcTemplate template = new JdbcTemplate(getDataSource());

        List<Product> products;
        products = template.query("select * from ru_products", new ProductRowMapper());
        return products;
    }

    @Override
    public List<Review> getReviewsByProductId(int productId)
    {
        JdbcTemplate template = new JdbcTemplate(getDataSource());
        return template.query("select * from ru_reviews " +
                              "where productid = " + productId, new ReviewRowmapper());
    }

    @Override
    public void addReview(int productId, int riderId, int rating, int tripId, String comment) throws AddReviewException
    {
        Review review = new Review();
        SimpleJdbcInsert insert = new SimpleJdbcInsert(getDataSource())
                                      .withTableName("ru_reviews")
                                      .usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(5);
        parameters.put("reviewerid", riderId);
        parameters.put("productid", productId);
        parameters.put("tripid", tripId);
        parameters.put("comment", comment);

        try
        {
            insert.execute(parameters);
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new AddReviewException("Error adding review", divex);
        }
    }


}

