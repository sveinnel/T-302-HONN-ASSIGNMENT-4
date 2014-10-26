package is.ru.honn.ruber.drivers.service;

import is.ru.honn.ruber.domain.pojo.Price;
import is.ru.honn.ruber.domain.pojo.Product;
import is.ru.honn.ruber.domain.pojo.Review;
import is.ru.honn.ruber.drivers.data.AddReviewException;
import is.ru.honn.ruber.drivers.data.PriceNotFoundException;

import java.util.List;

/**
 * Created by sveinn on 25.10.2014.
 */
public interface DriverService
{
    public List<Product> getAllProducts();
    public Product getProductById(int id);
    public List<Review> getReviewsByProductId(int productId);
    public void addReview(int productId, int riderId, int rate, int tripId, String comment) throws AddReviewException;
    public Price getPriceById(int id) throws PriceNotFoundException;
}
