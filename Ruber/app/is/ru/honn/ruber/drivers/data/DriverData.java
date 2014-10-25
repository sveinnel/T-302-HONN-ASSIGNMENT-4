package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.Product;
import is.ru.honn.ruber.domain.Review;
import is.ruframework.data.RuData;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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
}
