package is.ru.honn.ruber.drivers.data;

import is.ru.honn.ruber.domain.pojo.Price;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.Review;
import is.ru.honn.ruber.users.service.UserNotFoundException;
import is.ruframework.data.RuData;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import scala.util.Try;

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
    public Product getProductById(int id)
    {
        JdbcTemplate template = new JdbcTemplate(getDataSource());

        Product product;
        product = template.queryForObject("select * from ru_products " +
                                          "where id = " + Integer.toString(id),
                                           new ProductRowMapper());
        return product;
    }

    @Override
    public List<Review> getReviewsByProductId(int productId)
    {
        JdbcTemplate template = new JdbcTemplate(getDataSource());
        return template.query("select * from ru_reviews " +
                              "where productid = " + productId, new ReviewRowmapper());
    }

    @Override
    public Review addReview(int productId, int riderId, int rating, String comment) throws AddReviewException
    {
        Review review = new Review(riderId,productId,rating,comment);
        SimpleJdbcInsert insert = new SimpleJdbcInsert(getDataSource())
                                      .withTableName("ru_reviews")
                                      .usingGeneratedKeyColumns("id");
        Map<String, Object> parameters = new HashMap<String, Object>(5);
        parameters.put("reviewerid", review.getReviewerId());
        parameters.put("productid", review.getProductId());
        parameters.put("rating", review.getRating());
        parameters.put("comment", review.getComment());

        int key;
        try
        {
            key = insert.executeAndReturnKey(parameters).intValue();
        }
        catch(DataIntegrityViolationException divex)
        {
            throw new AddReviewException("Error adding review", divex);
        }
        review.setId(key);
        return review;
    }

    @Override
    public Price getPriceById(int id) throws PriceNotFoundException
    {
        JdbcTemplate template = new JdbcTemplate(getDataSource());
        Price price;
        try
        {
            price = (Price) template.queryForObject("select * from ru_prices where id = " + Integer.toString(id), new PriceRowMapper());
        }
        catch (EmptyResultDataAccessException erdaex)
        {
            throw new PriceNotFoundException("No price found with id: " + id);
        }
        return price;
    }


}

